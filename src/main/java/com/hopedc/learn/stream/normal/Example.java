package com.hopedc.learn.stream.normal;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example {

    private static List<RequestMethod> requestMethods;
    static {
        requestMethods = new ArrayList<>();
        requestMethods.add(new RequestMethod.RequestMethodBuilder().name("test1").desc("desc1").argsNum(1).build());
        requestMethods.add(new RequestMethod.RequestMethodBuilder().name("test2").desc("desc2").argsNum(2).build());
        requestMethods.add(new RequestMethod.RequestMethodBuilder().name("test3").desc("desc3").argsNum(3).build());
    }

    public static void main(String[] args) {
        getListName();
        getListToMap();
    }

    private static void getListName(){
        // 遍历一个list，获取其中一个字段内容，组装新的list返回
        // 正常一个for循环的代码
        List<String> methodStrs = new ArrayList<>();
        for (RequestMethod requestMethod : requestMethods) {
            methodStrs.add(requestMethod.getName());
        }
        System.out.println("methodStrs:"+JSON.toJSONString(methodStrs));

        // stream方式
        List<String> methodStrsStream = requestMethods.stream().map(RequestMethod::getName)
                .collect(Collectors.toList());

        System.out.println("methodStrsStream:"+JSON.toJSONString(methodStrsStream));
    }

    /**
     * List转Map，非常常见的场景
     */
    private static void getListToMap(){
        // 其中key和value都为字段
        Map<Integer, String> result = requestMethods.stream()
                .collect(Collectors.toMap(RequestMethod::getArgsNum, RequestMethod::getName));
        System.out.println("getListToMap:"+JSON.toJSONString(result));
        // key为字段value为list内对象
        Map<String, RequestMethod> partsMap = requestMethods.stream()
                .collect(Collectors.toMap(k -> k.getName()+k.getArgsNum(), part -> part));
        System.out.println("partsMap:"+JSON.toJSONString(partsMap));
    }



}
