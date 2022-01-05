package ricardo.practica.servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitDestroyCounter
 */
@WebServlet(description = "Servlet de practica que muestra el uso de los metodos init y destroy",
            urlPatterns = {"/InitDestroyCounter"},
            initParams = {@WebInitParam(name = "initial",
                                        value = "125")})
public class InitDestroyCounter extends HttpServlet {

    private static final long serialVersionUID = 1L;

    int count;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitDestroyCounter() {
        super();
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init() throws ServletException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader("Init.initial");
            bufferedReader = new BufferedReader(fileReader);
            String initial = bufferedReader.readLine();
            count = Integer.parseInt(initial);
            return;
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (NumberFormatException e) {
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e2) {

            }
        }

        String initial = getInitParameter("initial");

        try {
            count = Integer.parseInt(initial);
            return;
        } catch (NumberFormatException e) {
            count = 0;
        }

    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
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
            if (count % 10 == 0)
                saveState();
            out.println("Desde que cargo, este servlet ha sido accedido " + count
                    + " veces.\n El archivo de respaldo esta en:" + System.getProperty("user.dir"));
        }

    }

    public void saveState() {

        FileWriter fileWriter = null;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter("Init.initial");
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(count);
            return;
        } catch (IOException e) {
            // TODO: handle exception
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }

}
