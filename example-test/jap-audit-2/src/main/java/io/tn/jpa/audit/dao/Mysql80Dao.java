package io.tn.jpa.audit.dao;

import com.detabes.jpa.server.dao.JpaBasicsDao;
import io.tn.jpa.audit.bean.Mysql80;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * 测试审计
 *
 * @author tn
 * @className Mysql80Dao
 * @date 2021-02-03 12:12
 */
public interface Mysql80Dao extends JpaBasicsDao<Mysql80, Integer> {


    @Query("update Mysql80 m set m.sex=?1 where m.id=?2 ")
    @Modifying
    @Transactional(rollbackOn=Exception.class)
    int updata(String sex, Integer id);
}
