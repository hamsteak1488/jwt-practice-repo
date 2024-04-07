package com.example.jwttokenpractice.member;

import com.example.jwttokenpractice.auth.dto.SigninRequestDto;
import com.example.jwttokenpractice.jwt.Jwt;
import com.example.jwttokenpractice.member.dto.ModifyRequestDto;
import com.example.jwttokenpractice.member.dto.RegisterRequestDto;
import com.example.jwttokenpractice.member.dto.WithdrawRequestDto;

import java.util.List;

public interface MemberService {
    List<Member> getMemberList();
    Member findMember(String username);

    boolean register(RegisterRequestDto dto);
    boolean modify(ModifyRequestDto dto);
    boolean withdraw(WithdrawRequestDto dto);
}
