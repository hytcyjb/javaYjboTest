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
 * @describe ��ȡ���ݿ�����ݵ�
 * @author yjbo
 * @date 2018��1��6�� ����12:51:30
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
		// insertCustomer(new Customer("���4", "��", "1992-05-06", "18501481884",
		// "yangjbm@yonyou.com", "����Ӱ,ѧϰ", "��ͨ�ͻ�",
		// "ż��ͬ¥��Ů���޹���һ�ξ����˾����ˣ��Ⱳ����׷��������"));

	}

	/**
	 * @describe ��ȡ�û���Ϣ ʹ�õ���test2��
	 * @author yjbo
	 * @date 2018��1��6�� ����12:54:00
	 */
	public ArrayList<Customer> findAllCustomers() {
		stulist = new ArrayList<>();
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			// ִ��MYSQL���
			psm = con.prepareStatement("select id,name,sex,birthday,phone,email,hobby,kind,remarks from day15customer");
			rs = psm.executeQuery();
			// if (!rs.next()) {//����Ҫ��ӣ�û�����߲���while�ڲ�
			// } else {
			while (rs.next()) {// rs�ڸ���˳��ȡgetString(2);
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
			System.out.println("��ʾ�������ݱ���findAllCustomersԭ��" + e.getMessage());
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
	 * @describe ͨ��id��ȡ���û���������Ϣ
	 * @author yjbo
	 * @date 2018��1��14��19:23:23
	 */
	public Customer findCustomerId(int id) {
		Customer Customer = null;
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			// ִ��MYSQL���
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
			System.out.println("��ʾ�������ݱ���findCustomerIdԭ��" + e.getMessage());
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
	 * @describe �����û���Ϣ
	 * @author yjbo
	 * @date 2018��1��6�� ����2:09:35
	 */
	public boolean updateCustomer(Customer customer) {
		boolean isUpdateFlag = false;
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			// ִ��MYSQL���
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
			System.out.println("��ʾ�������ݱ���updateCustomerԭ��" + e.getMessage());
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
	 * @describe �����û� ��id�����ݿ���������, �˴��������ݿ���������name�ֶ�ΪUnique������Ϊ�ظ����ݣ�
	 * @author yjbo
	 * @date 2018��1��6�� ����2:31:11
	 */
	public boolean insertCustomer(Customer customer) {
		if (findCustomerName(customer.getName())) {// ����Ѿ����˸��û��������ܼ����������ݣ���֤�û���Ψһ
			return false;
		}
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			String sqlStr = "insert into day15customer(name,sex,birthday,phone,email,hobby,kind,remarks) values(?,?,?,?,?,?,?,?);";
			// ִ��MYSQL���
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
			System.out.println("�������ݱ���insertCustomerԭ��" + e.getMessage());
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
	 * @describe ����idɾ���û���Ҳ����ͨ��nameɾ������Ϊ���Ƕ���Ψһ�ġ�
	 * @author yjbo
	 * @date 2018��1��6�� ����5:21:38
	 */
	public boolean deleteCustomer(int id) {
		boolean isDeleteFlag = false;
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			// ִ��MYSQL���
			psm = con.prepareStatement("delete from day15customer where id =?;");
			psm.setInt(1, id);
			int executeUpdate = psm.executeUpdate();
			if (executeUpdate == 1) {// 0��ʱ��˵��û�и��û���
				isDeleteFlag = true;
			}
			System.out.println("====" + executeUpdate);
		} catch (Exception e) {
			System.out.println("ɾ�����ݱ���deleteCustomerԭ��" + e.getMessage());
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
	 * @describe ��ѯ�Ƿ��и��û�������ʹ�÷�Χ���������ʱ����Ƿ��û����ظ���
	 * @author yjbo
	 * @date 2018��1��14��13:58:23
	 */
	public Boolean findCustomerName(String name) {
		boolean isFindFlag = true;// Ĭ�������ݿ����ҵ��˸��û�
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			// ִ��MYSQL���
			psm = con.prepareStatement("select * from day15customer where name=?");
			psm.setString(1, name);
			rs = psm.executeQuery();
			if (!rs.next()) {// û�и�ע���û���������ע��
				isFindFlag = false;
			}
		} catch (Exception e) {
			System.out.println("��ʾ�������ݱ���findCustomerNameԭ��" + e.getMessage());
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
	 * @describe ������������û�
	 * @author yjbo
	 * @date 2018��1��7�� ����5:04:21
	 */
	public void addRandomCustomer() {
		long currentTimeMillis = System.currentTimeMillis();
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlCustomer, sqlPasswd);
			String sql = "insert into day15customer(name,password) values(?,?)";
			psm = con.prepareStatement(sql);
			// ִ��MYSQL���
			for (int i = 0; i < 10000; i++) {
				psm.setString(1, "yyd" + i);
				psm.setString(2, "pwd" + i);
				psm.addBatch();
				if (i / 1000 == 0) {// ��ֹ����������,���ӻᱨ��Ч�ʵ�ȷ������ߣ�����֤
					psm.executeBatch();
				}
			}
			psm.executeBatch();
		} catch (Exception e) {
			System.out.println("�������ݱ���addRandomCustomerԭ��" + e.getMessage());
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			long currentTimeMillis2 = System.currentTimeMillis();
			System.out.println("ִ��Ч�ʣ�" + (currentTimeMillis2 - currentTimeMillis) / 1000 + "s");
		}
	}

	/**
	 * @describe ��ʼ��jdbc
	 * @author yjbo
	 * @date 2018��1��6�� ����1:35:16
	 */
	private void initJdbc() {
		InputStream in = this.getClass().getResourceAsStream("/jdbc.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		url = prop.getProperty("jdbcurl"); // "com.mysql.jdbc.Driver"; //����������
		connectSql = prop.getProperty("connectSql"); // "jdbc:mysql://192.168.1.102:3306/test";
														// //����MySQL���ݿ�
		sqlCustomer = prop.getProperty("sqlCustomer"); // "root"; //���ݿ��˺�
		sqlPasswd = prop.getProperty("sqlPasswd"); // "root"; //������ݿ�����
	}

	/**
	 * @describe �ر�jdbc
	 * @author yjbo
	 * @date 2018��1��6�� ����1:35:16
	 */
	private void closeJdbc() throws SQLException {
		// �ر����ݿ�����
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
