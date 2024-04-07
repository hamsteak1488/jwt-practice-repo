package com.example.jwttokenpractice.member.dto;

import com.example.jwttokenpractice.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WithdrawRequestDto {
    private String username;
}
