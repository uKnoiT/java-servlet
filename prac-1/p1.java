import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p1 extends HttpServlet
{
    public void showTable(PrintWriter out, ResultSet rs)
    {
        try
        {
            out.println("<br><br>table:");
            ResultSetMetaData rsmd = rs.getMetaData();      // just to display column name too
            
            out.println("<head><link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css' integrity='sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh' crossorigin='anonymous'></head>");

            out.println("<table class='table table-responsive'><thead><tr>");
            out.println("<th>" + rsmd.getColumnLabel(1) + "</th>");
            // out.println("<th> | </th>");
            out.println("<th>" + rsmd.getColumnLabel(2) + "</th>");
            out.println("</tr></thead><tbody>");
            while(rs.next())
            {
                out.println("<tr><td>" + rs.getInt(1) + "</td>");
                // out.println("<td> | </td>");
                out.println("<td>" + rs.getString(2) + "</td></tr>");
            }
            out.println("</tbody></table>");
        }
        catch(Exception e)
        {
            out.println("<br><i><b>" + e + "</i></b>");
        }
    }

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
    {
        // String url = "jdbc:mysql://localhost:3306/ejava";
        String url = "jdbc:mysql://localhost:3306/ejava?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

	String n = req.getParameter("name");
        String r = req.getParameter("roll");

        String query1 = "insert into prac1 values('"+r+"','"+n+"')";
        String query2 = "select * from prac1;";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("driver loaded");

            Connection con = DriverManager.getConnection(url, user, pass);
            out.println("<br>connection established");

            Statement stmt = con.createStatement();
            int x = stmt.executeUpdate(query1);
            ResultSet rs = stmt.executeQuery(query2);

            if(x==1)
            {
                out.println("<br>data inserted successfully");
                showTable(out, rs);
            }
            else
            {
                out.println("<br><i><b>failed to insert</i></b>");

                if(rs.next() != false) showTable(out, rs);
                else out.println("<br><i><b>empty table!</i></b>");
            }
            con.close();
        }
        catch(Exception e)
        {
            out.println("<br><i><b>" + e + "</i></b>");
        }
    }
}
