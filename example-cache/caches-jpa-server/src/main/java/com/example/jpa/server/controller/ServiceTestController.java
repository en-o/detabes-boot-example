package com.example.jpa.server.controller;

import com.detabes.result.result.ResultVO;
import com.example.jpa.server.controller.vo.JpaExampleVo;
import com.example.jpa.server.entity.JpaExample;
import com.example.jpa.server.service.JpaExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Transient;
import java.util.List;

/**
 * @author tn
 * @version 1
 * @ClassName JpaExampleController
 * @description jpa示例
 * @date 2020/12/23 15:53
 */
@RestController
@RequestMapping("jpa/service")
public class ServiceTestController {

    @Autowired
    private JpaExampleService jpaExampleService;

    /**
     * 测试findById
     * @return
     */
    @GetMapping("/findById")
    public ResultVO<JpaExample> findById(Integer id) {
        return ResultVO.successForData(jpaExampleService.findById(id));
    }

    /**
     * 测试  findByBean
     * @return
     */
    @PostMapping("/findByBean")
    @Transient
    public ResultVO<List<JpaExample>> findByBean(@RequestBody JpaExampleVo jpaExampleVo) {
        JpaExample to = jpaExampleVo.to(JpaExample.class);
        List<JpaExample> byBean = jpaExampleService.findByBean(to);
        return ResultVO.successForData(byBean);
    }


}
