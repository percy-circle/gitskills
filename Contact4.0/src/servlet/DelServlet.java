package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDao;
import dao.impl.ContactDaoImpl;

public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ContactDao contactDao=new ContactDaoImpl();
		 //执行删除操作
		 contactDao.delContactByID(request.getParameter("id"));
		 //删除完成后转向主页面显示
		 response.sendRedirect("/Contact4.0/IndexServlet");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
