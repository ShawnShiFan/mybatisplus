package com.shawn.mongodb.dao.mongoDaoImp;

import com.shawn.mongodb.entity.Author;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author: Shawn
 * @Date: 2019/8/16 9:54
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDaoImplTest {

    @Resource
    private MongoDaoImpl mongoDaoImpl;

    @Test
    public void getAuthorByLikes() {

        Instant inst1 = Instant.now();  //当前的时间
        Date date1 = new Date();
        mongoDaoImpl.getAuthorByLikes(20000000);
        Long time = (System.currentTimeMillis() - date1.getTime());
        System.out.println(time);
        Instant inst2 = Instant.now();  //当前的时间
        System.out.println(Duration.between(inst1, inst2).toMillis());
        Assert.assertNotNull( mongoDaoImpl.getAuthorByLikes(123));
    }


    @Test
    public void getUpdateAuthorByLikes() {
        Date date1 = new Date();
        Author author = mongoDaoImpl.updateAuthorByLikes("shifan1", 30000000);
        Long time = (System.currentTimeMillis() - date1.getTime());
        System.out.println(time);
        System.out.println(author);
        Assert.assertNotNull(author);
    }

    @Test
    public void createAuthor() {
       Author author =new Author();
       author.setTitle("TEST");
       author.setLikes(300000002);
       author.setDescription("nothing");
       author.setBy("shifan2");
        Date date1 = new Date();
        Author createA = mongoDaoImpl.createAuthor(author);
        Long time = (System.currentTimeMillis() - date1.getTime());
        System.out.println(time);
        System.out.println(createA);
        Assert.assertNotNull(createA);


    }
}