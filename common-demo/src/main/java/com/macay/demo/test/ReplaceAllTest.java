package com.macay.demo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: ReplaceAllTest
 * @Description:
 * @Author: Macay
 * @Date: 2022/4/23 2:59 下午
 */
public class ReplaceAllTest {
    public static void main(String[] args) {
        System.out.println(camelToUnderline("passWord"));
        System.out.println(underlineToCamel("pass_word"));
    }


    /**
     * 驼峰转正则表达式
     * @param camelName
     * @return
     */
    public static String camelToUnderline(String camelName) {
        return camelName.replaceAll("([A-Z]+)", "_$1").toLowerCase();
    }

    /**
     * 正则表达式转驼峰
     * @param underlineName
     * @return
     */
    public static String underlineToCamel(String underlineName) {
        Matcher matcher = Pattern.compile("(_[a-z]{1})").matcher(underlineName);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String replacement = matcher.group(1);
            matcher.appendReplacement(result, replacement.replace("_", "").toUpperCase());
        }
        matcher.appendTail(result);
        return result.toString();
    }
}
