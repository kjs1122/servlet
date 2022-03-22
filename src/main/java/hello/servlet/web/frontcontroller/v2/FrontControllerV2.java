package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v1.contorller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.contorller.MemberSaveControllerV1;
import hello.servlet.web.frontcontroller.v2.contorller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.contorller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.contorller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FrontControllerV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String requestURI = req.getRequestURI();

        ControllerV2 controller = controllerMap.get(requestURI);
        if (controller == null) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        MyView view = controller.process(req, res);
        view.rend(req, res);
    }
}
