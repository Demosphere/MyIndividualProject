package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import entity.Level1;
import org.apache.log4j.Logger;
import persistence.Level1DAO;

/**
 * Created by Michael on 4/28/2016.
 */
@WebServlet(name = "AddRootLevel", urlPatterns = {"/html/AddRootLevel"})
public class AddRootLevel extends HttpServlet {
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
                sb.append(s);
                log.info("reading lines: " + s);
            }
            log.info("all the lines that have been read: " + sb);

            Level1 levelOne = gson.fromJson(sb.toString(), Level1.class);

            Level1DAO levelOneDAO = new Level1DAO();

            int result = levelOneDAO.addLevel1(levelOne);

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
}
