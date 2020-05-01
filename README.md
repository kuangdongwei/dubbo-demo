# dubbodemo
 springboot+dubbo+zookeeper分布式调用简单demo



## 简介

本项目是基于springboot+dubbo+zookeeper搭建的一个简单的分布式RPC调用简单demo，可以借助此demo快速熟悉RPC框架的使用。无论是这里的dubbo，还是公司私有的RPC框架，它们的原理都大同小异，使用方式也基本类似。本项目有三个工程，各个工程的功能如下：

**dubbo-common:**   公共接口和实体

**dubbo-provider:**    提供（暴露）服务的程序

**dubbo-consumer:**    消费者程序

提供者工程项目和消费者工程项目其实都可以既提供服务，也可以消费别的工程项目提供的服务。更多的使用方式和原理介绍可以参考Apache dubbo官方文档。