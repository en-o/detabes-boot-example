package com.example.jpa.server.controller;

import com.detabes.result.result.ResultVO;
import com.example.jpa.server.controller.vo.JpaExampleVo;
import com.example.jpa.server.dao.JpaExampleDao;
import com.example.jpa.server.entity.JpaExample;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@RequestMapping("jpa")
public class JpaExampleController {

    @Resource
    private JpaExampleDao jpaExampleDao;






    /**
     * 测试查询
     * @return
     */
    @GetMapping("/getAll")
    public ResultVO<List<JpaExample>> getAll() {
        return ResultVO.successForData(jpaExampleDao.findAll());
    }

    /**
     * 测试  内置的 updateEntity 方法
     *      提供了字段判空处理，如果有空字段则改字段数据保持原有不变
     * @return
     */
    @PostMapping("/updateEntity")
    @Transient
    public ResultVO<String> updateEntity(@RequestBody JpaExampleVo jpaExampleVo) throws Exception {
        JpaExample to = jpaExampleVo.to(JpaExample.class);
        return ResultVO.resultMsg(jpaExampleDao.updateEntity(to,"id"),"更新");
    }


    /**
     * 测试  内置的 deleteByIdIn 方法
     * @return
     */
    @PostMapping("/deleteByIds")
    @Transient
    public ResultVO<String> deleteByIds(@RequestBody List<Integer> ids) throws Exception {
        return ResultVO.resultMsg(jpaExampleDao.deleteByIdIn(ids)>0,"批量删除");
    }

}
