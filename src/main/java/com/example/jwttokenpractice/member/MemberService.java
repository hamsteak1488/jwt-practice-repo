package com.example.jwttokenpractice.member;

import com.example.jwttokenpractice.auth.dto.SigninRequestDto;
import com.example.jwttokenpractice.jwt.Jwt;

import java.util.List;

public interface MemberService {
    List<Member> getMemberList();
    Member findMember(String username);


}
