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
package utils;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * @Description
 * @Author: Shawn
 * @Date: 2019/8/2 14:46
 * @Version 1.0
 */
public class StartTimeBetweenEndTime {
    public static void main(String[] args){
        Instant inst1 = Instant.now();  //当前的时间
        System.out.println("Inst1：" + inst1);
        Instant inst2 = inst1.plus(Duration.ofSeconds(10));     //当前时间+10秒后的时间
        System.out.println("Inst2：" + inst2);
        Instant inst3 = inst1.plus(Duration.ofDays(125));       //当前时间+125天后的时间
        System.out.println("inst3：" + inst3);
        Long time1 =  Duration.between(inst1, inst2).toMillis();

        if(time1.longValue()>10000){
            System.out.println("以毫秒计的时间差："+time1.longValue());
        }


        System.out.println("以秒计的时间差：" + Duration.between(inst1, inst3).getSeconds());

    }
}
