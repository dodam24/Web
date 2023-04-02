package member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.bean.MemberDTO;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static MemberDAO memberDAO = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return memberDAO;
	}
	
	public MemberDAO() {	
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public MemberDTO memberLogin(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.memberLogin", map);
		sqlSession.close();
		return memberDTO;
	}
	
	public int memberWrite(MemberDTO memberDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su  = sqlSession.insert("memberSQL.memberWrite", memberDTO);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}
	
	public boolean isExistID(String id) {
		boolean existId = false;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.isExistID", id); //selectOne은 절대 boolean타입을 받아올수 없다
		if(memberDTO != null) existId = true;
		sqlSession.close();
		return existId;
	}
	
	public MemberDTO getMember(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.getMember", id);
		sqlSession.close();
		return memberDTO;
	}
	
	public int memberUpdate(MemberDTO memberDTO){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("memberSQL.memberUpdate", memberDTO);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}
	/*
	public boolean isExistPwd(String id, String pwd) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boolean exist = false;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		MemberDTO memberDTO = sqlSession.selectOne("memberSQL.isExistPwd", id);
		
		if(memberDTO != null) exist = true;
		
		sqlSession.close();
		return exist;
	}
	*/
	public void memberDelete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("memberSQL.memberDelete", id);
		sqlSession.commit();
		sqlSession.close();
	}
	

}