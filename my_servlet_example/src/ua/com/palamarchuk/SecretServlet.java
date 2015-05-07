package ua.com.palamarchuk;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = SecretUtil.SECRET_PAGE)
public class SecretServlet extends HttpServlet {

    private StringBuilder form = new StringBuilder();

    {
        form.append("<form method=\"post\">")
                .append("<input type = \"submit\" value=\"logout\">")
                .append("</form>");

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean logged = (Boolean) req.getSession().getAttribute(SecretUtil.LOGGED);
        if (logged != null && logged) {
            resp.setContentType("text/html");
            resp.getWriter().println("<h1>Hello ," + SecretUtil.LOGIN + "</h1>");
            resp.getWriter().println(form);
        } else {
            resp.sendRedirect(SecretUtil.LOGIN_PAGE);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession se = req.getSession();
        se.removeAttribute(SecretUtil.LOGGED);
        resp.sendRedirect(SecretUtil.LOGIN_PAGE);
    }
}
