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
import org.apache.log4j.Logger;
import persistence.Level1DAO;
import persistence.Level2DAO;

/**
 * Created by Michael on 4/28/2016.
 */
@WebServlet(name = "AddSecondLevel", urlPatterns = {"/html/AddsLevel/Two"})
public class AddSecondLevel extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/html/AddLevel.html";

        log.info("1.0 got into servlet somehow ?");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

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

            Level2 levelTwo = gson.fromJson(sb.toString(), Level2.class);

            Level2DAO levelTwoDAO = new Level2DAO();

            int result = levelTwoDAO.addLevel2(levelTwo);

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
}
