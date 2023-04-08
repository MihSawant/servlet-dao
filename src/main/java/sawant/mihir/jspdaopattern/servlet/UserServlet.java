package sawant.mihir.jspdaopattern.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sawant.mihir.jspdaopattern.dao.UserDao;
import sawant.mihir.jspdaopattern.entities.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet(name = "userServlet", value = "/")
public class UserServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        this.userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathRequest = req.getServletPath();
        switch (pathRequest){
            case "/new", "/insert" ->{
                RequestDispatcher insertDispatch = req.getRequestDispatcher("/new_user.jsp");
                insertDispatch.forward(req, resp);
            }
            case "/update", "/edit" ->{
                RequestDispatcher updateDispatch = req.getRequestDispatcher("/update.jsp");
                updateDispatch.forward(req, resp);
            }
            case "/delete" ->{
                RequestDispatcher deleteDispatch = req.getRequestDispatcher("/delete.jsp");
                deleteDispatch.forward(req, resp);
            }
            default-> {
                List<User> allData = null;
                RequestDispatcher all = req.getRequestDispatcher("/display_all.jsp");
                try{
                    allData = userDao.getUsers();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                req.setAttribute("users", allData);
                all.forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathRequest = req.getServletPath();
        switch (pathRequest){
            case "/new", "/insert" ->{
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                try{
                    User user = new User(req.getParameter("name"), req.getParameter("designation"));


                    int i = userDao.addUser(user);
                    if(i == 1){
                        out.println("<h1>Record inserted into db successfull</h1>");
                    } else{
                        out.println("<p>Something went wrong !</p>");
                    }
                    out.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            case "/update", "/edit" ->{
                resp.setContentType("text/html");

                PrintWriter out = resp.getWriter();
                try{
                    User user = new User(req.getParameter("name"), req.getParameter("designation"));


                    int i = userDao.updateUser(user.getName(), user);
                    if(i == 1){
                        out.println("<h1>Record updated successfull</h1>");
                    } else{
                        out.println("<p>Something went wrong !</p>");
                    }
                    out.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
            case "/delete" ->{
                resp.setContentType("text/html");

                PrintWriter out = resp.getWriter();
                try{
                  User user = new User(req.getParameter("name"), null);


                    int i = userDao.deleteUser(user.getName());
                    if(i == 1){
                        out.println("<h1>Record deleted successfull</h1>");
                    } else{
                        out.println("<p>Something went wrong !</p>");
                    }
                    out.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            default -> {

            }
        }

    }
}
