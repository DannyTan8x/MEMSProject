package dao.impl.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ViewEmployeeInfoDao;
import dao.impl.DbConnection;
import model.view.EmployeeInfo;

public class ViewEmployeeInfoDaoImpl implements ViewEmployeeInfoDao{
	Connection conn = DbConnection.getDb();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmployeeInfo> selectAll() {
		List<EmployeeInfo> eil = new ArrayList();
		String SQL = "SELECT * FROM mems.employeeInfo";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				EmployeeInfo ei = new EmployeeInfo();
				ei.setId(rs.getInt("id"));
				ei.setFirstName(rs.getString("first_name"));
				ei.setLastName(rs.getString("last_name"));
				ei.setPosition(rs.getString("position"));
				ei.setDeptName(rs.getString("dept_name"));
				ei.setUserId(rs.getInt("user_id"));
				ei.setDeptId(rs.getInt("dept_id"));
				
				eil.add(ei);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eil;
	}

	@Override
	public List<EmployeeInfo> selectByEmId(Integer emId) {
		List<EmployeeInfo> eil = new ArrayList();
		String SQL = "SELECT * FROM mems.employeeInfo Where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, emId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				EmployeeInfo ei = new EmployeeInfo();
				ei.setId(rs.getInt("id"));
				ei.setFirstName(rs.getString("first_name"));
				ei.setLastName(rs.getString("last_name"));
				ei.setPosition(rs.getString("position"));
				ei.setDeptName(rs.getString("dept_name"));
				ei.setUserId(rs.getInt("user_id"));
				ei.setDeptId(rs.getInt("dept_id"));
				
				eil.add(ei);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eil;
	}

	@Override
	public List<EmployeeInfo> selectByDepId(Integer dpId) {
		List<EmployeeInfo> eil = new ArrayList();
		String SQL = "SELECT * FROM mems.employeeInfo Where dept_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, dpId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				EmployeeInfo ei = new EmployeeInfo();
				ei.setId(rs.getInt("id"));
				ei.setFirstName(rs.getString("first_name"));
				ei.setLastName(rs.getString("last_name"));
				ei.setPosition(rs.getString("position"));
				ei.setDeptName(rs.getString("dept_name"));
				ei.setUserId(rs.getInt("user_id"));
				ei.setDeptId(rs.getInt("dept_id"));
				
				eil.add(ei);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eil;
	}

	@Override
	public List<EmployeeInfo> selectByKeyword(String keyword) {
		List<EmployeeInfo> eil = new ArrayList();
		String SQL = "SELECT * FROM mems.employeeInfo Where concat(first_name,last_name,position,dept_name) like  ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + keyword + "%" );
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				EmployeeInfo ei = new EmployeeInfo();
				ei.setId(rs.getInt("id"));
				ei.setFirstName(rs.getString("first_name"));
				ei.setLastName(rs.getString("last_name"));
				ei.setPosition(rs.getString("position"));
				ei.setDeptName(rs.getString("dept_name"));
				ei.setUserId(rs.getInt("user_id"));
				ei.setDeptId(rs.getInt("dept_id"));
				
				eil.add(ei);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eil;
	}

}
