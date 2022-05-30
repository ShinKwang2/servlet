package hello.servlet.web.springmvc.old;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("/springmvc/old-controller/members")
public class OldListController implements Controller {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Member> members = memberRepository.findAll();

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);

        return mv;
    }
}
