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

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.xml.XmlMapper;
import com.sun.xml.internal.txw2.Document;


import java.io.IOException;
import java.io.StringReader;

/**
 * @Description  xml 转json数据
 * @Author: Shawn
 * @Date: 2019/7/26 10:38
 * @Version 1.0
 */
public class xmlToJson {
    /**
     * xml 转json
     */
    public static JSONObject convertXmlToJson(String xml) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        JSONObject param = xmlMapper.readValue(xml, JSONObject.class);

        return param;
    }

    public static void main(String[] args){

        String xml = "<?xml version=\"1.0\" encoding=\"gb2312\"?>\n" +
                "<Schema>\n" +
                "    <Groups>\n" +
                "        <Group>\n" +
                "            <ID>sys_G0</ID>\n" +
                "            <Title>Industry</Title>\n" +
                "            <Order>1</Order>\n" +
                "        </Group>\n" +
                "        <Group>\n" +
                "            <ID>sys_G2</ID>\n" +
                "            <Title>EDC</Title>\n" +
                "            <Order>2</Order>\n" +
                "        </Group>\n" +
                "        <Group>\n" +
                "            <ID>sys_G4</ID>\n" +
                "            <Title>Receipt</Title>\n" +
                "            <Order>3</Order>\n" +
                "        </Group>\n" +
                "        <Group>\n" +
                "            <ID>sys_G5</ID>\n" +
                "            <Title>Tip</Title>\n" +
                "            <Order>4</Order>\n" +
                "        </Group>\n" +
                "        <Group>\n" +
                "            <ID>sys_G7</ID>\n" +
                "            <Title>Misc</Title>\n" +
                "            <Order>5</Order>\n" +
                "        </Group>\n" +
                "        <Group>\n" +
                "            <ID>sys_G6</ID>\n" +
                "            <Title>Communication</Title>\n" +
                "            <Order>7</Order>\n" +
                "        </Group>\n" +
                "        <Group>\n" +
                "            <ID>sys_G3</ID>\n" +
                "            <Title>Card Type</Title>\n" +
                "            <Order>8</Order>\n" +
                "        </Group>\n" +
                "        <Group>\n" +
                "            <ID>sys_GE</ID>\n" +
                "            <Title>EMV</Title>\n" +
                "            <Order>9</Order>\n" +
                "        </Group>\n" +
                "        <Group>\n" +
                "            <ID>sys_G1</ID>\n" +
                "            <Title>BroadPOS</Title>\n" +
                "            <Order>10</Order>\n" +
                "        </Group>\n" +
                "    </Groups>\n" +
                "    <Files>\n" +
                "        <File>\n" +
                "            <ID>sys_F1</ID>\n" +
                "            <FileName>sys_param.p</FileName>\n" +
                "        </File>\n" +
                "        <File>\n" +
                "            <ID>sys_F2</ID>\n" +
                "            <FileName>sys_cap.p</FileName>\n" +
                "        </File>\n" +
                "    </Files>\n" +
                "    <Parameters>\n" +
                "        <Header>\n" +
                "            <Title>Sub Applications</Title>\n" +
                "            <Display>false</Display>\n" +
                "            <DisplayStyle>foldable</DisplayStyle>\n" +
                "            <DefaultStyle>close</DefaultStyle>\n" +
                "            <Parameter>\n" +
                "                <Type>single</Type>\n" +
                "                <InputType>text</InputType>\n" +
                "                <DataType>Number_String</DataType>\n" +
                "                <PID>sys.param.keyAID</PID>\n" +
                "                <Title>Key Injection Application ID</Title>\n" +
                "                <Length>6</Length>\n" +
                "                <Required>false</Required>\n" +
                "                <Readonly>false</Readonly>\n" +
                "                <DefaultValue>keyld</DefaultValue>\n" +
                "                <Description>Key Injection Application ID</Description>\n" +
                "                <Display>false</Display>\n" +
                "                <GroupID>sys_G0</GroupID>\n" +
                "                <FileID>sys_F1</FileID>\n" +
                "            </Parameter>\n" +
                "            <Parameter>\n" +
                "                <Type>single</Type>\n" +
                "                <InputType>text</InputType>\n" +
                "                <DataType>Number_String</DataType>\n" +
                "                <PID>sys.param.tmsAID</PID>\n" +
                "                <Title>TMS Application ID</Title>\n" +
                "                <Length>6</Length>\n" +
                "                <Required>false</Required>\n" +
                "                <Readonly>false</Readonly>\n" +
                "                <Display>false</Display>\n" +
                "                <DefaultValue>bpagt</DefaultValue>\n" +
                "                <Description>TMS Application ID</Description>\n" +
                "                <GroupID>sys_G0</GroupID>\n" +
                "                <FileID>sys_F1</FileID>\n" +
                "            </Parameter>\n" +
                "        </Header>\n" +
                "        <Header>\n" +
                "            <Title>Auto Health Report</Title>\n" +
                "            <DisplayStyle>common</DisplayStyle>\n" +
                "            <Display>true</Display>\n" +
                "            <Parameter>\n" +
                "                <Type>single</Type>\n" +
                "                <InputType>select</InputType>\n" +
                "                <PID>sys.param.hrType</PID>\n" +
                "                <Title>Type</Title>\n" +
                "                <Required>true</Required>\n" +
                "                <Readonly>false</Readonly>\n" +
                "                <Display>true</Display>\n" +
                "                <Select>{\"N\":\"Disabled\",\"T\":\"Specific Time\",\"I\":\"Fixed Interval\"}</Select>\n" +
                "                <DefaultValue>I</DefaultValue>\n" +
                "                <Description>Health Report Type</Description>\n" +
                "                <GroupID>sys_G1</GroupID>\n" +
                "                <FileID>sys_F1</FileID>\n" +
                "            </Parameter>\n" +
                "            <Parameter>\n" +
                "                <Type>single</Type>\n" +
                "                <InputType>text</InputType>\n" +
                "                <DataType>Time_hhmm</DataType>\n" +
                "                <PID>sys.param.hrTime</PID>\n" +
                "                <Title>Time(hh:mm)</Title>\n" +
                "                <Length>5</Length>\n" +
                "                <Readonly>false</Readonly>\n" +
                "                <Display>true</Display>\n" +
                "                <DefaultValue>0600</DefaultValue>\n" +
                "                <Description>Time for health report</Description>\n" +
                "                <GroupID>sys_G1</GroupID>\n" +
                "                <FileID>sys_F1</FileID>\n" +
                "            </Parameter>\n" +
                "            <Parameter>\n" +
                "                <Type>single</Type>\n" +
                "                <InputType>text</InputType>\n" +
                "                <DataType>Number</DataType>\n" +
                "                <PID>sys.param.hrInterval</PID>\n" +
                "                <Title>Interval(100ms)</Title>\n" +
                "                <Length>8</Length>\n" +
                "                <Required>true</Required>\n" +
                "                <Readonly>false</Readonly>\n" +
                "                <Display>true</Display>\n" +
                "                <DefaultValue>864000</DefaultValue>\n" +
                "                <Description>Interval for health report</Description>\n" +
                "                <GroupID>sys_G1</GroupID>\n" +
                "                <FileID>sys_F1</FileID>\n" +
                "            </Parameter>\n" +
                "        </Header>\n" +
                "    </Parameters>\n" +
                "</Schema>";
        try {
            JSONObject param = convertXmlToJson(xml);
            String P2 ="{\"Schema\":"+param +"}";
            System.out.println(P2);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
