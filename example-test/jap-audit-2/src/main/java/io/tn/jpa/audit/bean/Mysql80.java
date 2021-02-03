package io.tn.jpa.audit.bean;

import io.tn.jpa.audit.config.CustomAuditingListener;
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
@Table(name = "mysql81")
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert //动态插入
@DynamicUpdate //动态赋值
@EntityListeners({CustomAuditingListener.class})
public class Mysql80 extends CommonBean<Mysql80> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name,sex;
}
