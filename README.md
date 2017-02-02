## 说明

- 这个项目中共有三个文件夹：

  1. JDBC_Oracle<br>
    这个文件夹中的demo是用JDBC连接Oracle的代码，这些demo几乎涵盖了了JDBC中所有常用的API，基本上可以完成80%常用的功能
  2. JDBC_Mysql<br>
    这个文件夹中只有一个demo，使用JDBC连接MySQL与Oracle的区别只是连接字符串上的差异，API的使用完全相同，你在使用MySQL的时候，可以参照Oracle的代码
  3. JDBC_ConnectionPool<br>
    这里是JDBC数据库连接池的demo，正在逐步更新

- 前两个demo是几年前初学Java时候写的代码了，这些代码并不是教程类的代码，只是留给我写代码时参考用的

- 第三个数据库连接池，我也是刚开始学习，我会把我学习中看到的一些有用的资源写成文档的形式，方便日后参考，也方便各位学习

## 数据库连接池简介

- 什么是数据库连接池？有什么用？<br>
  我们都知道，拿到数据库连接是一件非常耗费资源的事，大概是1s的数量级(看别人这么写的，具体没测试过)。这样的话，如果你的网站访问量较大，每个用户再进行数据操作时都去拿一个数据库连接的话是效率很低的一件事。这样的话，我们可以提前开启几个数据库连接，把它们放在一个连接池中，当需要的时候，直接从这个连接池中找一个可用的连接，用完之后再放回去，这样就极大的节约了资源
- 常见的数据库连接池有哪些？<br>
  我查了一下，目前常用的Java数据库连接池有：DBCP、C3P0、Proxool、BoneCP、HikariCP,这些连接池产品都可以在GitHub上找到，其中HikariCP现在star数量是3900+，其他都是几百个star。而且看到很多文章说到HikariCP的速度比其他产品快了很多。所以这个教程中的demo都是HikariCP的demo

## HikariCP

>这个demo需要的jar包有mysql-connector-java和HikariCP，如果用Maven，可以将下面的依赖加入到pom中

  ```
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.38</version>
    </dependency>
    <dependency>
        <groupId>com.zaxxer</groupId>
        <artifactId>HikariCP</artifactId>
        <version>2.5.1</version>
    </dependency>
  ```

>官方文档 https://github.com/brettwooldridge/HikariCP

- CP_0100_JDBCConnection  
JDBC连接MySQLdemo
- CP_0200_HikariConfigTest  
使用`HikariConfig`类获取`java.sql.Connection`对象
- CP_0300_HikariDataSourceTest  
使用`HikariDataSource`类获取`java.sql.Connection`对象  
这个demo中演示了两个使用HikariDataSource实例设置相关参数的方法，有关更多参数的设置请参考[官方文档](https://github.com/brettwooldridge/HikariCP)
- 关于参数调优的问题

  >HikariCP has plenty of "knobs" to turn as you can see above, but comparatively less than some other pools. This is a design philosophy. The HikariCP design aesthetic is Minimalism. In keeping with the simple is better or less is more design philosophy, some configuration axis are intentionally left out.

  上面是出自官方文档中的一段话，核心思想是“越简单越好”，HikariCP虽然有很多可以自己设置的参数，但是这些可以自定义的参数数量远远少于其他产品，而且这些参数大多数都是有设置好的默认值，也就是说，除非有特殊需求，你基本上不用自己去设置这些参数，用默认值就好
