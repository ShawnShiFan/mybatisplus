/*
 * ********************************************************************************
 * COPYRIGHT
 *               PAX TECHNOLOGY, Inc. PROPRIETARY INFORMATION
 *   This software is supplied under the terms of a license agreement or
 *   nondisclosure agreement with PAX  Technology, Inc. and may not be copied
 *   or disclosed except in accordance with the terms in that agreement.
 *
 *      Copyright (C) 2017 PAX Technology, Inc. All rights reserved.
 * ********************************************************************************
 */
package com.shawn.mongodb.dao.mongoDaoImp;

import com.shawn.mongodb.dao.MongoDao;
import com.shawn.mongodb.entity.Author;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description
 * @Author: Shawn
 * @Date: 2019/8/16 9:33
 * @Version 1.0
 */
@Component
public class MongoDaoImpl implements MongoDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public Author getAuthorByLikes(Integer likes) {
        Query query = new Query();
        query.addCriteria(Criteria.where("likes").is(likes));
        if (!mongoTemplate.exists(query,Author.class))
            return  null;
        return mongoTemplate.findOne(query,Author.class);
    }

    @Override
    public Author updateAuthorByLikes(String byName,Integer likes) {
        Query query = new Query();
        query.addCriteria(Criteria.where("likes").is(likes));
        Update update = new Update();
        update.set("by",byName);
        mongoTemplate.upsert(query,update,Author.class);
        return mongoTemplate.findOne(query,Author.class);
    }

    @Override
    public Author createAuthor(Author author) {
        if (isAuthorExists(author.getLikes())){
            return null;
        }
        Author newAuthor =new Author();
        newAuthor.setTitle(author.getTitle());
        newAuthor.setDescription(author.getDescription());
        newAuthor.setLikes(author.getLikes());
        newAuthor.setBy(author.getBy());
       return  mongoTemplate.insert(newAuthor);
    }

    @Override
    public Boolean isAuthorExists(Integer likes) {
       Query query = new Query(Criteria.where("likes").is(likes));
       return mongoTemplate.exists(query,Author.class);
    }


}
