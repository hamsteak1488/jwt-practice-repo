package com.example.jwttokenpractice;

import com.example.jwttokenpractice.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions.*;

@SpringBootTest
public class RepositoryTest {
    private final MemberRepository memberRepository;

    @Autowired
    RepositoryTest(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Test
    @DisplayName("woals1488 테스트")
    public void testAccount1() {
        Assertions.assertThat(memberRepository.findMemberByUsername("woals1488").isPresent()).isTrue();
    }
}
