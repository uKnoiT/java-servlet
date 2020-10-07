import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p4 extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String str = req.getParameter("uname");
		out.print("<title>server</title>");
		out.println("hey!.. <b>" + str + "</b>");
	}
}
// out.print("<html>");
// out.print("<body><h1>Hello!<h1>");