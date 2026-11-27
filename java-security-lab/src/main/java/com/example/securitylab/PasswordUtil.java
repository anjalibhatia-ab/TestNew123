package com.example.securitylab;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

/**
 * Password utility included as an intentionally unsafe training example.
 */
public final class PasswordUtil {
    private PasswordUtil() {
    }

    /**
     * INTENTIONAL VULNERABILITY: MD5 is fast and unsuitable for password
     * storage. Use a password-hashing algorithm such as Argon2id, bcrypt,
     * or scrypt with a unique salt and appropriate work factor.
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException exception) {
            throw new IllegalStateException("Required digest algorithm is unavailable", exception);
        }
    }
}
