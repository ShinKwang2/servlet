package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ControllerV2HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV2);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV2 controller = (ControllerV2) handler;

        MyView view = controller.process(request, response);
        String viewPath = view.getViewPath();

        // 모델뷰 만들기
        String viewName = parsingViewName(viewPath);
        ModelView mv = new ModelView(viewName);

        // 모델뷰에 모델 넣기
        Map<String, Object> model = new HashMap<>();
        request.getAttributeNames().asIterator()
                .forEachRemaining(attributeName -> model.put(attributeName, request.getAttribute(attributeName)));

        mv.setModel(model);

        return mv;
    }

    private String parsingViewName(String viewPath) {
        String[] splitList = viewPath.split("/");
        int lastIndex = splitList.length - 1;
        String viewNameWithJSP = splitList[lastIndex];
        String[] splitJSP = viewNameWithJSP.split("[.]");
        String viewName = splitJSP[0];
        return viewName;
    }
}
