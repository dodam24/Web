package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	private Connection conn;
	private PreparedStatement pstmt; //가이드 역할
	private ResultSet rs; //select 할 때 필요(테이블 형태를 가져옴)
	
	private String driver = "oracle.jdbc.driver.OracleDriver"; //풀 쿼리 네임으로 생성(패키지명 포함)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	public UpdateMain() {
	//생성자는 객체를 생성할때 한번만 실행
	
			//driver loading
			try {
				Class.forName(driver); //Class타입으로 생성
				System.out.println("driver loading 성공"); 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 

	}
	
	//생성자 안에서 접속하면 안 됨 (한 번만 실행됨)
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("connection 성공");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void updateArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름 입력 : ");
		String name = scan.next();
		
		getConnection(); // 접속
		
		String sql = "UPDATE DBTEST SET AGE=AGE+1, HEIGHT=HEIGHT+1 WHERE NAME LIKE ?";
		
		try {
			pstmt = conn.prepareStatement(sql); //가이드 생성
			pstmt.setString(1,"%"+name+"%"); //?에 데이터 대입
			int su = pstmt.executeUpdate();//실행 - 개수 리턴
			System.out.println(su+"행 이(가) 업데이트 되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	}
	
	public static void main(String[] args) {
		UpdateMain um = new UpdateMain();
		um.updateArticle();
		
	}

}
