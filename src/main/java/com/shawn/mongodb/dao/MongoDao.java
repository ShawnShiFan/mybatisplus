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
package com.shawn.mongodb.dao;

import com.shawn.mongodb.entity.Author;

/**
 * @Description
 * @Author: Shawn
 * @Date: 2019/8/5 18:29
 * @Version 1.0
 */
public interface MongoDao {
        Author getAuthorByLikes(Integer likes);

        Author updateAuthorByLikes(String byName, Integer likes);

        Author createAuthor(Author author);

        Boolean isAuthorExists(Integer likes);
}
