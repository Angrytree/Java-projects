package ua.com.palamarchuk;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = SecretUtil.LOGIN_PAGE)
public class LoginServlet extends HttpServlet {

    private StringBuilder form = new StringBuilder();

    {
        form.append("<form method=\"post\">")
                .append("Input your data")
                .append("<br>")
                .append("<label>Login <input type=\"text\" name=\"login\"></label>")
                .append("<label>Password <input type=\"password\" name=\"password\"></label>")
                .append("<br><input type = \"submit\">")
                .append("</form>");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean logged = (Boolean) req.getSession().getAttribute(SecretUtil.LOGGED);
        if (logged != null && logged) {
            resp.sendRedirect(SecretUtil.SECRET_PAGE);
        } else {
            resp.setContentType("text/html");
            resp.getWriter().print(form);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(SecretUtil.LOGIN_PARAMETER);
        String password = req.getParameter(SecretUtil.PASSWORD_PARAMETER);
        if ((login != null) && (password != null) && (login.equals(SecretUtil.LOGIN)) && (password.equals(SecretUtil.PASSWORD))) {
            req.getSession().setAttribute(SecretUtil.LOGGED, new Boolean(true));
            resp.sendRedirect(SecretUtil.SECRET_PAGE);
        } else {
            resp.setContentType("text/html");
            resp.getWriter().println(form);
        }
    }
}
