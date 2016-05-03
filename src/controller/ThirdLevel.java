package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import entity.Level3;
import org.apache.log4j.Logger;
import persistence.Level3DAO;

/**
 * Created by Michael on 4/28/2016.
 */
@WebServlet(name = "ThirdLevel", urlPatterns = {"/html/Level/Three"})
public class ThirdLevel extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();

        try {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) {
                log.info("reading lines: " + s);
                sb.append(s);
            }
            log.info("all the lines that have been read: " + sb);

            Level3 levelThree = gson.fromJson(sb.toString(), Level3.class);

            Level3DAO levelThreeDAO = new Level3DAO();

            int result = levelThreeDAO.addLevel3(levelThree);

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
}
