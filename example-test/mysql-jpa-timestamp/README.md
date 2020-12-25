# 测试 mysql不同版本因为时间戳导致表生成失败
## 通过 application.properties 选择不同的数据库进行测试 


### 利用Mysql55测试 JpaAuditFields 中时间格式 timestamp 会不会报错
- 配置文件设置 `spring.profiles.active=55`
- 出现错误
```text
Caused by: java.sql.SQLException: Incorrect table definition; there can be only one TIMESTAMP column with CURRENT_TIMESTAMP in DEFAULT or ON UPDATE clause
```
- 原因
    - 一个表中出现多个时间戳字段的定义，并设置了其中一个默认为Current_timestamp会报此类错误
- 处理
    - 升级Mysql，将Mysql升级到5.7版本以上就不会出现类似的问题了
    - 不使用 基类 `JpaAuditFields`
        - 给所有的时间戳TIMESTAMP设置默认值DEFAULT值
        - 将设定为CURRENT_TIMESTAMP的时间戳字段放在所有没有设定默认值的时间戳字段前面，则可以建表成功（实际上CURRENT_TIMESTAMP时间戳默认值只能设置一个或者不设置，不能有两个以上）

### 利用Mysql57测试 JpaAuditFields 中时间格式 timestamp 会不会报错
- 配置文件设置 `spring.profiles.active=57`
- 一切正常
```text
2020-12-25 10:26:34.183  INFO 61224 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL57Dialect
Hibernate: create table mysql55 (id integer not null auto_increment, create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期', create_user_name varchar(100) COMMENT '创建人', update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期', update_user_name varchar(100) COMMENT '更新人', name varchar(255), sex varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table mysql57 (id integer not null auto_increment, create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期', create_user_name varchar(100) COMMENT '创建人', update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期', update_user_name varchar(100) COMMENT '更新人', name varchar(255), sex varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table mysql80 (id integer not null auto_increment, create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期', create_user_name varchar(100) COMMENT '创建人', update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期', update_user_name varchar(100) COMMENT '更新人', name varchar(255), sex varchar(255), primary key (id)) engine=InnoDB
2020-12-25 10:26:34.919  INFO 61224 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2020-12-25 10:26:34.928  INFO 61224 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
```

### 利用Mysql80测试 JpaAuditFields 中时间格式 timestamp 会不会报错
- 配置文件设置 `spring.profiles.active=80`
- 一切正常
```text
2020-12-25 10:23:44.231  INFO 21436 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2020-12-25 10:23:44.251  INFO 21436 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL8Dialect
Hibernate: create table mysql55 (id integer not null auto_increment, create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期', create_user_name varchar(100) COMMENT '创建人', update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期', update_user_name varchar(100) COMMENT '更新人', name varchar(255), sex varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table mysql57 (id integer not null auto_increment, create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期', create_user_name varchar(100) COMMENT '创建人', update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期', update_user_name varchar(100) COMMENT '更新人', name varchar(255), sex varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table mysql80 (id integer not null auto_increment, create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期', create_user_name varchar(100) COMMENT '创建人', update_time timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期', update_user_name varchar(100) COMMENT '更新人', name varchar(255), sex varchar(255), primary key (id)) engine=InnoDB
2020-12-25 10:23:45.533  INFO 21436 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2020-12-25 10:23:45.544  INFO 21436 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
```




