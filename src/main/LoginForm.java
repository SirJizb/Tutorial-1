package main;

import java.util.Scanner;

public class LoginForm {
	private UserDAO dao = null;

	public void init() {
		if (dao == null) {
			dao = new UserDAO();
		}
	}

	public void display() {
		System.out.println("登陆成功");
	}

	public void validate() {
		init();
		Scanner scanner = new Scanner(System.in);
		String userName = null;
		String userPassword = null;
		while (true) {
			System.out.print("请输入用户名：");
			userName = scanner.nextLine();
			System.out.print("请输入密码：");
			userPassword = scanner.nextLine();
			if (dao.findUser(userName, userPassword)) {
				display();
				break;
			} else {
				System.out.println("账号或密码错误，请重新输入!");
			}

		}
	}
}
