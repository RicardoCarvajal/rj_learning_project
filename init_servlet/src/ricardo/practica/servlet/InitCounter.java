package ricardo.practica.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitCounter
 */
public class InitCounter extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private int count = 0;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitCounter() {
        super();
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init() throws ServletException {
        String initial = getInitParameter("initial");
        try {
            count = Integer.parseInt(initial);
        } catch (NumberFormatException e) {
            count = 0;
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();

        synchronized (this) {
            count++;

            out.println("Desde que cargo, este servlet ha sido accedido " + count + " veces.");
        }

    }
}
