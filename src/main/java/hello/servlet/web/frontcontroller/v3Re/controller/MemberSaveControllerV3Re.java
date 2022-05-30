package hello.servlet.web.frontcontroller.v3Re.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.repository.MemberRepository;
import hello.servlet.web.frontcontroller.v3Re.ControllerV3Re;
import hello.servlet.web.frontcontroller.v3Re.ModelViewRe;

import java.util.Map;

public class MemberSaveControllerV3Re implements ControllerV3Re {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelViewRe process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        String job = paramMap.get("job");

        Member member = new Member(username, age, job);
        memberRepository.save(member);

        ModelViewRe mv = new ModelViewRe("save-result");
        mv.getModel().put("member", member);

        return mv;
    }
}
