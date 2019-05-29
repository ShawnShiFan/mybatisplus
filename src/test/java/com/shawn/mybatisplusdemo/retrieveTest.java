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

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shawn.mybatisplusdemo.dao.UserMapper;
import com.shawn.mybatisplusdemo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description
 * @Author: Shawn
 * @Date: 2019/5/29 10:27
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class retrieveTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectById(){
        User user =userMapper.selectById(1094590409767661570L);
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void selectBatchIds(){
        List<Long> idlist = Arrays.asList(1133570693187784706L,1133568330230259713L,1133565126243291138L);
        List<User> userList= userMapper.selectBatchIds(idlist);
        userList.forEach(System.out::println);
        Assert.assertEquals(3,userList.size());
    }

    @Test
    public void selectByMap(){
        //相当于
        //map.put("name","王天风")
        //map.put("age","30")
        //where name = "王天风" and age = 30
        Map<String,Object> columnMap = new HashMap<>();
        //columnMap.put("name","王天风");
        columnMap.put("age","25");
        List<User> userList = userMapper.selectByMap(columnMap);
        userList.forEach(System.out::println);
        Assert.assertEquals(1,userList.size());
    }
//条件构造器查询
    /**
     * 1.名字中含 雨 并且年龄小于40
     * name like '%雨%' and age<40
    * */

    @Test
    public void selectByWrapper1(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
      //  QueryWrapper<User> query = Wrappers.<User>query(); //效果同上
        queryWrapper.like("name","雨").lt("age",40);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 2.名字中含 雨 并且年龄大于20且小于等于40 并且email不能为空
     * name like '%雨%' and age between 20 and 40 email is not null
     * */

    @Test
    public void selectByWrapper2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //  QueryWrapper<User> query = Wrappers.<User>query(); //效果同上
        queryWrapper.like("name","雨").between("age",20,40).isNotNull("email");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }
    /**
     * 3.名字为王姓 或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列
     * name like '王%' and age >= 25 order by age desc,id asc
     * */

    @Test
    public void selectByWrapper3(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //  QueryWrapper<User> query = Wrappers.<User>query(); //效果同上
        queryWrapper.like("name","王").or().ge("age",25).lt("age",40).orderByDesc("age").orderByAsc("id");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 4.创建日期为2019年5月29日并且直属上级名字为王姓
     * date_format(create_time, '%Y-%m-%d') and manager_id in (select id form user where name like '王%')
     * */

    @Test
    public void selectByWrapper4(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //  QueryWrapper<User> query = Wrappers.<User>query(); //效果同上
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}","2019-05-29").inSql("manager_id","select id from user where name like '王%'");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 5.名字为王姓并且（年龄小于40或邮箱不为空）
     * name like '王%' and (age <40 or email is not null)
     * */

    @Test
    public void selectByWrapper5(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //  QueryWrapper<User> query = Wrappers.<User>query(); //效果同上
        queryWrapper.like("name","王").and(wq->wq.lt("age","40").or().isNotNull("email"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 6.名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
     * name like '王%' or (age < 40 and age > 20  and email is not null)
     * */

    @Test
    public void selectByWrapper6(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //  QueryWrapper<User> query = Wrappers.<User>query(); //效果同上
        queryWrapper.like("name","王").or(wq->wq.lt("age","40").
                and(w->w.gt("age","20").isNotNull("email")));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }
    @Test
    public void selectAll(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.<User> lambdaQuery();
        lambdaQueryWrapper.likeRight(User::getName,"王").and(lqw->lqw.lt(User::getAge,40).or().isNotNull(User::getEmail));
        List<User> userList = userMapper.selectAll(lambdaQueryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectPage(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.ge("age",26);
        Page<User> page = new Page<User>(1,2);

  /*      IPage<User> iPage = userMapper.selectPage(page,queryWrapper);
        System.out.println("总页数"+iPage.getPages());
        System.out.println("总记录数"+iPage.getTotal());
        List<User>  userList = iPage.getRecords();*/

        IPage<Map<String,Object>> iPage1 = userMapper.selectMapsPage(page,queryWrapper);
        System.out.println("总页数"+iPage1.getPages());
        System.out.println("总记录数"+iPage1.getTotal());
        List<Map<String,Object>> userList = iPage1.getRecords();
        userList.forEach(System.out::println);

    }
}
