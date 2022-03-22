package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.contorller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.contorller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.contorller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("FrontControllerV1");

        String requestURI = req.getRequestURI();

        ControllerV1 controller = controllerMap.get(requestURI);
        if (controller == null) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(req, res);
    }
}
