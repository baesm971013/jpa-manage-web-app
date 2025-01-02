package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;
    @Test
    @DisplayName("저장 테스트")
    @Transactional
    //@Rollback(false)
    public void test1() throws Exception{
        Member member = new Member();
        member.setUserName("jack");
        Long savedMemberId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedMemberId);
        System.out.println(findMember.getUserName());
        Assertions.assertThat(member.getUserName()).isEqualTo(findMember.getUserName());
        Assertions.assertThat(findMember).isEqualTo(member);


    }
}