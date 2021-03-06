package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Level3;
import org.apache.log4j.Logger;
import persistence.AbstractDAO;

/**
 * Created by Michael on 4/28/2016.
 */
@WebServlet(name = "ThirdLevel", urlPatterns = {"/html/Level/Three"})
public class ThirdLevel extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Logger log = Logger.getLogger(this.getClass());
    private AbstractDAO<Level3> levelThreeDAO = new AbstractDAO<Level3>(Level3.class);
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
            Level3 levelThree = gson.fromJson(sb.toString(), Level3.class);
            levelThreeDAO.update(levelThree);
            response.getOutputStream().print(gson.toJson(levelThree));
            response.getOutputStream().flush();
            log.info(levelThree.toString());
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
            Level3 levelThree = gson.fromJson(sb.toString(), Level3.class);
            int result = levelThreeDAO.create(levelThree);
            response.getOutputStream().print(gson.toJson(levelThree));
            response.getOutputStream().flush();
            log.info(levelThree.toString());
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
            Level3 levelThree = gson.fromJson(sb.toString(), Level3.class);
            levelThreeDAO.delete(levelThree);
            response.getOutputStream().print(gson.toJson(levelThree));
            response.getOutputStream().flush();
            log.info(levelThree.toString());
            log.info("Result of attempt to Delete: ");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getOutputStream().print(gson.toJson("{'message' : 'failure'}"));
            response.getOutputStream().flush();
        }
    }
}
