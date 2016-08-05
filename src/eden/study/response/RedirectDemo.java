package eden.study.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 重定向的两种写法
 * @author xxx
 *
 */
public class RedirectDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.直接用senRedirect()方法
//		response.sendRedirect("/JavaWeb_Servlet_Response_20160804/index.jsp");
		
		//2.设置响应头  
		response.setHeader("location", "/JavaWeb_Servlet_Response_20160804/index.jsp");
		response.setStatus(HttpServletResponse.SC_FOUND);//302状态码 获取到HTTP响应报文头部的Location字段信息，并发起一个GET请求
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
