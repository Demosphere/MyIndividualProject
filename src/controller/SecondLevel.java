package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Level2;
import org.apache.log4j.Logger;
import persistence.AbstractDAO;

/**
 * Created by Michael on 4/28/2016.
 */
@WebServlet(name = "SecondLevel", urlPatterns = {"/html/Level/Two"})
public class SecondLevel extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Logger log = Logger.getLogger(this.getClass());
    private AbstractDAO<Level2> levelTwoDAO = new AbstractDAO<Level2>(Level2.class);
    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                log.info("reading lines: " + s);
                sb.append(s);
            }
            log.info("all the lines that have been read: " + sb);
            Level2 levelTwo = gson.fromJson(sb.toString(), Level2.class);
            levelTwoDAO.update(levelTwo);
            response.getOutputStream().print(gson.toJson(levelTwo));
            response.getOutputStream().flush();
            log.info(levelTwo.toString());
            log.info("Update occurred");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getOutputStream().print(gson.toJson("{'message' : 'failure'}"));
            response.getOutputStream().flush();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                log.info("reading lines: " + s);
                sb.append(s);
            }
            log.info("all the lines that have been read: " + sb);
            Level2 levelTwo = gson.fromJson(sb.toString(), Level2.class);
            int result = levelTwoDAO.create(levelTwo);
            response.getOutputStream().print(gson.toJson(levelTwo));
            response.getOutputStream().flush();
            log.info(levelTwo.toString());
            log.info("Result of attempt to add: " + result);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getOutputStream().print(gson.toJson("{'message' : 'failure'}"));
            response.getOutputStream().flush();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                sb.append(s);
                log.info("reading lines: " + s);
            }
            log.info("all the lines that have been read: " + sb);
            Level2 levelTwo = gson.fromJson(sb.toString(), Level2.class);
            levelTwoDAO.delete(levelTwo);
            response.getOutputStream().print(gson.toJson(levelTwo));
            response.getOutputStream().flush();
            log.info(levelTwo.toString());
            log.info("Attempted to Delete" );
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getOutputStream().print(gson.toJson("{'message' : 'failure'}"));
            response.getOutputStream().flush();
        }
    }

}
