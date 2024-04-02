package com.example.jwttokenpractice.auth;

import org.springframework.stereotype.Component;

import java.io.*;
import java.security.*;

public class RSAKeyManager {
    public static final String PUBLIC_KEY_FILE = "etc/publicKey.pem";
    public static final String PRIVATE_KEY_FILE = "etc/privateKey.pem";

    public static KeyPair generateKeyPair() {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void savePublicKey(PublicKey publicKey, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(publicKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void savePrivateKey(PrivateKey privateKey, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(privateKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static PublicKey loadPublicKey(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (PublicKey) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static PrivateKey loadPrivateKey(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (PrivateKey) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
