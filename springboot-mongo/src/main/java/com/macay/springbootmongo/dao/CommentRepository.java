package com.macay.springbootmongo.dao;

import com.macay.springbootmongo.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @ClassName: CommentRepository
 * @Description:
 * @Author: Macay
 * @Date: 2023/6/23 2:35 下午
 */
//desc:评论的持久层接口
public interface CommentRepository extends MongoRepository<Comment, String> {

    //根据父id，查询子评论的分页列表
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
