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
package com.shawn.mongodb.demo.connectMongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author: Shawn
 * @Date: 2019/8/5 14:59
 * @Version 1.0
 */
public class MongoDBJDBC {
    public static void main( String args[] ){
        try{
                // 连接到 mongodb 服务
                MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


                // 连接到数据库
                MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
                System.out.println("Connect to database successfully");

        /*        mongoDatabase.createCollection("test");
                System.out.println("集合创建成功");*/

               MongoCollection<Document> collection = mongoDatabase.getCollection("test");
               System.out.println("集合 test 选择成功");


            //插入文档
            /**
             * 1. 创建文档 org.bson.Document 参数为key-value的格式
             * 2. 创建文档集合List<Document>
             * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
             * */
            Instant inst1 = Instant.now();  //当前的时间
           for (int i = 0 ; i<30000000 ;i++){
                Document document = new Document("title", "MongoDBTest").
                        append("description", "database").
                        append("likes", i).
                        append("by", "Shawn");
                List<Document> documents = new ArrayList<Document>();
                documents.add(document);
                collection.insertMany(documents);
               System.out.println(Instant.now());
           }
            Instant inst2 = Instant.now();  //当前的时间
            Long time1 =  Duration.between(inst1, inst2).toMillis();
            System.out.println("文档插入成功");
            System.out.println("插入3000W条记录时间为："+time1);
            //检索所有文档
            /**
             * 1. 获取迭代器FindIterable<Document>
             * 2. 获取游标MongoCursor<Document>
             * 3. 通过游标遍历检索出的文档集合
             * */
        /*    FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }*/


            //更新文档   将文档中likes=100的文档修改为likes=200
       /*     collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));
            //检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }*/


        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

}
