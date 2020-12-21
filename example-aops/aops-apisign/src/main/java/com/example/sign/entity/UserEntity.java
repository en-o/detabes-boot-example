package com.example.sign.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author tn
 * @version 1
 * @ClassName UserEtity
 * @description 测试
 * @date 2020/11/25 13:22
 */
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 315654089784739497L;
    private String age,name;
}
