package services.impl;

import java.util.List;

import javax.swing.JOptionPane;

import dao.impl.table.EmployeeDaoImpl;
import dao.impl.table.UserDaoImpl;
import model.table.Employee;
import model.table.User;
import services.UserService;
import systemData.SystemData;

public class UserServiceImpl implements UserService {
	UserDaoImpl udi = new UserDaoImpl();
	EmployeeDaoImpl edi = new EmployeeDaoImpl();

	public static void main(String[] args) {
		UserServiceImpl usi = new UserServiceImpl();

		// test assign to employee
//		usi.registUser("newuser12", "1234", 12);
		// test login
		System.out.println(SystemData.currentUser.getUser_id());
		SystemData.currentUser = usi.login("admin", "123");
		System.out.println(SystemData.currentUser.getUser_acc());
		if (!SystemData.currentUser.equals(null)) {
			System.out.println(SystemData.currentUser.getUser_acc() + " login success!");
		}

	}

	@Override
	public void registUser(String user_acc, String user_pass, Integer employeeId) {
		// TODO Auto-generated method stub
		/*
		 * create user Object
		 */
		User u = new User(user_acc, user_pass, false);
		
		/*
		 * boding user to employee table
		 */
		
		// finding employee by id
		List<Employee> el;
		el = edi.selectById(employeeId);
		Employee e1 = el.get(0);
		// update user acc id to employee if null
		System.out.println(e1.getUser_id());
		if (e1.getUser_id().equals(0)) {
			udi.add(u);//create new User if employee's user id is null
			// finding added user id by account
			List<User> ul;
			ul = udi.selectByAcc(user_acc);
			User u1 = ul.get(0); //get user in Data after added
			
			e1.setUser_id(u1.getUser_id());
			edi.update(e1);
			JOptionPane.showMessageDialog(null, "帳號申請成工.", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else {
			List<User> ul;
			ul = udi.selectById(e1.getUser_id());
			User uExist = ul.get(0); //get user in Data after added
			JOptionPane.showMessageDialog(null,
					"員工： " + e1.getFirst_name() + e1.getLast_name() + " 已註冊帳號為： " + uExist.getUser_acc(), "Information",
					JOptionPane.INFORMATION_MESSAGE);
			System.out.println(
					"already had assign user:" + uExist.getUser_acc() + "to :" + e1.getFirst_name() + e1.getLast_name());
		}
	}

	@Override
	public User login(String user_acc, String user_pass) {
		User u = new User();

		// find user from data
		List<User> ul;
		// selectByAcc test
		ul = udi.selectByAcc(user_acc);
		if (ul.size() > 0) {
			u = ul.get(0);
			if(!u.getIsLocked()) {
				if (u.getUser_pass().equals(user_pass)) {
					return u;
				} else {
					JOptionPane.showMessageDialog(null, "登入失敗，請再次確認密碼！", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "帳號已被鎖，請聯繫負責人！", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "登入失敗，帳號不存在！", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	}

	@Override
	public void lockUser(Integer uId) {
		User u = new User();
		// find user from data
		List<User> ul;
		// selectByAcc test
		ul = udi.selectById(uId);
		if (ul.size() > 0) {
			u = ul.get(0);
			u.setIsLocked(true);
			udi.update(u);
			JOptionPane.showMessageDialog(null, "執行完畢，帳號已被鎖！", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "帳號不存在！", "Information", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	@Override
	public void unLockUser(Integer uId) {
		User u = new User();
		// find user from data
		List<User> ul;
		// selectByAcc test
		ul = udi.selectById(uId);
		if (ul.size() > 0) {
			u = ul.get(0);
			u.setIsLocked(false);
			udi.update(u);
			JOptionPane.showMessageDialog(null, "執行完畢，帳號已解鎖！", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "帳號不存在！", "Information", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	@Override
	public void deleteUser(String user_acc) {
		User u = new User();
		// find user from data
		List<User> ul;
		// selectByAcc test
		ul = udi.selectByAcc(user_acc);
		if (ul.size() > 0) {
			u = ul.get(0);
			udi.delete(u.getUser_id());
			JOptionPane.showMessageDialog(null, "執行完畢，帳號已刪除！", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "帳號不存在！", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public Integer getCurrenUserDeptId() {
		// TODO Auto-generated method stub
		Integer currentDeptId = 0;
		try {
			currentDeptId = udi.getUserDeptId(SystemData.currentUser.getUser_id());
		} catch (NullPointerException e) {
			currentDeptId = 0;
		}
		return currentDeptId;
	}

	@Override
	public String getCurrentUserName() {
		
		String currentUserName = null;
		try {
			currentUserName = udi.getUserName(SystemData.currentUser.getUser_id());
		} catch (NullPointerException e) {
			currentUserName = null;
		}
		return currentUserName;
	}

	@Override
	public void changePassword(String oldPass, String newPass, String newPassConfirm) {
		// TODO Auto-generated method stub
		User u = SystemData.currentUser;
		if (u.getUser_pass().equals(oldPass)) {
			if(newPass.equals(newPassConfirm)) {
				u.setUser_pass(newPass);
				udi.update(u);
				JOptionPane.showMessageDialog(null, "執行完畢，密碼已變更！", "Information", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "新密碼輸入不一致，請再確認！", "Information", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "舊密碼不正確，請再確認！", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}

}
