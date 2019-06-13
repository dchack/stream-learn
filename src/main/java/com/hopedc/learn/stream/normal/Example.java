package com.hopedc.learn.stream.normal;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
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
        List<String> methodStrsStream = requestMethods.stream().map(RequestMethod::getName).collect(Collectors.toList());

        System.out.println("methodStrsStream:"+JSON.toJSONString(methodStrsStream));
    }

}
