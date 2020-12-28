package com.example.detabes.boot.web.config;

import com.detabes.apilog.bean.ApiMonitoring;
import com.detabes.apilog.server.ApiLogSave;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 *  测试 取名为  ApiLogSaveImplTest 不为 ApiLogSaveImpl的情况
 * @author tn
 * @version 1
 * @ClassName ApiLogSaveImpls
 * @description
 * @date 2020/12/21 12:55
 */
@Slf4j
@Primary
@Component
public class ApiLogSaveImplTest implements ApiLogSave {
    @Override
    public ApiMonitoring saveLog(ApiMonitoring apilog) {
        log.error("测试ApiLogSaveImplTest:"+ apilog.toString());
        return apilog;
    }
}
