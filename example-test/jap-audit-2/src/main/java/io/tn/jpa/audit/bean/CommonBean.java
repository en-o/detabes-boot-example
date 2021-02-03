package io.tn.jpa.audit.bean;

import com.detabes.jpa.server.entity.mysql.JpaFields;
import io.tn.jpa.audit.config.CustomAuditingListener;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

/**
 * 公共的实体类
 *
 * @author tn
 * @className CommonBean
 * @date 2021-01-21 14:20
 */
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@Access(AccessType.FIELD)
@Getter
@Setter
@EntityListeners({CustomAuditingListener.class})
public class CommonBean<B> extends JpaFields<B> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) COMMENT '主键，自动生成'")
    private Integer id;
    /**
     * 创建人名称
     */
    @Column(columnDefinition = " varchar(100) default 'admin'  comment '创建人名称'")
    private String createUserName;

    /**
     * 创建人uuid
     */
    @Column(columnDefinition = " varchar(100) default '1'  comment '创建人uuid'")
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
}
