package hello.servlet.web.frontcontroller.v3Re.controller;

import hello.servlet.web.frontcontroller.v3Re.ControllerV3Re;
import hello.servlet.web.frontcontroller.v3Re.ModelViewRe;

import java.util.Map;

public class MemberFormControllerV3Re implements ControllerV3Re {

    @Override
    public ModelViewRe process(Map<String, String> paramMap) {
        return new ModelViewRe("new-form");
    }
}
