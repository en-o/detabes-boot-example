# 一些示例


- [ ] example

    - [x] apis接口相关
    
        - [x] [接口返回示例](example-api/apis-result/src/main/java/com/example/result/ApiResultApplication.java)
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
            
        - [x] [全局异常拦截示例](example-api/apis-exception/src/main/java/com/example/exception/ApisExceptionApplication.java)
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
        
    - [ ] aop切面相关
        
        - [x] [接口日志打印跟保存](example-aops/aops-apilog/src/main/java/com/example/log/controller/TestLog.java)
             
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
                    
        - [ ] 接口验签 
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
    
    - [ ] doc文档相关
        - [x] 单体项目示例
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
        
        - [x] cloud项目示例
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
    
        
            
            
            
            
            
            
            
            
            
            
            
            
            
                                       