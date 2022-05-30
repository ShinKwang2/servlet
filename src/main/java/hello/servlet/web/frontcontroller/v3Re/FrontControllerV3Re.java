package hello.servlet.web.frontcontroller.v3Re;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3Re.controller.MemberFormControllerV3Re;
import hello.servlet.web.frontcontroller.v3Re.controller.MemberListControllerV3Re;
import hello.servlet.web.frontcontroller.v3Re.controller.MemberSaveControllerV3Re;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV3Re", urlPatterns = "/front-controller/v3re/*")
public class FrontControllerV3Re extends HttpServlet {

    Map<String, ControllerV3Re> controllerV3ReMap = new HashMap<>();

    public FrontControllerV3Re() {
        controllerV3ReMap.put("/front-controller/v3re/members/new-form", new MemberFormControllerV3Re());
        controllerV3ReMap.put("/front-controller/v3re/members/save", new MemberSaveControllerV3Re());
        controllerV3ReMap.put("/front-controller/v3re/members", new MemberListControllerV3Re());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV3Re controller = controllerV3ReMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        // paramMap
        Map<String, String> paramMap = createParamMap(request);
        ModelViewRe mv = controller.process(paramMap);

        // 논리 이름을 물리 이름으로 바꾸기(viewResolver)

        String viewName = mv.getViewName();// 논리이름 new-form
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(), request, response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paraName -> paramMap.put(paraName, request.getParameter(paraName)));
        return paramMap;
    }
}
