package day14;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.junit.Test;

import bean.User;

/**
 * @describe 获取数据库的数据的
 * @author yjbo
 * @date 2018年1月6日 下午12:51:30
 */
public class JDBCUtil {
	private ArrayList<User> stulist = new ArrayList<User>();
	private String url;
	private String connectSql;
	private String sqlUser;
	private String sqlPasswd;

	Connection con = null;
	PreparedStatement psm = null;
	ResultSet rs = null;

	@Test
	public void test() {
		addRandomUser();
	}

	/**
	 * @describe 获取用户信息 使用的是test2表
	 * @author yjbo
	 * @date 2018年1月6日 下午12:54:00
	 */
	public ArrayList<User> findAllUsers() {
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
			// 执行MYSQL语句
			psm = con.prepareStatement("select id,name,password from user_jdbc");
			rs = psm.executeQuery();
			System.out.println("类" + "\t" + "编号" + "\t" + "姓名" + "\t" + "密码");
			while (rs.next()) {// rs内根据顺序取getString(2);
				User s = new User();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPassword(rs.getString(3));
				stulist.add(s);
				System.out.println(s.toString());
			}
		} catch (Exception e) {
			System.out.println("显示所有数据报错，findAllUsers原因：" + e.getMessage());
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return stulist;
	}

	/**
	 * @describe 查询是否有该用户；（使用范围：登录）
	 * @author yjbo
	 * @date 2018年1月6日 下午1:55:28
	 */
	public User findUser(String name, String pwd) {
		User user = null;
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
			// 执行MYSQL语句
			psm = con.prepareStatement(
					"select id,name,password from user_jdbc where name='" + name + "' and password = '" + pwd + "'");
			rs = psm.executeQuery();
			System.out.println("类" + "\t" + "编号" + "\t" + "姓名" + "\t" + "密码");
			if (!rs.next()) {
				System.out.println("没有用户名为" + name + "的数据");
			} else {
				while (rs.next()) {
					user = new User();
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setPassword(rs.getString(3));
					System.out.println(user.toString());
				}
			}
		} catch (Exception e) {
			System.out.println("显示所有数据报错，findUser原因：" + e.getMessage());
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	/**
	 * @describe 更新用户信息
	 * @author yjbo
	 * @date 2018年1月6日 下午2:09:35
	 */
	public boolean update(int id, String name, String password) {
		User user = null;
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
			// 执行MYSQL语句
			psm = con.prepareStatement(
					"update user_jdbc set name = '" + name + "',password='" + password + "'  where id='" + id + "'");
			int executeUpdate = psm.executeUpdate();
			System.out.println("====" + executeUpdate);
			// int executeUpdate =
			// psm.executeUpdate();//此处是否需要判断返回值，还不懂，以及返回值的作用是什么也不懂。
			// if (executeUpdate == 0) {
			// System.out.println("类" + "\t" + "编号" + "\t" + "姓名" + "\t" +
			// "密码");
			// System.out.println("该用户数据更新成功");
			// } else if (executeUpdate == 1) {
			// System.out.println("该用户数据更新失败");
			// }
		} catch (Exception e) {
			System.out.println("显示所有数据报错，update原因：" + e.getMessage());
			return false;
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * @describe 新增用户 ；id是数据库给他分配的, 此处我再数据库中设置了name字段为Unique，不能为重复数据；
	 * @author yjbo
	 * @date 2018年1月6日 下午2:31:11
	 */
	public boolean insertUser(String name, String password) {
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
			// 执行MYSQL语句
			psm = con.prepareStatement(
					"insert into user_jdbc(name,password) values('" + name + "','" + password + "');");
			int executeUpdate = psm.executeUpdate();
			System.out.println("====" + executeUpdate);
		} catch (Exception e) {
			System.out.println("插入数据报错，insertUser原因：" + e.getMessage());
			return false;
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * @describe 根据id删除用户，也可以通过name删除，因为它们都是唯一的。
	 * @author yjbo
	 * @date 2018年1月6日 下午5:21:38
	 */
	public boolean deleteUser(int id) {
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
			// 执行MYSQL语句
			psm = con.prepareStatement("delete from user_jdbc where id ='" + id + "';");
			int executeUpdate = psm.executeUpdate();
			System.out.println("====" + executeUpdate);
		} catch (Exception e) {
			System.out.println("删除数据报错，deleteUser原因：" + e.getMessage());
			return false;
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * @describe 随机新增大批用户
	 * @author yjbo
	 * @date 2018年1月7日 下午5:04:21
	 */
	public void addRandomUser() {
		long currentTimeMillis = System.currentTimeMillis();
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
			String sql = "insert into user_jdbc(name,password) values(?,?)";
			psm = con.prepareStatement(sql);
			// 执行MYSQL语句
			for (int i = 0; i < 10000; i++) {
				psm.setString(1, "yyd" + i);
				psm.setString(2, "pwd" + i);
				psm.addBatch();
				if (i / 1000 == 0) {// 防止大批量出错,不加会报错，效率的确有所提高，可验证
					psm.executeBatch();
				}
			}
			psm.executeBatch();
		} catch (Exception e) {
			System.out.println("新增数据报错，addRandomUser原因：" + e.getMessage());
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			long currentTimeMillis2 = System.currentTimeMillis();
			System.out.println("执行效率："+(currentTimeMillis2 - currentTimeMillis) / 1000 + "s");
		}
	}

	/**
	 * @describe 初始化jdbc
	 * @author yjbo
	 * @date 2018年1月6日 下午1:35:16
	 */
	private void initJdbc() {
		InputStream in = this.getClass().getResourceAsStream("/jdbc.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		url = prop.getProperty("jdbcurl"); // "com.mysql.jdbc.Driver"; //加载驱动包
		connectSql = prop.getProperty("connectSql"); // "jdbc:mysql://192.168.1.102:3306/user_jdbc";
														// //链接MySQL数据库
		sqlUser = prop.getProperty("sqlUser"); // "root"; //数据库账号
		sqlPasswd = prop.getProperty("sqlPasswd"); // "root"; //你的数据库密码
	}

	/**
	 * @describe 关闭jdbc
	 * @author yjbo
	 * @date 2018年1月6日 下午1:35:16
	 */
	private void closeJdbc() throws SQLException {
		// 关闭数据库连接
		if (rs != null) {
			rs.close();
		}
		if (psm != null) {
			psm.close();
		}
		if (con != null) {
			con.close();
		}
	}
}
