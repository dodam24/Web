package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. 이름 검색");
		System.out.println("2. 아이디 검색");
		System.out.print("번호 입력 : ");
		int num = scan.nextInt();
		
		System.out.println();
		String columnName = null;
		String value = null;
		if(num == 1) {
			System.out.print("검색할 이름 입력 : ");
			value = scan.next();
			columnName = "name";
		}else if(num == 2) {
			System.out.println("검색할 아이디 입력 : ");
			value = scan.next();
			columnName = "id";
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("columnName", columnName);
		map.put("value", value);
		
		//DB
		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list = userDAO.search(map);
		
		System.out.println("이름\t아이디\t비밀번호");
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
		}//for
	}
}

/*
	1. 이름 검색
	2. 아이디 검색
	번호 입력 : 1
	
	1번인 경우
	찾고자 하는 이름 입력 : 홍
	
	이름      아이디      비밀번호
	홍길동
	홍당무
	
	1번인 경우
	찾고자 하는 아이디 입력 : n
	
	이름      아이디      비밀번호
	      	hong
	      	conan
	      
	이름으로 검색하건 또는 아이디로 검색하건 무조건 userDAO.search(~~)를 호출한다.
*/