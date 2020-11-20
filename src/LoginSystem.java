import java.util.*;
public class LoginSystem {

	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("please enter your login name ：");	
		String userName = scanner.next();
		System.out.println("please enter your password：");
		String password = scanner.next();
		if("getUserName".equals(userName)&&"getPassWord".equals(password))
		{
			System.out.println("success login！");
		}else {
			System.out.println("error");
		}
		scanner.close();
		

	}

}