package eden.study.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �ض��������д��
 * @author xxx
 *
 */
public class RedirectDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.ֱ����senRedirect()����
//		response.sendRedirect("/JavaWeb_Servlet_Response_20160804/index.jsp");
		
		//2.������Ӧͷ  
		response.setHeader("location", "/JavaWeb_Servlet_Response_20160804/index.jsp");
		response.setStatus(HttpServletResponse.SC_FOUND);//302״̬�� ��ȡ��HTTP��Ӧ����ͷ����Location�ֶ���Ϣ��������һ��GET����
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
