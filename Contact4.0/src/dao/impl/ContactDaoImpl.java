package dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import beans.Contact;
import dao.ContactDao;
import util.ComPoolUtil;
import util.JdbcUtil;
import util.PageBean;

public class ContactDaoImpl implements ContactDao {
	@Override
	public void addContact(Contact contact) {
		String sql = "insert into t_contact(name,gender,age,phone,email,qq) values(?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner();
		try {
			runner.update(JdbcUtil.getConn(), sql, new Object[] { contact.getName(), contact.getGender(),
					contact.getAge(), contact.getPhone(), contact.getEmail(), contact.getQq() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delContactByID(String id) {
		String sql = "delete from t_contact where id=?";
		QueryRunner runner = new QueryRunner();
		try {
			runner.update(JdbcUtil.getConn(), sql, new Object[] { id });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateContact(Contact contact) {
		String sql = "update t_contact set name=?,gender=?,age=?,phone=?,email=?,qq=? where id=?";
		QueryRunner runner = new QueryRunner();
		try {
			runner.update(JdbcUtil.getConn(), sql, new Object[] { contact.getName(), contact.getGender(),
					contact.getAge(), contact.getPhone(), contact.getEmail(), contact.getQq(), contact.getId() });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Contact searchByID(int id) {
		String sql = "select * from t_contact where id=?";
		QueryRunner runner = new QueryRunner();
		Contact contact = null;
		try {
			contact = runner.query(JdbcUtil.getConn(), sql, new BeanHandler<Contact>(Contact.class),
					new Object[] { id });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return contact;
		}
	}

	@Override
	public List searchAll() {
		String sql = "select * from t_contact";
		QueryRunner runner = new QueryRunner();
		try {
			List<Contact> list = runner.query(JdbcUtil.getConn(), sql, new BeanListHandler<Contact>(Contact.class));
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long getContactCount() {
		Long count = 0l;
		try {
			count = (Long) ComPoolUtil.getQueryRunner().query("select count(*) from t_contact", new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Contact> getContactByPage(int current, int maxResult) {
		List<Contact> list = null;
		int startIndex=(current-1)*maxResult;
		try {
			list = ComPoolUtil.getQueryRunner().query("select * from t_contact limit ?,?",
					new BeanListHandler<Contact>(Contact.class), new Object[] { startIndex, maxResult });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void setPageBean(PageBean<Contact> pageBean) {
		//数据总数
		int total=getContactCount().intValue();
		pageBean.setTotal(total);
		//开始位置
		int startIndex=(pageBean.getCurrent()-1)*pageBean.getMaxResult();
		
		List<Contact> list=getContactByStart(startIndex, pageBean.getMaxResult());
		//封装数据到pageBean
		
		pageBean.setList(list);
		
	}

	@Override
	public List<Contact> getContactByStart(int startIndex, int maxResult) {
		List<Contact> list = null;
		try {
			list = ComPoolUtil.getQueryRunner().query("select * from t_contact limit ?,?",
					new BeanListHandler<Contact>(Contact.class), new Object[] { startIndex, maxResult });
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

}
