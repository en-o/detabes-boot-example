package io.tn.jpa.audit.config;

import io.tn.jpa.audit.bean.AuditBean;

public interface Auditable {

    AuditBean getAudit();

    void setAudit(AuditBean audit);
}
