package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.CommonConstant;
import util.DataBaseFactory;
import vo.Employee;

public class EmployeeDao extends DataBaseFactory {

	/**
	 * 根据用户名密码验证登录 
	 * String STATUS4="3"; //用户名或密码错误，登录失败
	 * 
	 * @param username
	 * @param password
	 * @return int 返回员工的状态，
	 *         0表示正在审核，登录失败，1表示审核通过，登录成功，2表示审核未通过，3用户名或密码错误，登录失败，4关闭，登录失败
	 */
	public int login(String username, String password) {
		int status = Integer.parseInt(CommonConstant.STATUS4);
		String sql = "select * from employee where username=? and password=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setString(1, username);
			ps.setString(2, password);
			rs = executeQuery(ps);
			if (rs.next()) {
				status = rs.getInt("status");
				return status;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return status;
	}

	/**
	 * 注册
	 * String STATUS1="0"; //正在审核 
	 * String ROLEEMPLOYEE="2"; //员工
	 * 
	 * @param employee
	 * @return int
	 */
	public int register(Employee employee) {
		if (isUsernameExists(employee.getUsername())) {
			return -1;// 该用户名已被占用，注册失败
		}
		String sql = "insert into employee values (seq_employeeid.nextval,?,?,?,?,?,?,?,?,?)";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		try {
			ps.setString(1, employee.getRealname());
			ps.setString(2, employee.getUsername());
			ps.setString(3, employee.getPassword());
			ps.setString(4, employee.getPhone());
			ps.setString(5, employee.getEmail());
			ps.setInt(6, employee.getDepartmentid());
			ps.setInt(7, Integer.parseInt(CommonConstant.STATUS1));
			ps.setString(8, employee.getRemark());
			ps.setInt(9, Integer.parseInt(CommonConstant.ROLEEMPLOYEE));
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
		return 0;// 注册失败
	}

	/**
	 * 判断数据库中是否有该用户名（用户名是否可用）
	 * 
	 * @param username
	 * @return boolean
	 */
	public boolean isUsernameExists(String username) {
		String sql = "select * from employee where username=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setString(1, username);
			rs = executeQuery(ps);
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return false;
	}

	/**
	 * 根据员工Id查询员工信息（仅查询审核通过的员工） 
	 * String STATUS2="1"; //审核通过
	 * 
	 * @param employeeid
	 * @return Employee 返回员工信息
	 */
	public Employee selectEmployeeById(Integer employeeid) {
		String sql = "select * from employee where status=? and employeeid=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		ResultSet rs = null;
		try {
			ps.setInt(1, Integer.parseInt(CommonConstant.STATUS2));
			ps.setInt(2, employeeid);
			rs = executeQuery(ps);
			if (rs.next()) {
				return new Employee(rs.getInt("employeeid"), rs
						.getString("realname"), rs.getString("username"), rs
						.getString("password"), rs.getString("phone"), rs
						.getString("email"), rs.getInt("departmentid"), rs
						.getInt("status"), rs.getString("remark"), rs
						.getInt("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return null;
	}

	/**
	 * 根据员工Id更改员工状态status
	 * 0表示正在审核，登录失败，1表示审核通过，登录成功，2表示审核未通过，3用户名或密码错误，登录失败，4关闭，登录失败
	 * 
	 * @param status
	 * @param employeeid
	 * @return int 是否更改成功，失败为-1，成功为返回更新条数
	 */
	public int updateEmpStatusById(int status, Integer employeeid) {
		String sql = "update employee set status=? where employeeid=?";
		Connection conn = getConnection();
		PreparedStatement ps = getPS(conn, sql);
		try {
			ps.setInt(1, status);
			ps.setInt(2, employeeid);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps, conn);
		}
		return -1;
	}

}
