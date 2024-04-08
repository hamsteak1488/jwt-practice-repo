package com.example.jwttokenpractice.member.dto;

import com.example.jwttokenpractice.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModifyRequestDto {
    private Long memberId;
    private String username;
    private String password;
    private String realname;
    private String email;
    private String phone;
    private String address;
    private String status;
    private String role;

    public Member toEntity() {
        return Member.builder()
                .memberId(memberId)
                .username(username)
                .password(password)
                .realname(realname)
                .email(email)
                .phone(phone)
                .address(address)
                .status(status)
                .role(role)
                .build();
    }
}
