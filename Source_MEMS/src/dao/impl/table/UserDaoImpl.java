package dao.impl.table;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import dao.impl.DbConnection;
import model.table.User;

public class UserDaoImpl implements UserDao {
	

	public static void main(String[] args) {
		UserDaoImpl udi = new UserDaoImpl();
		// TODO Auto-generated method stub
		/*
		 * reate
		 */
		// add
		System.out.println("===== add =====");
		User u1 = new User("newuser", "123", false);
		udi.add(u1);
		/*
		 * read
		 */
		List<User> l;
		// selectAll test
		System.out.println("===== selectAll =====");
		l = udi.selectAll();
		l.stream().forEach((t) -> System.out
				.println(t.getUser_id() + "-" + t.getUser_acc() + "-" + t.getUser_pass() + "-" + t.getIsLocked()));
		// selectById test
		System.out.println("===== selectById =====");
		l = udi.selectById(4);
		l.stream().forEach((t) -> System.out
				.println(t.getUser_id() + "-" + t.getUser_acc() + "-" + t.getUser_pass() + "-" + t.getIsLocked()));
		// selectByAcc test
		System.out.println("===== selectByAcc =====");
		l = udi.selectByAcc("danny");
		l.stream().forEach((t) -> System.out
				.println(t.getUser_id() + "-" + t.getUser_acc() + "-" + t.getUser_pass() + "-" + t.getIsLocked()));
		// update
		System.out.println("===== update =====");
		User u2 = l.get(0);
		u2.setUser_acc("LoockedUser");
		u2.setUser_pass("invaliedPass");
		u2.setIsLocked(true);
		udi.update(u2);
		// delete
		System.out.println("===== delete =====");
		udi.delete(11);
		
		System.out.println(udi.getUserName(1));
	}

	@Override
	public void add(User u) {
		Connection conn = DbConnection.getDb();
		String SQL = "INSERT INTO `mems`.`users` (`user_acc`, `user_pass`) " + "VALUES (?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, u.getUser_acc());
			ps.setString(2, u.getUser_pass());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<User> selectAll() {
		Connection conn = DbConnection.getDb();
		List<User> ul = new ArrayList();
		String SQL = "SELECT * FROM mems.users";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setUser_id(rs.getInt("user_id"));
				u.setUser_acc(rs.getString("user_acc"));
				u.setUser_pass(rs.getString("user_pass"));
				u.setIsLocked(rs.getBoolean("isLocked"));

				ul.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ul;
	}

	@Override
	public List<User> selectById(Integer id) {
		Connection conn = DbConnection.getDb();
		List<User> ul = new ArrayList();
		String SQL = "SELECT * FROM mems.users WHERE user_id =?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setUser_id(rs.getInt("user_id"));
				u.setUser_acc(rs.getString("user_acc"));
				u.setUser_pass(rs.getString("user_pass"));
				u.setIsLocked(rs.getBoolean("isLocked"));

				ul.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ul;
	}

	@Override
	public List<User> selectByAcc(String acc) {
		Connection conn = DbConnection.getDb();
		List<User> ul = new ArrayList();
		String SQL = "SELECT * FROM mems.users WHERE user_acc = ?";
		System.out.println(" line 130 acc:"+ acc);
		System.out.println("conn: "+conn);
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, acc);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setUser_id(rs.getInt("user_id"));
				u.setUser_acc(rs.getString("user_acc"));
				u.setUser_pass(rs.getString("user_pass"));
				u.setIsLocked(rs.getBoolean("isLocked"));

				ul.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ul;
	}

	@Override
	public void update(User u) {
		Connection conn = DbConnection.getDb();
		String SQL = "UPDATE `mems`.`users` SET `user_pass` = ?, `isLocked` = ? " + "WHERE (`user_id` = ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, u.getUser_pass());
			ps.setBoolean(2, u.getIsLocked());
			ps.setInt(3, u.getUser_id());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		Connection conn = DbConnection.getDb();
		String SQL = "DELETE FROM `mems`.`users` WHERE (`user_id` = ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Integer getUserDeptId(Integer uid) {
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT departments.dept_id FROM mems.departments "
				+ "left join mems.employees on departments.dept_id = employees.dept_id "
				+ "left join mems.users on employees.user_id = users.user_id "
				+ "where users.user_id = ?";
		Integer deptId = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				deptId = rs.getInt("dept_id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 
		return deptId;
	}

	@Override
	public String getUserName(Integer uid) {
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT concat(first_name, last_name) as userName FROM mems.employees "
				+ "left join mems.users on employees.user_id = users.user_id "
				+ "where users.user_id = ?";
		String userName = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				userName = rs.getString("userName");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 
		return userName;
	}

}
