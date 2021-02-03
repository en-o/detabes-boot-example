package io.tn.jpa.audit.bean;

import io.tn.jpa.audit.config.AuditListener;
import io.tn.jpa.audit.config.Auditable;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @author tn
 * @ClassName Mysql57
 * @description 测试mysql5.5 建表
 * @date 2020-11-02 15:36
 */
@Table(name = "mysql80")
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert //动态插入
@DynamicUpdate //动态赋值
@EntityListeners(AuditListener.class)
public class Mysql80 implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name,sex;

    @Embedded
    private AuditBean audit;
}
