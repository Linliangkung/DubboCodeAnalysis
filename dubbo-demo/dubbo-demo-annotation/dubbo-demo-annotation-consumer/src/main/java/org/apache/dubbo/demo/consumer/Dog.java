package org.apache.dubbo.demo.consumer;

/**
 * @Date 2019/10/11
 * @Author LLJ
 * @Description
 */
public class Dog implements Animal {
    @Override
    public void say() {
        System.out.println("汪汪汪");
    }
}
