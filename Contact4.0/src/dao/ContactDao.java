package dao;

import java.util.List;

import beans.Contact;
import util.PageBean;

public interface ContactDao {
	/**添加联系人*/
	public void addContact (Contact contact);

	/**删除联系人通过ID */
	public void delContactByID(String id);

	/**更新联系人 */
	public void updateContact(Contact contact);

	/** 查询联系人通过ID */
	public Contact searchByID(int id);
	/**查询所有联系人*/
	public List searchAll();
	/**查询联系人数量*/
	public Long getContactCount();
	/**分页获取联系人*/
	public List<Contact> getContactByPage(int current,int maxResult);
	/**封装Page*/
	public void setPageBean(PageBean<Contact> pageBean);
	/**根据开始位置获得联系人*/
	public List<Contact> getContactByStart(int startIndex,int maxResult);
}
