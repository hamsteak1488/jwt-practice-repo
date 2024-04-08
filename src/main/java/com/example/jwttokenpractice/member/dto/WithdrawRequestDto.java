package com.example.jwttokenpractice.member.dto;

import com.example.jwttokenpractice.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WithdrawRequestDto {
    private String username;
}