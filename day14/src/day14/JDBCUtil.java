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
 * @describe ��ȡ���ݿ�����ݵ�
 * @author yjbo
 * @date 2018��1��6�� ����12:51:30
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
	 * @describe ��ȡ�û���Ϣ ʹ�õ���test2��
	 * @author yjbo
	 * @date 2018��1��6�� ����12:54:00
	 */
	public ArrayList<User> findAllUsers() {
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
			// ִ��MYSQL���
			psm = con.prepareStatement("select id,name,password from user_jdbc");
			rs = psm.executeQuery();
			System.out.println("��" + "\t" + "���" + "\t" + "����" + "\t" + "����");
			while (rs.next()) {// rs�ڸ���˳��ȡgetString(2);
				User s = new User();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPassword(rs.getString(3));
				stulist.add(s);
				System.out.println(s.toString());
			}
		} catch (Exception e) {
			System.out.println("��ʾ�������ݱ���findAllUsersԭ��" + e.getMessage());
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
	 * @describe ��ѯ�Ƿ��и��û�����ʹ�÷�Χ����¼��
	 * @author yjbo
	 * @date 2018��1��6�� ����1:55:28
	 */
	public User findUser(String name, String pwd) {
		User user = null;
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
			// ִ��MYSQL���
			psm = con.prepareStatement(
					"select id,name,password from user_jdbc where name='" + name + "' and password = '" + pwd + "'");
			rs = psm.executeQuery();
			System.out.println("��" + "\t" + "���" + "\t" + "����" + "\t" + "����");
			if (!rs.next()) {
				System.out.println("û���û���Ϊ" + name + "������");
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
			System.out.println("��ʾ�������ݱ���findUserԭ��" + e.getMessage());
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
	 * @describe �����û���Ϣ
	 * @author yjbo
	 * @date 2018��1��6�� ����2:09:35
	 */
	public boolean update(int id, String name, String password) {
		User user = null;
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
			// ִ��MYSQL���
			psm = con.prepareStatement(
					"update user_jdbc set name = '" + name + "',password='" + password + "'  where id='" + id + "'");
			int executeUpdate = psm.executeUpdate();
			System.out.println("====" + executeUpdate);
			// int executeUpdate =
			// psm.executeUpdate();//�˴��Ƿ���Ҫ�жϷ���ֵ�����������Լ�����ֵ��������ʲôҲ������
			// if (executeUpdate == 0) {
			// System.out.println("��" + "\t" + "���" + "\t" + "����" + "\t" +
			// "����");
			// System.out.println("���û����ݸ��³ɹ�");
			// } else if (executeUpdate == 1) {
			// System.out.println("���û����ݸ���ʧ��");
			// }
		} catch (Exception e) {
			System.out.println("��ʾ�������ݱ���updateԭ��" + e.getMessage());
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
	 * @describe �����û� ��id�����ݿ���������, �˴��������ݿ���������name�ֶ�ΪUnique������Ϊ�ظ����ݣ�
	 * @author yjbo
	 * @date 2018��1��6�� ����2:31:11
	 */
	public boolean insertUser(String name, String password) {
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
			// ִ��MYSQL���
			psm = con.prepareStatement(
					"insert into user_jdbc(name,password) values('" + name + "','" + password + "');");
			int executeUpdate = psm.executeUpdate();
			System.out.println("====" + executeUpdate);
		} catch (Exception e) {
			System.out.println("�������ݱ���insertUserԭ��" + e.getMessage());
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
	public boolean deleteUser(int id) {
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
			// ִ��MYSQL���
			psm = con.prepareStatement("delete from user_jdbc where id ='" + id + "';");
			int executeUpdate = psm.executeUpdate();
			System.out.println("====" + executeUpdate);
		} catch (Exception e) {
			System.out.println("ɾ�����ݱ���deleteUserԭ��" + e.getMessage());
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
	 * @describe ������������û�
	 * @author yjbo
	 * @date 2018��1��7�� ����5:04:21
	 */
	public void addRandomUser() {
		long currentTimeMillis = System.currentTimeMillis();
		initJdbc();
		try {
			// ����������
			Class.forName(url);
			// ����MYSQL
			con = DriverManager.getConnection(connectSql, sqlUser, sqlPasswd);
			String sql = "insert into user_jdbc(name,password) values(?,?)";
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
			System.out.println("�������ݱ���addRandomUserԭ��" + e.getMessage());
		} finally {
			try {
				closeJdbc();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			long currentTimeMillis2 = System.currentTimeMillis();
			System.out.println("ִ��Ч�ʣ�"+(currentTimeMillis2 - currentTimeMillis) / 1000 + "s");
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
		connectSql = prop.getProperty("connectSql"); // "jdbc:mysql://192.168.1.102:3306/user_jdbc";
														// //����MySQL���ݿ�
		sqlUser = prop.getProperty("sqlUser"); // "root"; //���ݿ��˺�
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
