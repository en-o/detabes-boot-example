package com.example.jpa.server.service;

import com.detabes.jpa.server.dao.JpaBasicsDao;
import com.detabes.jpa.server.service.impl.JServiceImpl;
import com.example.jpa.server.entity.JpaExample;
import org.springframework.stereotype.Service;

/**
 * @author tn
 * @version 1
 * @date 2021/1/30 23:03
 */
@Service
public class JpaExampleServiceImpl extends JServiceImpl<JpaExample,Integer> implements JpaExampleService {

    public JpaExampleServiceImpl(JpaBasicsDao<JpaExample, Integer> commonDao) {
        super(commonDao);
    }
}
