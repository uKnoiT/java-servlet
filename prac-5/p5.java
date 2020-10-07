import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p5 extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String a = req.getParameter("n1");
		String b = req.getParameter("n2");
		out.print("<title>server</title>");
		out.println("sum: <u>" + (Integer.parseInt(a)+Integer.parseInt(b)) + "</u>");
	}
}
