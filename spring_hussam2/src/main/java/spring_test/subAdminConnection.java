package spring_test;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class subAdminConnection implements  InitializingBean, DisposableBean {

	private String adminId;
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getSub_AdminId() {
		return sub_AdminId;
	}

	public void setSub_AdminId(String sub_AdminId) {
		this.sub_AdminId = sub_AdminId;
	}

	public String getSub_AdminPw() {
		return sub_AdminPw;
	}

	public void setSub_AdminPw(String sub_AdminPw) {
		this.sub_AdminPw = sub_AdminPw;
	}

	private String adminPw;
	private String sub_AdminId;
	private String sub_AdminPw;
	
	
	


	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy() 호출");
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet() 호출");
	}
}
