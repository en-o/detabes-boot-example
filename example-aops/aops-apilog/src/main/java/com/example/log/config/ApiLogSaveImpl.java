package com.example.log.config;

import com.detabes.apilog.annotation.ApiLog;
import com.detabes.apilog.bean.ApiMonitoring;
import com.detabes.apilog.server.ApiLogSave;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * @author tn
 * @version 1
 * @ClassName ApiLogSaveImpls
 * @description
 * @date 2020/12/21 12:55
 */
@Slf4j
@Component
public class ApiLogSaveImpl implements ApiLogSave {
    @Override
    public ApiMonitoring saveLog(ApiMonitoring apilog) {
        log.error("测试:"+ apilog.toString());
        return apilog;
    }
}
