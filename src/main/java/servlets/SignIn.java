package servlets;

import Hibernate.model.UsersDataSet;
import service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SignIn extends HttpServlet {

    private AccountService accountService;

    public SignIn(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UsersDataSet user = accountService.getUserByLogin(login);

        if(user != null && user.getPassword().equals(password)){
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Authorized: " + login);
        }
        else{
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("Unauthorized");
        }
    }
}
