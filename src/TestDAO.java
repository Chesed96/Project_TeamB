package com.hanul.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hanul.dto.TestDTO;

public class TestDAO {
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			String resource = "com/hanul/mybatis/SqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SqlSessionFactory Exception!!!");
		}	
	}
	//시험과목 등록
	public void getSubject(TestDTO dto) {
		SqlSession session = sqlMapper.openSession();
		session.update("com.hanul.mybatis.testMapper.xml.subject", dto);
		session.commit();
		session.close();
	}
	//시험제출
	public void getTestInsert(TestDTO dto) {
		SqlSession session = sqlMapper.openSession();
		session.insert("com.hanul.mybatis.testMapper.xml.testInsert", dto);
		session.commit();
		session.close();
	}
	
}
