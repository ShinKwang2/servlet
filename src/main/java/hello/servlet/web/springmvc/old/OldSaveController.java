package hello.servlet.web.springmvc.old;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component("/springmvc/old-controller/members/save")
public class OldSaveController implements Controller {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        String job = request.getParameter("job");

        Member member = new Member(username, age, job);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);

        return mv;
    }
}
