package dao.impl.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDao;
import dao.impl.DbConnection;
import model.table.Customer;
import model.table.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection conn = null;

	public static void main(String[] args) {
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		/*
		 * add
		 */
		System.out.println("===== addEmploye =====");
		Employee e = new Employee("我", "最閒", "打雜", 110);
//		edi.add(e);
		/*
		 * read
		 */
		List<Employee> l;
		// selectAll test
		System.out.println("===== selectAll =====");
		l = edi.selectAll();
		l.stream()
				.forEach((t) -> System.out.println(t.getFirst_name() + "-" + t.getLast_name() + "-" + t.getUser_id()));
		// selectById test
		System.out.println("===== selectById =====");
		l = edi.selectById(4);
		l.stream()
				.forEach((t) -> System.out.println(t.getFirst_name() + "-" + t.getLast_name() + "-" + t.getUser_id()));
		// selectById test
		System.out.println("===== selectById =====");
		l = edi.selectById(4);
		l.stream()
				.forEach((t) -> System.out.println(t.getFirst_name() + "-" + t.getLast_name() + "-" + t.getUser_id()));
		// selectByName test
		System.out.println("===== selectByName =====");
		l = edi.selectByName("水");
		l.stream()
				.forEach((t) -> System.out.println(t.getFirst_name() + "-" + t.getLast_name() + "-" + t.getUser_id()));
		// update
		System.out.println("===== update =====");
		Employee e1 = l.get(0);
		e1.setPosition("經理");
		edi.update(e1);
		//delete
		System.out.println("===== delete =====");
		edi.delete(11);

	}

	@Override
	public void add(Employee e) {
		 conn = DbConnection.getDb();
		String SQL = "INSERT INTO `mems`.`employees` " + "(`first_name`, `last_name`, `position`, `dept_id`) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, e.getFirst_name());
			ps.setString(2, e.getLast_name());
			ps.setString(3, e.getPosition());
			ps.setInt(4, e.getDept_id());

			ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		}

	}

	@Override
	public List<Employee> selectAll() {
		 conn = DbConnection.getDb();
		List<Employee> el = new ArrayList();
		String SQL = "SELECT * FROM mems.employees";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirst_name(rs.getString("first_name"));
				e.setLast_name(rs.getString("last_name"));
				e.setPosition(rs.getString("position"));
				e.setUser_id(rs.getInt("user_id"));
				e.setDept_id(rs.getInt("dept_id"));

				el.add(e);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return el;
	}

	@Override
	public List<Employee> selectById(Integer id) {
		 conn = DbConnection.getDb();
		List<Employee> el = new ArrayList();
		String SQL = "SELECT * FROM mems.employees where id=?";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirst_name(rs.getString("first_name"));
				e.setLast_name(rs.getString("last_name"));
				e.setPosition(rs.getString("position"));
				e.setUser_id(rs.getInt("user_id"));
				e.setDept_id(rs.getInt("dept_id"));

				el.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return el;
	}

	@Override
	public List<Employee> selectByName(String name) {
		 conn = DbConnection.getDb();
		List<Employee> el = new ArrayList();
		String SQL = "SELECT * FROM mems.employees where concat(first_name,last_name) like ?";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirst_name(rs.getString("first_name"));
				e.setLast_name(rs.getString("last_name"));
				e.setPosition(rs.getString("position"));
				e.setUser_id(rs.getInt("user_id"));
				e.setDept_id(rs.getInt("dept_id"));

				el.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return el;
	}
	
	@Override
	public List<Employee> selectByUserId(Integer userId) {
		 conn = DbConnection.getDb();
		List<Employee> el = new ArrayList();
		String SQL = "SELECT * FROM mems.employees where user_id=?";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setFirst_name(rs.getString("first_name"));
				e.setLast_name(rs.getString("last_name"));
				e.setPosition(rs.getString("position"));
				e.setUser_id(rs.getInt("user_id"));
				e.setDept_id(rs.getInt("dept_id"));

				el.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return el;
	}

	@Override
	public void update(Employee e) {
		 conn = DbConnection.getDb();
		String SQL = "UPDATE `mems`.`employees` "
				+ "SET `first_name` = ?, `last_name` = ?, `position` = ?, `user_id` = ?, `dept_id` = ? "
				+ "WHERE (`id` = ?)";
		PreparedStatement ps;
		try {

			ps = conn.prepareStatement(SQL);
			ps.setString(1, e.getFirst_name());
			ps.setString(2, e.getLast_name());
			ps.setString(3, e.getPosition());
			ps.setInt(4, e.getUser_id());
			ps.setInt(5, e.getDept_id());
			ps.setInt(6, e.getId());

			ps.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void delete(Integer id) {
		 conn = DbConnection.getDb();
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM `mems`.`employees` WHERE (`id` = ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
