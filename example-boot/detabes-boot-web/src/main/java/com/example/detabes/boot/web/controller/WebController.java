package com.example.detabes.boot.web.controller;

import com.detabes.annotation.mapping.PathRestController;
import com.detabes.result.result.ResultVO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tn
 * @version 1
 * @ClassName WebController
 * @description 测试
 * @date 2020/12/28 12:27
 */
@PathRestController("web")
@Api(tags = "web测试")
public class WebController {

    @GetMapping("webTest")
    public ResultVO<String> webTest() {
        return ResultVO.success("ok");
    }
}
