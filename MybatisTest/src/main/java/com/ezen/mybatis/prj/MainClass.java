package com.ezen.mybatis.prj;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MainClass {
	public static void main(String[] args) {
		try {
			String resource = "com/ezen/mybatis/prj/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		 	SqlSession session = sqlSessionFactory.openSession(true);
			System.out.println("session >>> " + session);
		 			
			mapperInterfacce mapper = session.getMapper(mapperInterfacce.class);
			MemberVO mVo = mapper.selectOne(00001);
			System.out.println(mVo);
			
//			mVo.setId(00003);
//			mVo.setName("조운");
//			mVo.setPhone("111-2222-3333");
//			mVo.setAddress("서울시 강서구");
//			int result = mapper.insertMember(mVo);
//			System.out.println("결과 : " + result);
			
			int result = mapper.deleteMember(00003);
			System.out.println("결과 : " + result);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
