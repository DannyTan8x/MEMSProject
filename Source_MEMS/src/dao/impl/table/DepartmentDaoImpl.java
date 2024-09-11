package dao.impl.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DepartmentDao;
import dao.impl.DbConnection;
import model.table.Customer;
import model.table.Department;

public class DepartmentDaoImpl implements DepartmentDao {
	Connection conn = DbConnection.getDb();

	public static void main(String[] args) {
		DepartmentDaoImpl ddi = new DepartmentDaoImpl();
		/*
		 * add
		 */
		System.out.println(" ====== addDepartment =====");
		ddi.add("休閒部2");
		/*
		 * read
		 */
		List<Department> l;
		// selectAll test
		System.out.println("===== selectAll =====");
		l = ddi.selectAll();
		l.stream().forEach((t) -> System.out.println(t.getDept_name() + "-"));
		// selectById test
		System.out.println("===== selectById =====");
		l = ddi.selectById(11);
		l.stream().forEach((t) -> System.out.println(t.getDept_name() + "-"));
		// selectByName test
		System.out.println("===== selectByName =====");
		l = ddi.selectByName("銷");
		l.stream().forEach((t) -> System.out.println(t.getDept_name() + "-"));
		/*
		 * update
		 */
		System.out.println("===== updateCustomer =====");
		Department d1 = new Department();
		d1.setDept_id(12);
		d1.setDept_name("資遣區");
		ddi.update(d1);
		/*
		 * delete
		 */
		System.out.println("===== deleteCustomer =====");
		ddi.delete(0);
	}

	@Override
	public void add(String dpNam) {
		String SQL = "INSERT INTO `mems`.`departments` (`dept_name`) " + "VALUES (?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, dpNam);

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Department> selectAll() {
		List<Department> dl = new ArrayList();
		String SQL = "SELECT * FROM mems.departments";
//		String SQL = "SELECT * FROM mems.departments order by dept_id";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Department d = new Department();
				d.setDept_name(rs.getString("dept_name"));
				dl.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dl;
	}

	@Override
	public List<Department> selectById(Integer id) {
		List<Department> dl = new ArrayList();
		String SQL = "SELECT * FROM mems.departments where dept_id= ?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Department d = new Department();
				d.setDept_id(rs.getInt("dept_id"));
				d.setDept_name(rs.getString("dept_name"));

				dl.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dl;
	}

	@Override
	public List<Department> selectByName(String cName) {
		List<Department> dl = new ArrayList();
		String SQL = "SELECT * FROM mems.departments where dept_name like ?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + cName + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Department d = new Department();
				d.setDept_id(rs.getInt("dept_id"));
				d.setDept_name(rs.getString("dept_name"));

				dl.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dl;
	}

	@Override
	public void update(Department d) {
		String SQL = "UPDATE `mems`.`departments` " + "SET `dept_name` = ? " + "WHERE (`dept_id` = ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, d.getDept_name());
			ps.setInt(2, d.getDept_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Integer id) {
		String SQL = "DELETE FROM `mems`.`departments` " + "WHERE (`dept_id` = ?);";

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
