package com.example.demo.service;

import com.example.demo.Member;
import com.example.demo.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;
    @Test
    public void 회원가입() throws Exception {




        //given
        Member member = new Member();
        member.setName("LEE");

        //when
        Long memberId = memberService.join(member);


        //then

        assertEquals(member,memberRepository.find(memberId));


    }

}