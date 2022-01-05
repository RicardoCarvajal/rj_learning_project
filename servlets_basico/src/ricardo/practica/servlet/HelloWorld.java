package ricardo.practica.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(description = "Servlet de practica",
            urlPatterns = {"/HelloWorld"})
public class HelloWorld extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html");

        if (request.getMethod().equals("HEAD"))
            return;

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello " + name + "</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<BIG>Hello " + name + " :-)</BIG>");
        out.println("</BODY></HTML>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        doGet(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Servlet de practica";
    }

}
