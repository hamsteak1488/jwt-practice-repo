package com.example.jwttokenpractice.member;

import com.example.jwttokenpractice.common.exception.ErrorCode;
import com.example.jwttokenpractice.common.exception.MemberExceptionHandler;
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
        return memberRepository.findMemberByUsername(username)
                .orElseThrow(() -> new MemberExceptionHandler(ErrorCode.USERNAME_NOT_FOUND_ERROR));
    }

    @Override
    public boolean register(RegisterRequestDto dto) {
        if (memberRepository.findMemberByUsername(dto.getUsername()).isPresent()) {
            return false;
        }

        memberRepository.save(dto.toEntity());
        return true;
    }

    @Override
    public boolean modify(ModifyRequestDto dto) {
        Member member = memberRepository.findMemberByUsername(dto.getUsername())
                .orElseThrow(() -> new MemberExceptionHandler(ErrorCode.USERNAME_NOT_FOUND_ERROR));

        dto.setMemberId(member.getMemberId());
        memberRepository.save(dto.toEntity());
        return true;
    }

    @Override
    public boolean withdraw(WithdrawRequestDto dto) {
        Member member = memberRepository.findMemberByUsername(dto.getUsername())
                .orElseThrow(() -> new MemberExceptionHandler(ErrorCode.USERNAME_NOT_FOUND_ERROR));

        memberRepository.delete(member);
        return true;
    }
}
