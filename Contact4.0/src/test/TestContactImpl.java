package test;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import beans.Contact;
import dao.ContactDao;
import dao.impl.ContactDaoImpl;

public class TestContactImpl {
    @Test
    public void testAdd(){
    	ContactDao dao=new ContactDaoImpl();
    	dao.addContact(new Contact("蔺凯龙1","男",22,"15573223494","563116570@qq.com","563116570"));
    }
    @Test
    public void testDel(){
    	ContactDao dao=new ContactDaoImpl();
    	dao.delContactByID("1");
    }
    @Test
    public void testUpdate(){
    	ContactDao dao=new ContactDaoImpl();
    	Contact contact=new Contact();
    	contact.setId(2);
    	contact.setName("凯龙");
    	contact.setGender("男");
    	dao.updateContact(contact); 	
    }
    @Test
    public void testQuery(){
    	ContactDao dao=new ContactDaoImpl();
        Contact contact=dao.searchByID(2);
        System.out.println(contact.getName());
    }
    @Test
    public void testQueryAll(){
    	ContactDao dao=new ContactDaoImpl();
    	List<Contact> list=dao.searchAll();
        for (Contact contact : list) {
			System.out.println(contact.getName());
		}
    }
}
