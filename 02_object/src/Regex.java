import java.util.Scanner;

public class Regex {

	// 验证输入的手机号
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你的手机号：");
		String mobile = sc.nextLine();
		System.out.println("手机号：" + checkMobile(mobile));
	}

	public static boolean checkMobile(String mobile) {
		// String regex= "[135][0-9]{10,}";
		// boolean flag = mobile.matches(regex);
		// return flag;

		// 写法二
		return mobile.matches("[135][0-9]{10,}");
	}
	

}
