package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##jAVA";
	private String password = "1234";
	
	
	private static MemberDAO memberDAO = new MemberDAO(); //static은 메모리에 한 번만 생성 
	
	
	public static MemberDAO getInstance() {
		return memberDAO;
	}
	
	
	
	public MemberDAO() {
		try {
			Class.forName(driver);
			System.out.println("driver loading 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} 
	
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("connection 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public int memberWrite(MemberDTO memberDTO) {
		int su = 0;
		
		this.getConnection(); //접속
		String sql = "INSERT INTO MBMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			
			//?에 데이터 주입
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());
			
			su = pstmt.executeUpdate(); //실행 - 개수 return
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt);
		}
		
		return su;
		
	}

	
	public String memberLogin(String id, String pwd) {
		String name = null;
		String sql = "SELECT * FROM MEMBER WHERE id=? AND pwd=?";
		
		getConnection(); //접속
		
		try {
			pstmt = conn.prepareStatement(sql); //SQL문장을 처리해주는 가이드 역할
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery(); //ResultSet 리턴
			
			if(rs.next()) {
				name = rs.getString("name"); //필요한 이름을 name에 보관
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt, rs);
		}
		
		return name;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
