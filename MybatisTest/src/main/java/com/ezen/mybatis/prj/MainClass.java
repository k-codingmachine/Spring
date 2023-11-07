package com.ezen.mybatis.prj;

import java.io.InputStream;
import java.util.List;

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
			
//			mVo.setId(00002);
//			mVo.setName("미방");
//			mVo.setPhone("111-2222-3333");
//			mVo.setAddress("서울시 강서구 등촌동");
//			int result = mapper.updateMember(mVo);
//			System.out.println("결과 : " + result);
			
			List<MemberVO> list = mapper.selectAll();
			
			for(MemberVO member : list)
				System.out.println(member);
			
//			int result = mapper.deleteMember(00003);
//			System.out.println("결과 : " + result);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
