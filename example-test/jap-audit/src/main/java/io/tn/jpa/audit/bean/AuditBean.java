package io.tn.jpa.audit.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * 测试审计
 *
 * @author tn
 * @className AuditBean
 * @date 2021-02-03 12:09
 */
@Embeddable
@Getter
@Setter
public class AuditBean {

    /**
     * 创建人名称
     */
    @Column(columnDefinition = " varchar(100) default 'admin'  comment '创建人名称'")
    private String createUserName;


    /**
     * 创建人uuid
     */
    @Column(columnDefinition = " varchar(100) default '1' comment '创建人uuid'")
    private String createUserUuid;

    /**
     * 更新人名称
     */
    @Column(columnDefinition = " varchar(100)  comment '更新人名称'")
    private String updateUserName;

    /**
     * 更新人uuid
     */
    @Column(columnDefinition = " varchar(100)  comment '更新人uuid'")
    private String updateUserUuid;


    /**
     * 表示该字段为创建时间字段，在这个实体被insert的时候，会自动为其赋值
     */
    @Column(columnDefinition = "timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期' ")
    private LocalDateTime createTime;


    /**
     * 表示该字段为修改时间字段，在这个实体被update的时候，会自动为其赋值
     */
    @Column(columnDefinition = "timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期'")
    private LocalDateTime updateTime;


}
