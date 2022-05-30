package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;    // 식별자 id 값
    private String username;
    private int age;
    private String job;

    //기본 생성자
    public Member() {
    }

    public Member(String username, int age, String job) {
        this.username = username;
        this.age = age;
        this.job = job;
    }
}
