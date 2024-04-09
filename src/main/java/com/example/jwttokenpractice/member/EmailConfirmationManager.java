package com.example.jwttokenpractice.member;

import java.util.UUID;

public interface EmailConfirmationManager {
    void putConfirmation(UUID uuid, String username);
    String getConfirmation(UUID uuid);

    void removeConfirmation(UUID uuid);
}
