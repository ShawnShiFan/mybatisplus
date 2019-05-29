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
package com.shawn.mybatisplusdemo.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.shawn.mybatisplusdemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @Description
 * @Author: Shawn
 * @Date: 2019/5/29 10:25
 * @Version 1.0
 */
public interface UserMapper extends BaseMapper<User> {
 //   @Select("select * from user ${ew.customSqlSegment}")    //注解的方式
    List<User> selectAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
