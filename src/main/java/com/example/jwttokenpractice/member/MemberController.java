package com.example.jwttokenpractice.member;
import com.example.jwttokenpractice.member.dto.ConfirmEmailDto;
import com.example.jwttokenpractice.member.dto.ModifyRequestDto;
import com.example.jwttokenpractice.member.dto.RegisterRequestDto;
import com.example.jwttokenpractice.member.dto.WithdrawRequestDto;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public ResponseEntity<Boolean> withdraw(WithdrawRequestDto withdrawRequestDto) {
        String username = (String) RequestContextHolder.getRequestAttributes().getAttribute("username", RequestAttributes.SCOPE_REQUEST);
        withdrawRequestDto.setUsername(username);
        if (username == null) {
            throw new RuntimeException();
        }
        return new ResponseEntity<>(
                memberService.withdraw(withdrawRequestDto),
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