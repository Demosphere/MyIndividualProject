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
import org.apache.log4j.Logger;

/**
 * Created by Michael on 4/28/2016.
 */
@WebServlet(name = "AddLevel", urlPatterns = {"/html/AddLevel"})
public class AddLevel extends HttpServlet {
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
        Level1 level1 = new Level1();
        level1.setLevelOneID(1);
        level1.setListingName("Level 1 Listing Name");
        level1.setListingDescription("Level 1 Listing Description");
        level1.setBookName("Level 1 Book Name");
        level1.setPageNumber(1);
        level1.setVersionID(1);

//        response.setContentType("application/json");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String json = new Gson().toJson(level1);
        out.println(json);
        out.close();

        log.info("{success : 'Yes'}");
        log.info(request.getReader());
        log.info(json.toString());
    }
}
