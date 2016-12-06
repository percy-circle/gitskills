package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Contact;
import dao.ContactDao;
import dao.impl.ContactDaoImpl;
import util.PageBean;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String current = request.getParameter("current");
		int maxResult = 3;
		int intCurrent = 1;
		if (current != null && !"".equals(current)) {
			intCurrent = Integer.parseInt(current);
		}
		ContactDao dao = new ContactDaoImpl();
		PageBean<Contact> bean=new PageBean<Contact>();
		bean.setCurrent(intCurrent);
		bean.setMaxResult(maxResult);
		dao.setPageBean(bean);
		
		request.setAttribute("PageBean", bean);
		
/*		int maxResult = 3;
		String current = request.getParameter("current");
		int intCurrent = 1;
		if (current != null && !"".equals(current)) {
			intCurrent = Integer.parseInt(current);
		}
		ContactDao dao = new ContactDaoImpl();
		List<Contact> list = dao.getContactByPage(intCurrent, maxResult);
		int count = dao.getContactCount().intValue();
		int lastPage = count % maxResult == 0 ? count / maxResult : (count / maxResult) + 1;
		request.setAttribute("list", list);
		request.setAttribute("current", intCurrent);
		request.setAttribute("lastPage", lastPage);*/
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
