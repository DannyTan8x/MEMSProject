package dao;

import java.util.List;

import model.table.User;

public interface UserDao {
	// create
	void add(User u);

	// read
	List<User> selectAll();

	List<User> selectById(Integer id);

	List<User> selectByAcc(String acc);
	
	Integer getUserDeptId(Integer uid);
	
	String getUserName(Integer uid);

	// update
	void update(User u);

	// delete
	void delete(Integer id);
}
