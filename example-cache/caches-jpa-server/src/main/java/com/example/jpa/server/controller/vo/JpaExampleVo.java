package com.example.jpa.server.controller.vo;

import com.detabes.entity.basics.vo.SerializableVO;
import lombok.Data;

/**
 * @author tn
 * @version 1
 * @ClassName JpaExampleVo
 * @description
 * @date 2020/12/23 16:16
 */
@Data
public class JpaExampleVo extends SerializableVO<JpaExampleVo> {

    private Integer id;

    private String name;

    private String nickname;

    private Integer age;
}
