package yy.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.junit.Test;

import yy.bean.Customer;
import yy.bean.Hobby;
import yy.bean.HobbyList;

/**
 * @describe 获取数据库的数据的
 * @author yjbo
 * @date 2018年1月6日 下午12:51:30
 */
public class JDBCUtil {
	private ArrayList<Customer> stulist = new ArrayList<Customer>();
	private String url;
	private String connectSql;
	private String sqlCustomer;
	private String sqlPasswd;

	Connection con = null;
	PreparedStatement psm = null;
	ResultSet rs = null;

	public JDBCUtil() {
	}

	@Test
	public void test() {
		List<Hobby> list = new HobbyList().getList();
		System.out.println(list.size());
		// insertCustomer(new Customer("杨建波4", "男", "1992-05-06", "18501481884",
		// "yangjbm@yonyou.com", "看电影,学习", "普通客户",
		// "偶遇同楼的女生遛狗，一次就让人绝望了，这辈子是追不上她了"));

	}

	/**
	 * @describe 获取用户信息 使用的是test2表
	 * @author yjbo
	 * @date 2018年1月6日 下午12:54:00
	 */
	public ArrayList<Customer> findAllCustomers() {
		stulist = new ArrayList<>();
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			// 执行MYSQL语句
			psm = con.prepareStatement("select id,name,sex,birthday,phone,email,hobby,kind,remarks from day15customer");
			rs = psm.executeQuery();
			// if (!rs.next()) {//不需要添加，没有则走不到while内部
			// } else {
			while (rs.next()) {// rs内根据顺序取getString(2);
				Customer s = new Customer();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setSex(rs.getString(3));
				s.setBirthday(rs.getString(4));
				s.setPhone(rs.getString(5));
				s.setEmail(rs.getString(6));
				s.setHobby(rs.getString(7));
				s.setKind(rs.getString(8));
				s.setRemarks(rs.getString(9));
				stulist.add(s);
				System.out.println(s.toString());
			}
			// }
		} catch (Exception e) {
			System.out.println("显示所有数据报错，findAllCustomers原因：" + e.getMessage());
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
	 * @describe 通过id获取该用户的详情信息
	 * @author yjbo
	 * @date 2018年1月14日19:23:23
	 */
	public Customer findCustomerId(int id) {
		Customer Customer = null;
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			// 执行MYSQL语句
			psm = con.prepareStatement(
					"select id,name,sex,birthday,phone,email,hobby,kind,remarks from day15customer where id=?");
			psm.setInt(1, id);
			rs = psm.executeQuery();
			while (rs.next()) {
				Customer = new Customer();
				Customer.setId(rs.getInt(1));
				Customer.setName(rs.getString(2));
				Customer.setSex(rs.getString(3));
				Customer.setBirthday(rs.getString(4));
				Customer.setPhone(rs.getString(5));
				Customer.setEmail(rs.getString(6));
				Customer.setHobby(rs.getString(7));
				Customer.setKind(rs.getString(8));
				Customer.setRemarks(rs.getString(9));
				System.out.println(Customer.toString());
			}
		} catch (Exception e) {
			System.out.println("显示所有数据报错，findCustomerId原因：" + e.getMessage());
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Customer;
	}

	/**
	 * @describe 更新用户信息
	 * @author yjbo
	 * @date 2018年1月6日 下午2:09:35
	 */
	public boolean updateCustomer(Customer customer) {
		boolean isUpdateFlag = false;
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			// 执行MYSQL语句
			psm = con.prepareStatement(
					"update day15customer set name=?,sex=?,birthday=?,phone=?,email=?,hobby=?,kind=?,remarks=? where id=?");
			psm.setString(1, customer.getName());
			psm.setString(2, customer.getSex());
			psm.setString(3, customer.getBirthday());
			psm.setString(4, customer.getPhone());
			psm.setString(5, customer.getEmail());
			psm.setString(6, customer.getHobby());
			psm.setString(7, customer.getKind());
			psm.setString(8, customer.getRemarks());
			psm.setInt(9, customer.getId());
			int executeUpdate = psm.executeUpdate();
			isUpdateFlag = true;
			System.out.println("====" + executeUpdate);
		} catch (Exception e) {
			System.out.println("显示所有数据报错，updateCustomer原因：" + e.getMessage());
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isUpdateFlag;
	}

	/**
	 * @describe 新增用户 ；id是数据库给他分配的, 此处我再数据库中设置了name字段为Unique，不能为重复数据；
	 * @author yjbo
	 * @date 2018年1月6日 下午2:31:11
	 */
	public boolean insertCustomer(Customer customer) {
		if (findCustomerName(customer.getName())) {// 如果已经有了该用户名，则不能继续插入数据；保证用户名唯一
			return false;
		}
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			String sqlStr = "insert into day15customer(name,sex,birthday,phone,email,hobby,kind,remarks) values(?,?,?,?,?,?,?,?);";
			// 执行MYSQL语句
			psm = con.prepareStatement(sqlStr);
			psm.setString(1, customer.getName());
			psm.setString(2, customer.getSex());
			psm.setString(3, customer.getBirthday());
			psm.setString(4, customer.getPhone());
			psm.setString(5, customer.getEmail());
			psm.setString(6, customer.getHobby());
			psm.setString(7, customer.getKind());
			psm.setString(8, customer.getRemarks());
			int executeUpdate = psm.executeUpdate();
			System.out.println("====" + executeUpdate);
		} catch (Exception e) {
			System.out.println("插入数据报错，insertCustomer原因：" + e.getMessage());
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
	public boolean deleteCustomer(int id) {
		boolean isDeleteFlag = false;
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			// 执行MYSQL语句
			psm = con.prepareStatement("delete from day15customer where id =?;");
			psm.setInt(1, id);
			int executeUpdate = psm.executeUpdate();
			if (executeUpdate == 1) {// 0的时候说明没有该用户，
				isDeleteFlag = true;
			}
			System.out.println("====" + executeUpdate);
		} catch (Exception e) {
			System.out.println("删除数据报错，deleteCustomer原因：" + e.getMessage());
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isDeleteFlag;
	}

	/**
	 * @describe 查询是否有该用户名；（使用范围：添加数据时检查是否用户名重复）
	 * @author yjbo
	 * @date 2018年1月14日13:58:23
	 */
	public Boolean findCustomerName(String name) {
		boolean isFindFlag = true;// 默认在数据库内找到了该用户
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			// 执行MYSQL语句
			psm = con.prepareStatement("select * from day15customer where name=?");
			psm.setString(1, name);
			rs = psm.executeQuery();
			if (!rs.next()) {// 没有该注册用户名，可以注册
				isFindFlag = false;
			}
		} catch (Exception e) {
			System.out.println("显示所有数据报错，findCustomerName原因：" + e.getMessage());
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isFindFlag;
	}

	/**
	 * @describe 随机新增大批用户
	 * @author yjbo
	 * @date 2018年1月7日 下午5:04:21
	 */
	public void addRandomCustomer() {
		long currentTimeMillis = System.currentTimeMillis();
		initJdbc();
		try {
			// 加载驱动包
			Class.forName(url);
			// 连接MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			String sql = "insert into day15customer(name,password) values(?,?)";
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
			System.out.println("新增数据报错，addRandomCustomer原因：" + e.getMessage());
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			long currentTimeMillis2 = System.currentTimeMillis();
			System.out.println("执行效率：" + (currentTimeMillis2 - currentTimeMillis) / 1000 + "s");
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
		connectSql = prop.getProperty("connectSql"); // "jdbc:mysql://192.168.1.102:3306/test";
														// //链接MySQL数据库
		sqlCustomer = prop.getProperty("sqlCustomer"); // "root"; //数据库账号
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
