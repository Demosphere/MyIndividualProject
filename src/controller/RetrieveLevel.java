package controller;

import com.google.gson.Gson;
import entity.Level1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.log4j.Logger;
import persistence.Level1DAO;

/**
 * Created by Michael on 4/29/2016.
 */
@WebServlet(name = "RetrieveLevel", urlPatterns = {"/html/index"})
public class RetrieveLevel extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Level1 level1 = new Level1();
//        level1.setLevelOneID(1);
//        level1.setListingName("Level 1 Listing Name");
//        level1.setListingDescription("Level 1 Listing Description");
//        level1.setBookName("Level 1 Book Name");
//        level1.setPageNumber(1);
//        level1.setVersionID(1);

//        response.setContentType("application/json");

        Level1DAO levelOneDAO = new Level1DAO();
        List levels = levelOneDAO.getAllLevelOne();

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String json = new Gson().toJson(levels);
        out.println(json);
        out.close();
        log.info("{'success' : 'Yes'}");
        log.info(request.getReader());
        log.info(json.toString());
    }
}
