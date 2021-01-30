package com.example.jpa.server.entity;

import com.detabes.jpa.server.entity.mysql.JpaAuditFields;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

/**
 * @author tn
 * @version 1
 * @ClassName JapExample
 * @description jpa示例表
 * @date 2020/12/23 15:40
 */
@Entity
@Table(name="jap_example", schema ="test")
@org.hibernate.annotations.Table(appliesTo = "jap_example", comment = "jpa示例表")
@Getter
@Setter
@Accessors(chain = true)
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class JpaExample extends JpaAuditFields<JpaExample> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = " int(11) comment '主键'  ")
    private Integer id;

    @Column(columnDefinition = " varchar(20) comment '姓名' ")
    private String name;

    @Column(columnDefinition = " varchar(50) comment 'uuid' ")
    private String uuid;

    @Column(columnDefinition = " varchar(20) comment '昵称' ")
    private String nickname;

    @Column(columnDefinition = " int(5) comment '年龄' ")
    private Integer age;

}
