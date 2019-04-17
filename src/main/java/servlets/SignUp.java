package servlets;

import Hibernate.model.UsersDataSet;
import service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUp extends HttpServlet {
    private AccountService accountService;

    public SignUp(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        UsersDataSet user = accountService.getUserByLogin(login);
        if(user == null){
            accountService.addNewUser(new UsersDataSet(login, password, email));
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(login + " is sign up");
        }
        else{
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().println(login + " is already sign up");
        }
    }
}
