import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class home extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h2><i>Its home!</i></h2>");
	}
}
