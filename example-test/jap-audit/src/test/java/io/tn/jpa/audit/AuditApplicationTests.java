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

    @Test
    void testJpaAuditUpdate() throws Exception {
        Mysql80 mysql80 = new Mysql80();
        mysql80.setName("我的");
        mysql80.setSex("我的");
        mysql80.setId(4);
        mysql80Dao.updateEntity(mysql80,"id");
    }

    @Test
    void testJpaAuditUpdate2() throws Exception {
        Mysql80 mysql801 = mysql80Dao.findById(3).get();
        mysql801.setName("sad");
        mysql801.setSex("323");
        mysql80Dao.save(mysql801);
    }


    @Test
    void testJpaAuditSql(){
        mysql80Dao.updata("mysql80",1);
    }


}
