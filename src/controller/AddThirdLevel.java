package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import entity.Level1;
import entity.Level2;
import entity.Level3;
import org.apache.log4j.Logger;
import persistence.Level1DAO;
import persistence.Level2DAO;
import persistence.Level3DAO;

/**
 * Created by Michael on 4/28/2016.
 */
@WebServlet(name = "AddThirdLevel", urlPatterns = {"/html/AddLevel/Three"})
public class AddThirdLevel extends HttpServlet {
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
