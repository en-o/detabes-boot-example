package io.tn.jpa.audit;

import io.tn.jpa.audit.bean.Mysql80;
import io.tn.jpa.audit.dao.Mysql80Dao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AuditApplicationTests {

    @Resource
    private Mysql80Dao mysql80Dao;

    @Test
    void contextLoads() {
    }


    @Test
    void testJpaAudit(){
        Mysql80 mysql80 = new Mysql80();
        mysql80.setName("adaa");
        mysql80.setSex("assda");
        mysql80Dao.save(mysql80);
    }

}
