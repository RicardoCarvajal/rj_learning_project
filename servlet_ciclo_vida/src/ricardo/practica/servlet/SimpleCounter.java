package ricardo.practica.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleCounter
 */
@WebServlet(description = "Ejemplo de servlet para demostrar su ciclo de vida",
            urlPatterns = {"/SimpleCounter"})
public class SimpleCounter extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private int count = 0;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleCounter() {
        super();
        // TODO Auto-generated constructor stub
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
