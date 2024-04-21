package com.mirae.commerce.auth.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class UserContextHolder {
    private static final ThreadLocal<String> currentUsername = ThreadLocal.withInitial(() -> "");

    public static String getCurrentUsername() {
        return UserContextHolder.currentUsername.get();
    }
    public static void setCurrentUsername(String currentUsername) {
        UserContextHolder.currentUsername.set(currentUsername);
    }
}
