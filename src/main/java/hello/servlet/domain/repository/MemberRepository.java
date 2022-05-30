package hello.servlet.domain.repository;

import hello.servlet.domain.member.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Long HashMap은 동시성 문제가 고려되어 있지 않음
    실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
*/

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    // 싱글톤이기에 생성자 private 으로 제한
    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        // new ArrayList에 담은 이유는 ArrayList에 값을 담거나 조작해도
        // store 의 values 에 영향을 주고 싶지 않아서
    }

    public void clearStore() {
        store.clear();
    }
}
