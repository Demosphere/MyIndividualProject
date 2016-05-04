package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Level4;
import org.apache.log4j.Logger;
import persistence.Level4DAO;

/**
 * Created by Michael on 4/28/2016.
 */
@WebServlet(name = "FourthLevel", urlPatterns = {"/html/Level/Four"})
public class FourthLevel extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("{success : 'inside doPost()'}");

        response.setContentType("application/json");
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        try {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                log.info("reading lines: " + s);
                sb.append(s);
            }
            log.info("all the lines that have been read: " + sb);

            Level4 levelFour = gson.fromJson(sb.toString(), Level4.class);

            Level4DAO levelFourDAO = new Level4DAO();

            int result = levelFourDAO.addLevel4(levelFour);

            response.getOutputStream().print(gson.toJson(levelFour));
            response.getOutputStream().flush();

            log.info(levelFour.toString());
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
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        try {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                sb.append(s);
                log.info("reading lines: " + s);
            }
            log.info("all the lines that have been read: " + sb);

            Level4 levelFour = gson.fromJson(sb.toString(), Level4.class);

            Level4DAO levelFourDAO = new Level4DAO();

            boolean result = levelFourDAO.deleteLevel4(levelFour);

            response.getOutputStream().print(gson.toJson(levelFour));
            response.getOutputStream().flush();

            log.info(levelFour.toString());
            log.info("Result of attempt to Delete: " + result);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getOutputStream().print(gson.toJson("{'message' : 'failure'}"));
            response.getOutputStream().flush();
        }
    }
}
