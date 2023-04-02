package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	private Connection conn; //Connection인터페이스로 conn변수 생성 -> 메소드로 객체 생성
	private PreparedStatement pstmt; //PreparedStatement pstmt변수 생성, 가이드 역할 -> 메소드로 객체 생성
	
	private String driver = "oracle.jdbc.driver.OracleDriver"; //풀 쿼리 네임으로 생성(패키지명 포함)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	public InsertMain() {
		//생성자는 객체를 생성할 때 한 번만 실행
		
		//driver loading
		try {
			Class.forName(driver); //new가 아닌 Class타입으로 생성
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
	
	public void insertArticle() {
		String sql = "INSERT INTO DBTEST VALUES(?, ?, ?, SYSDATE)";
		
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("나이 입력 : ");
		int age = scan.nextInt();
		System.out.print("키 입력 : ");
		double height = scan.nextDouble();
		
		this.getConnection(); //접속
		
		try {
			pstmt = conn.prepareStatement(sql); //가이드 생성
			//?에 데이터 대입
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			int su = pstmt.executeUpdate(); //실행 - 개수 리턴
			System.out.println(su+"행 이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		InsertMain im = new InsertMain();
		im.insertArticle();

	}

}
