package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("parameter start" );

        req.getParameterNames().asIterator().forEachRemaining(parameter -> System.out.println(parameter + " = " + req.getParameter(parameter)) );

        res.getWriter().write("ok");

        System.out.println("parameter end" );
    }

}
