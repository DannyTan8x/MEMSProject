package services;

import model.table.User;

public interface UserService {
	
	void registUser(String user_acc, String user_pass, Integer employeeId);
	
	User login(String user_acc, String user_pass);
	
	void lockUser(Integer uId);
	
	void unLockUser(Integer uId);
	
	void deleteUser(String user_acc);
	
	Integer getCurrenUserDeptId();
	
	String getCurrentUserName();
	
	void changePassword(String oldPass, String newPass, String newPassConfirm);
	
}
