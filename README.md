# 一些示例


- # example

    - ## apis接口相关
    
        - ### [接口返回示例](example-api/apis-result/src/main/java/com/example/result/ApiResultApplication.java)
            ```xml
                <!-- springboot 项目中引入 -->
                <dependency>
                    <groupId>com.detabes</groupId>
                    <artifactId>apis-result</artifactId>
                    <version>1.0.0</version>
                </dependency>
            ``` 
            - 普通接口返回示例 `testResultVO`
            - 分页接口返回示例 `testResultVO_Page`
            
        - ### [全局异常拦截示例](example-api/apis-exception/src/main/java/com/example/exception/ApisExceptionApplication.java)
             ```xml
                <!-- springboot 项目中引入 -->
                <dependency>
                    <groupId>com.detabes</groupId>
                    <artifactId>apis-exception</artifactId>
                    <version>1.0.0</version>
                </dependency>
             ``` 
            - 测试全局异常示例   `testException`
            - 自定义异常效果示例 `testBusinessException`
        
    - ## aop切面相关
        
        - ### [接口日志打印跟保存](example-aops/aops-apilog/src/main/java/com/example/log/controller/TestLog.java)
             
         ```xml
                <!-- springboot 项目中引入: 注意扫描的是controller -->
                <dependency>
                    <groupId>com.detabes</groupId>
                    <artifactId>aops-apilog</artifactId>
                    <version>1.0.0</version>
                </dependency>
         ```
          
        - 接口记录 - 只有日志打印功能(示例) `testApiLogAspectSee`
            - [测试io开头的包名打印是否成功（默认是com开头）](example-aops/aops-apilog/src/main/java/io/example/log/controller/TestLog.java)
        - 接口记录保存 - 可以打印日志可以报错日志，看你怎么选择(示例) `testApiLogAspectSave`
            - 接口保存注解默认是打印功能跟上面的`testApiLogAspectSee`一样,[如要做保存请参考](example-aops/aops-apilog/src/main/java/com/example/log/config/ApiLogSaveImpl.java)  
                    - 如果出现 错误 ```Field apiLogSave in com.detabes.apilog.aspect.ApiLogAspectSave required a single bean, but 2 were found:``` ,[请参考](example-aops/aops-apilog/src/main/java/com/example/log/config/ApiLogSaveImplTest.java)
                    
        - ### 接口验签 
             ```xml
                <!-- springboot 项目中引入: 使用注解 @Signature 相关参数内部有说明 -->
                <dependency>
                    <groupId>com.detabes</groupId>
                    <artifactId>aops-apisign</artifactId>
                    <version>1.0.0</version>
                </dependency>
            ``` 
            - [x] [MD5验签之 sign在header中](example-aops/aops-apisign/src/main/java/com/example/sign/controller/SignHeaderMD5Controller.java)           
                - [单元测试跟使用参考](example-aops/aops-apisign/src/test/java/com/example/sign/controller/SignHeaderMD5ControllerTest.java)      
            
            - [x] [MD5验签之 sign在params中](example-aops/aops-apisign/src/main/java/com/example/sign/controller/SignParamsMD5Controller.java)           
                - [单元测试跟使用参考](example-aops/aops-apisign/src/test/java/com/example/sign/controller/SignParamsMD5ControllerTest.java)         
                    
            - [x] [SHA验签之 sign在params中](example-aops/aops-apisign/src/main/java/com/example/sign/controller/SignParamsSHAController.java)           
                - [单元测试跟使用参考](example-aops/aops-apisign/src/test/java/com/example/sign/controller/SignParamsSHAControllerTest.java)         
    
    - ## doc文档相关
        - ### 单体项目示例
             ```xml
                <!-- springboot 项目中引入: 注意扫描的是controller -->
                <dependency>
                    <groupId>com.detabes</groupId>
                    <artifactId>doc-swagger-boot</artifactId>
                    <version>1.0.0</version>
                </dependency>
            ``` 
            - ***设置包扫描 application.properties ***
            ```properties
            server.port=15515
            detabes.swagger.base-package=com.example.doc.swager.boot.controller
            ```    
            - [controller示例](example-doc/doc-swagger-boot/src/main/java/com/example/doc/swager/boot/controller/SwaggerController.java)    
        
        - ### cloud项目示例
             ```xml
                <!-- springboot 项目中引入: 注意扫描的是controller -->
                <dependency>
                    <groupId>com.detabes</groupId>
                    <artifactId>doc-swagger-cloud</artifactId>
                    <version>1.0.0</version>
                </dependency>
             ``` 
            - ***设置包扫描 bootstrap.yml ***
            ```yaml
            server:
              port: 15516
            detabes:
              swagger:
                base-package=com:
                  example:
                    doc:
                      swager:
                        boot:
                          controller: com.example.doc.swagger.cloud.controller
            ```    
            - [controller示例](example-doc/doc-swagger-cloud/src/main/java/com/example/doc/swagger/cloud/controller/SwaggerController.java)                                   

    - ## cache数据相关
        - ### [redis消息推送跟监听](example-cache/caches-redis-pub/src/main/java/com/example/redis/pub/CachesRedisPubApplication.java)        
            ```xml
              	<dependency>
                    <groupId>com.detabes</groupId>
                    <artifactId>caches-redis-pub</artifactId>
                    <version>1.0.0</version>
                </dependency>
            ```         
           - 引入依赖
           - [构造消息发送接口](example-cache/caches-redis-pub/src/main/java/com/example/redis/pub/controller/RedisMessageController.java)
           - 默认配置本机redis (保证redis正常运行且没有密码)
           - 观测
                - 打开redis管理端（命令行）输入命令 `SUBSCRIBE 频道名`  
                    - 默认频道有两个： test, tn
                - [调用接口](example-cache/caches-redis-pub/src/main/java/com/example/redis/pub/controller/RedisMessageController.java)
                - 观测项目控制台的输出跟redis管里端的输出
                ```text
                    2020-12-23 13:13:54.222  INFO 16316 --- [    container-7] c.d.r.pub.server.impl.RedisReceiverImpl  : 
                    ----------------------------------------------------------
                        redis监听频道 test 的消息
                        消息体：{"sex":"2","name":"谭宁","time":1608700434197}
                    ----------------------------------------------------------
                
                    本机:0>SUBSCRIBE test
                    Switch to Pub/Sub mode. Close console tab to stop listen for messages.
                     1)  "subscribe"
                     2)  "test"
                     3)  "1"
                     1)  "message"
                     2)  "test"
                     3)  "{"sex":"2","name":"谭宁","time":1608700434197}"
                ```    
           - [默认项目中接受消息默认为控制台答应如果想要修改](example-cache/caches-redis-pub/src/main/java/com/example/redis/pub/message/MessageSave.java) 
                - `expected single matching bean but found 2` 错误请在实现类上加入 `@Primary`
                ```text
                 自定义保存方法：{"sex":"2","name":"谭宁","time":1608702435740}
                ```
        - ### [jpa测试示例](example-cache/caches-jpa-server/src/main/java/com/example/jpa/server/controller/JpaExampleController.java)
              
             ```xml
                <dependency>
                    <groupId>com.detabes</groupId>
                    <artifactId>caches-redis-pub</artifactId>
                    <version>1.0.0</version>
                </dependency>
            ```  
            - 初始化需要配置数据库
                ```xml
                    <dependency>
                        <groupId>mysql</groupId>
                        <artifactId>mysql-connector-java</artifactId>
                    </dependency>
                ```     
            - 主要测试了
               - [bean继承基类](example-cache/caches-jpa-server/src/main/java/com/example/jpa/server/entity/JpaExample.java)
               - [dao继承基类](example-cache/caches-jpa-server/src/main/java/com/example/jpa/server/dao/JpaExampleDao.java)
               - [实体转型的方法 to 在controller中的使用](example-cache/caches-jpa-server/src/main/java/com/example/jpa/server/controller/vo/JpaExampleVo.java)
  
    - ## web相关
        - ### [web-jwt示例](example-web/webs-jwt/src/main/java/com/example/jwt/WebsJwtApplication.java)
            ```xml
                <dependency>
                    <groupId>com.detabes</groupId>
                    <artifactId>webs-jwt</artifactId>
                    <version>1.0.0</version>
                </dependency>
            ```
            - [接口示例](example-web/webs-jwt/src/main/java/com/example/jwt/controller/JwtController.java)
            - [配置文件放行配置](example-web/webs-jwt/src/main/resources/application.properties)  
            - [配置文件加密配置](example-web/webs-jwt/src/main/resources/application.properties)  
    
        - ### [webs-socket示例](example-web/webs-socket/src/main/java/com/example/webs/socket/WebsSocketApplication.java)
            ```xml
                  <dependency>
                    <groupId>com.detabes</groupId>
                    <artifactId>webs-socket-client</artifactId>
                    <version>1.0.0</version>
                  </dependency>
            ```
            - 无需配置
            - [接口示例](example-web/webs-socket/src/main/java/com/example/webs/socket/controller/WebSocketController.java)
                - 继承默认接口 `SocketController.java`  自带两个Action 
                - 自定义了一个接口 `sendInfoByLikeKey` [实现类](example-web/webs-socket/src/main/java/com/example/webs/socket/service/AlarmWebSocketServer.java)
            - 使用方法
                - socket的连接接口为：
                    - ws://127.0.0.1:port/context-path/socket/频道名
                    - ws://127.0.0.1:1243/socket/tanning123  
                - socket消息发送 
                    -  127.0.0.1:1243/websocket/sendInfoByLikeKey?keyPrefix=tanning&message=测试   

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
            
            
            
            
            
                                       