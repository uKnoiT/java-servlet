// import java.io.*;
// import javax.servlet.*;
// import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class p2 extends GenericServlet
{
	private static final long serialVersionUID = 1L;
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		// out.print("<form action='./server2'>");
		out.print("<html>");
		out.print("<head><title>server</title></head>");
		out.print("<body><h1>Hello!<h1>");
		out.print("<h2>This is GenericServlet program<h2>");
		out.print("</body></html>");
	}
}
