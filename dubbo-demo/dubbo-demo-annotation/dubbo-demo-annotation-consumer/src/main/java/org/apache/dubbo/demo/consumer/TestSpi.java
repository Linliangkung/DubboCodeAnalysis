package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Filter;

import java.util.List;

/**
 * @Date 2019/10/10
 * @Author LLJ
 * @Description
 */
public class TestSpi {
    public static void main(String[] args) {
        ExtensionLoader<Filter> extensionLoader = ExtensionLoader.getExtensionLoader(Filter.class);
        /**
         * 1、key对应的parameter，如果参数前有-则剔除，否则添加
         * 2、parameter中有@Activate value的值则添加，或者@Activate value为空添加
         */
        List<Filter> dubbo = extensionLoader.getActivateExtension(new URL("dubbo", "127.0.0.1", 8080)
                .addParameter("deprecated","deprecated").addParameter("test","echo"),"test");

        /**
         * 获取适配器对象
         * 如果Spi类其中实现类有且只有一个含有@Adaptive注解，其就是该Spi类的适配器对象
         * 没有的话会动态生成一个适配器类，根据URL去动态生成对应的Spi实现类
         */
        Filter adaptiveExtension = extensionLoader.getAdaptiveExtension();
        System.out.println(dubbo);
    }
}
