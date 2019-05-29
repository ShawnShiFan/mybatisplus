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
package com.shawn.mybatisplusdemo;

import com.shawn.mybatisplusdemo.dao.UserMapper;
import com.shawn.mybatisplusdemo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;


/**
 * @Description
 * @Author: Shawn
 * @Date: 2019/5/29 10:27
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class insertTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
       User user= new User();
        user.setName("测试非表字段");
        user.setAge(24);
        user.setEmail("1098818147@qq.com");
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());
        int rows =userMapper.insert(user);
        System.out.println("影响记录数："+rows);
        Assert.assertEquals(1,rows);
    }

}
