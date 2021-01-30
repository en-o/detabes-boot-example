package com.example.jpa.server;

import cn.hutool.core.util.IdUtil;
import com.example.jpa.server.dao.JpaExampleDao;
import com.example.jpa.server.entity.JpaExample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;

@SpringBootApplication
public class CachesJpaServerApplication {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Resource
	private JpaExampleDao jpaExampleDao;


	public static void main(String[] args) {
		SpringApplication.run(CachesJpaServerApplication.class, args);
	}
	/**
	 * 初始化数据
	 */
	@PostConstruct
	public void init(){
		jdbcTemplate.update("truncate table jap_example");
		ArrayList<JpaExample> jpaExampleArrayListpaExample = new ArrayList<>();
		JpaExample build = JpaExample.builder().age(11).name("谭宁1").nickname("测试1").uuid(IdUtil.simpleUUID()).build();
		jpaExampleArrayListpaExample.add(build);
		build = JpaExample.builder().age(12).name("谭宁2").nickname("测试2").uuid(IdUtil.simpleUUID()).build();
		jpaExampleArrayListpaExample.add(build);
		build = JpaExample.builder().age(13).name("谭宁3").nickname("测试3").uuid(IdUtil.simpleUUID()).build();
		jpaExampleArrayListpaExample.add(build);
		build = JpaExample.builder().age(14).name("谭宁4").nickname("测试4").uuid(IdUtil.simpleUUID()).build();
		jpaExampleArrayListpaExample.add(build);
		jpaExampleDao.saveAll(jpaExampleArrayListpaExample);
	}
}
