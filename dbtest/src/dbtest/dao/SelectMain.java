package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {
	private Connection conn;
	private PreparedStatement pstmt; //가이드 역할
	private ResultSet rs; //select 할 때 필요(테이블 형태를 가져옴)
	
	private String driver = "oracle.jdbc.driver.OracleDriver"; //풀 쿼리 네임으로 생성(패키지명 포함)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	public SelectMain() {
	//생성자는 객체를 생성할 때 한 번만 실행
		
		//driver loading
		try {
			Class.forName(driver); //Class타입으로 생성
			System.out.println("driver loading 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//생성자 안에서 접속하면 안 됨(한 번만 실행됨)
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("connection 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void selectArticle() {
		getConnection(); //접속
		
		String sql = "SELECT * FROM DBTEST";
		
		try {
			pstmt = conn.prepareStatement(sql); //가이드 생성
			rs = pstmt.executeQuery(); //실행 - ResultSet 리턴
			
			while(rs.next()) { //rs.next() : 위치를 맞추고 레코드가 있으면 true -> 다음 레코드로 이동, 없으면 false
				System.out.println(rs.getString("name")+"\t"
						  +rs.getInt("age")+"\t"
						  +rs.getDouble("height")+"\t"
						  +rs.getString("logtime"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	
	}
	
	
	public static void main(String[] args) {
		SelectMain sm = new SelectMain();
		sm.selectArticle();

	}

}
