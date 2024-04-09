package com.example.jwttokenpractice.member;
import com.example.jwttokenpractice.common.mail.MailService;
import com.example.jwttokenpractice.member.dto.ConfirmEmailDto;
import com.example.jwttokenpractice.member.dto.ModifyRequestDto;
import com.example.jwttokenpractice.member.dto.RegisterRequestDto;
import com.example.jwttokenpractice.member.dto.WithdrawRequestDto;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/find-all")
    public ResponseEntity<List<Member>> getMemberList() {
        return new ResponseEntity<>(
                memberService.getMemberList(),
                HttpStatus.OK
        );
    }

    @PostMapping("/registration")
    public ResponseEntity<Boolean> register(RegisterRequestDto registerRequestDto) {
        return new ResponseEntity<>(
                memberService.register(registerRequestDto),
                HttpStatus.OK
        );
    }

    @PostMapping("/modification")
    public ResponseEntity<Boolean> modify(ModifyRequestDto modifyRequestDto) {
        return new ResponseEntity<>(
                memberService.modify(modifyRequestDto),
                HttpStatus.OK
        );
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<Boolean> withdraw(WithdrawRequestDto withdrawRequestDtoto) {
        return new ResponseEntity<>(
                memberService.withdraw(withdrawRequestDtoto),
                HttpStatus.OK
        );
    }

    @GetMapping("/email-confirm")
    public ResponseEntity<Boolean> confirmEmail(ConfirmEmailDto confirmEmailDto) {
        return new ResponseEntity<>(
                memberService.confirmEmail(confirmEmailDto),
                HttpStatus.OK
        );
    }
}