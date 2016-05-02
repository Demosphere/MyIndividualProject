package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import entity.Level4;
import org.apache.log4j.Logger;
import persistence.Level4DAO;

/**
 * Created by Michael on 4/28/2016.
 */
@WebServlet(name = "AddFourthLevel", urlPatterns = {"/html/AddLevel/Four"})
public class AddFourthLevel extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("{success : 'inside doPost()'}");

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
}
