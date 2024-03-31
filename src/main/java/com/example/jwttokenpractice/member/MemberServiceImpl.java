package com.example.jwttokenpractice.member;

import com.example.jwttokenpractice.auth.dto.SigninRequestDto;
import com.example.jwttokenpractice.jwt.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public List<Member> getMemberList() {
        return memberRepository.findAll();
    }

    @Override
    public Member findMember(String username) {
        return memberRepository.findMemberByUsername(username);
    }

}
