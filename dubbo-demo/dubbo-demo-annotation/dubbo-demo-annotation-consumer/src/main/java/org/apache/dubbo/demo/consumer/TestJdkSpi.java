package org.apache.dubbo.demo.consumer;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Date 2019/10/11
 * @Author LLJ
 * @Description
 */
public class TestJdkSpi {
    public static void main(String[] args){
        ServiceLoader<Animal> load = ServiceLoader.load(Animal.class);
        Iterator<Animal> iterator = load.iterator();
        while(iterator.hasNext()){
            iterator.next().say();
        }
    }
}
