package com.example.demo.service;

import com.example.demo.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {



    private final MemberRepository memberRepository;
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Transactional
    public Long Join(Member member){
        memberRepository.save(member);
        vaildateDuplicateMember(member);
        return member.getId();
    }

    private void vaildateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalArgumentException("중복되는 회원이 존재합니다.");
        }
    }

    public List<Member> findAll(Member member){
        List<Member> members = memberRepository.findAll();
        return members;

    }

}
