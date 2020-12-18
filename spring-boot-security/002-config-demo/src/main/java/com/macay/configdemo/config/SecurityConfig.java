package com.macay.configdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SecurityConfig
 * @Description:
 * @Author: Macay
 * @Date: 2020/12/16 4:03 下午
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 请求授权的规则
        http.authorizeRequests()  // 开启授权配置
                // 表示首页所有人都可以访问
                .antMatchers("/").permitAll()
                // 表示访问 /admin/** 这中规则的接口时，需要具备 admin 这个角色
                .antMatchers("/admin/**").hasRole("admin")
                // 表示访问 /user/** 这中规则的接口时，只需要具备 admin或user任意一种角色即可
                .antMatchers("/user/**").hasAnyRole("admin", "user")
                // 表示剩余的其他接口，登录之后就能访问
                .anyRequest().authenticated();

        //开启自动配置的登录功能：如果没有权限，就会跳转到登录页面！
        // login 请求来到登录页
        // login?error 重定向到这里表示登录失败
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
//                .loginPage("/toLogin")
//                .loginProcessingUrl("/login")
                // 使用与前后端分离的项目，返回登录成功后返回的Json
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        Map<String, Object> map = new HashMap<>();
                        map.put("statis", 200);
                        map.put("msg", authentication.getPrincipal());
                        out.write(new ObjectMapper().writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                // 登录失败后返回的Json
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        Map<String, Object> map = new HashMap<>();
                        map.put("statis", 401);
                        if (e instanceof LockedException) {
                            map.put("msg", "账号被锁定，登录异常");
                        } else if (e instanceof BadCredentialsException) {
                            map.put("msg", "用户名或密码输入错误，登录失败");
                        } else if (e instanceof AccountExpiredException) {
                            map.put("msg", "账户过期，登录失败");
                        } else if (e instanceof DisabledException) {
                            map.put("msg", "用户被禁用，登录失败");
                        } else if (e instanceof CredentialsExpiredException) {
                            map.put("msg", "密码过期，登录失败");
                        } else {
                            map.put("msg", "登录失败");
                        }
                        out.write(new ObjectMapper().writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                });
        // 登陆表单提交请求

        http.csrf().disable();//关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
        //开启自动配置的注销的功能
        // logout 注销请求
        http.logout().logoutUrl("/logout")
        // 注销成功后返回的Json
        .logoutSuccessHandler(new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                Map<String, Object> map = new HashMap<>();
                map.put("statis", 200);
                map.put("msg", "注销登录成功");
                out.write(new ObjectMapper().writeValueAsString(map));
                out.flush();
                out.close();
            }
        });

        //记住我
        http.rememberMe().rememberMeParameter("remember");

    }

    // 认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 认证的规则
        // 在内存中定义，正常应该从数据库中去读
        // Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
        // spring security 官方推荐的是使用bcrypt加密方式。
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("macay").roles("admin").password(new BCryptPasswordEncoder().encode("123"))
                .and()
                .withUser("lisi").roles("user").password(new BCryptPasswordEncoder().encode("123"));
    }
}
