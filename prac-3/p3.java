// import java.io.*;
// import javax.servlet.*;
// import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class p3 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public void init() throws ServletException
	{
		msg = "<h2>This is HttpServlet program<h2>";
	} 

	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		// String str = req.getParameter("uname");
		out.print("<html>");
		out.print("<head><title>server</title></head>");
		out.print("<body><h1>Hello!<h1>");
		out.print(msg);
		out.print("</body></html>");
	}
	public void destroy() {}
}
