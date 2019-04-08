简介

这个项目是一款有关于员工管理系统，该项目使用的框架为SSM

使用技术

IOC容器：Spring

Web框架：SpringMVC

ORM框架：Mybatis

安全框架：JSR303校验

数据源：C3P0

前端框架：Bootstrap

编译器：Eclipse 项目构建工具：Maven 版本控制工具：git 数据库：Mysql JDK版本：jdk1.7 Tomcat版本：Tomcat7.x 

整合spring springmvc mybatis框架，通过mybatis逆向工程生成mapper接口与mapper文件，且基于mapper之上定义一些新的复杂查询

bootstrap快速搭建ui界面，将能处理的请求交给SSM框架，不能的交给tomcat（静态资源）

前端采用html+css+js+bootstrap快速搭建员工列表，并引用pagehelper分页插件进行分页展示。

员工添加，员工修改对员工姓名与邮箱使用jQuery进行前端校验

运用js的ajax请求，展示页面运用json数据接收，得到更好的兼容性。后端添加JSR303校验，避免数据错误导入
。
