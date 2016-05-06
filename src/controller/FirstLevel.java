package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Level1;
import org.apache.log4j.Logger;
import persistence.AbstractDAO;

/**
 * Created by Michael on 4/28/2016.
 */
@WebServlet(name = "FirstLevel", urlPatterns = {"/html/Level/One"})
public class FirstLevel extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Logger log = Logger.getLogger(this.getClass());
    private AbstractDAO<Level1> levelOneDAO = new AbstractDAO<Level1>(Level1.class);
    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        List levels = levelOneDAO.getAll();
        String json = gson.toJson(levels);
        out.println(json);
        out.close();
        log.info(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                sb.append(s);
                log.info("reading lines: " + s);
            }
            log.info("all the lines that have been read: " + sb);
            Level1 levelOne = gson.fromJson(sb.toString(), Level1.class);
            levelOneDAO.update(levelOne);
            response.getOutputStream().print(gson.toJson(levelOne));
            response.getOutputStream().flush();
            log.info(levelOne.toString());
            log.info("Update occurred:");
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
                sb.append(s);
                log.info("reading lines: " + s);
            }
            log.info("all the lines that have been read: " + sb);
            Level1 levelOne = gson.fromJson(sb.toString(), Level1.class);
            int result = levelOneDAO.create(levelOne);
            response.getOutputStream().print(gson.toJson(levelOne));
            response.getOutputStream().flush();
            log.info(levelOne.toString());
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
            Level1 levelOne = gson.fromJson(sb.toString(), Level1.class);
            levelOneDAO.delete(levelOne);
            response.getOutputStream().print(gson.toJson(levelOne));
            response.getOutputStream().flush();
            log.info(levelOne.toString());
            log.info("Attempted to Delete");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getOutputStream().print(gson.toJson("{'message' : 'failure'}"));
            response.getOutputStream().flush();
        }
    }
}
