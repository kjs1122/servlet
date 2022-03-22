package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void after(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        assertThat(savedMember);

    }
    @Test
    void findAll(){
        //given
        Member member1 = new Member("hello", 20);
        Member member2 = new Member("hello", 30);

        //when
        Member savedMember1 = memberRepository.save(member1);
        Member savedMember2 = memberRepository.save(member2);

        //then
        List<Member> memberList = memberRepository.findAll();
        assertThat(memberList.size());
        System.out.println("memberList.size() = " +  assertThat(memberList.size()));

    }
}