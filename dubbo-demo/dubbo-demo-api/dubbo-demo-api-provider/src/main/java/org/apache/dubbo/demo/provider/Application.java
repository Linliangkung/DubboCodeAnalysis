/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.dubbo.demo.provider;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.demo.DemoService;

public class Application {
    public static void main(String[] args) throws Exception {
        //创建ServiceConfig对象
        ServiceConfig<DemoServiceImpl> service = new ServiceConfig<>();
        //设置应用配置
        service.setApplication(new ApplicationConfig("dubbo-demo-api-provider"));
        //设置注册中心配置
        service.setRegistry(new RegistryConfig("nacos://192.168.15.129:8848"));
        //设置服务接口类型，通过接口方法对外暴露配置
        service.setInterface(DemoService.class);
        //设置服务接口实现类
        service.setRef(new DemoServiceImpl());
        //执行服务暴露逻辑
        service.export();
        System.in.read();
    }
}
