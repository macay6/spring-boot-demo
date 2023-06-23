package com.macay.springbootmongo.service;

import com.macay.springbootmongo.domain.Comment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    /**
     * 通过id查询评论
     */
    @Test
    public void testFindCommentById(){
        Comment commentById = commentService.findCommentById("1");
        System.out.println(commentById);

    }

    /**
     * 保存一个评论
     */
    @Test
    public void testSaveComment(){
        Comment comment = new Comment();
        comment.setArticleid("100000");
        comment.setContent("测试添加的数据");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1006");
        comment.setNickname("xustudyxu");
        comment.setState("1");
        comment.setReplynum(0);
        comment.setReplynum(0);
        commentService.saveComment(comment);
    }

    /**
     * 查询全部评论
     */
    @Test
    public void testFindCommentList(){
        List<Comment> commentList = commentService.findCommentList();
        commentList.forEach(System.out::println);
    }

    /**
     * 测试根据父id查询子评论的分页列表
     */
    @Test
    public void testFindCommentListByParentid(){
        Page<Comment> pageResponse = commentService.findCommentListByParentid("3", 1, 2);
        System.out.println("---总记录数---:"+pageResponse.getTotalElements());
        System.out.println("---当前页数据---:"+pageResponse.getContent());
    }

    @Test
    public void testupdataCommentLikenum(){

        //对3号文档的点赞数+1
        commentService.updataCommentLikenum("3");
    }

}
