package io.tn.jpa.audit.config;

import io.tn.jpa.audit.bean.AuditBean;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditListener {

    @PrePersist
    public void setCreatedOn(Auditable auditable) {
        AuditBean audit = auditable.getAudit();

        if(audit == null) {
            audit = new AuditBean();
            auditable.setAudit(audit);
        }

        audit.setCreateUserUuid("123");
        audit.setCreateUserName("asd");
        audit.setCreateTime(LocalDateTime.now());
        audit.setUpdateUserUuid("123");
        audit.setUpdateUserName("asd");
        audit.setUpdateTime(LocalDateTime.now());
    }

    @PreUpdate
    public void setUpdadtedOn(Auditable auditable) {
        AuditBean audit = auditable.getAudit();
        audit.setUpdateUserUuid("123d");
        audit.setUpdateUserName("asdd");
        audit.setUpdateTime(LocalDateTime.now());
    }

}
