package com.example.jwttokenpractice.member;

import com.example.jwttokenpractice.auth.dto.SigninRequestDto;
import com.example.jwttokenpractice.jwt.Jwt;
import com.example.jwttokenpractice.member.dto.ModifyRequestDto;
import com.example.jwttokenpractice.member.dto.RegisterRequestDto;
import com.example.jwttokenpractice.member.dto.WithdrawRequestDto;
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

    @Override
    public boolean register(RegisterRequestDto dto) {
        if (memberRepository.findMemberByUsername(dto.getUsername()) != null) {
            return false;
        }

        memberRepository.save(dto.toEntity());
        return true;
    }

    @Override
    public boolean modify(ModifyRequestDto dto) {
        Member member = memberRepository.findMemberByUsername(dto.getUsername());
        if (member == null) {
            return false;
        }

        if (dto.getPassword() != null) {
            // modify password of member entity
        }
        if (dto.getRealname() != null) {
            // modify realname of member entity
        }
        //...
        // 개선할 방법 찾기

        memberRepository.save(member);
        return true;
    }

    @Override
    public boolean withdraw(WithdrawRequestDto dto) {
        Member member = memberRepository.findMemberByUsername(dto.getUsername());
        if (member == null) {
            return false;
        }

        memberRepository.delete(member);
        return true;
    }
}
