package hello.servlet.web.frontcontroller.v3Re.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.repository.MemberRepository;
import hello.servlet.web.frontcontroller.v3Re.ControllerV3Re;
import hello.servlet.web.frontcontroller.v3Re.ModelViewRe;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3Re implements ControllerV3Re {

    private MemberRepository memberRepository = MemberRepository.getInstance();

     @Override
    public ModelViewRe process(Map<String, String> paramMap) {
         List<Member> members = memberRepository.findAll();

         ModelViewRe mv = new ModelViewRe("members");
         mv.getModel().put("members", members);

         return mv;
     }
}
