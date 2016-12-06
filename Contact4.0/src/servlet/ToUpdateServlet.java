package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Contact;
import dao.ContactDao;
import dao.impl.ContactDaoImpl;

public class ToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得数据 封装数据 
		request.setCharacterEncoding("UTF-8");
	    Contact contact=new Contact();
	    contact.setId(Integer.parseInt(request.getParameter("id")));
	    contact.setName(request.getParameter("name"));
	    contact.setGender(request.getParameter("gender"));
	    contact.setAge(Integer.parseInt(request.getParameter("age")));
	    contact.setPhone(request.getParameter("phone"));
	    contact.setEmail(request.getParameter("email"));
	    contact.setQq(request.getParameter("qq"));
	    //保存
	    ContactDao dao=new ContactDaoImpl();
	    dao.updateContact(contact);
	    //转到主页面
	    response.sendRedirect("/Contact4.0/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
