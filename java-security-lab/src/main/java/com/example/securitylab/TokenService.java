package com.example.securitylab;

import java.util.Random;

/**
 * Generates sample identifiers for security-review exercises.
 */
public final class TokenService {
    // INTENTIONAL VULNERABILITY: java.util.Random is predictable and not
    // suitable for security-sensitive tokens. Use java.security.SecureRandom.
    private final Random random = new Random();

    public String createToken() {
        long value = random.nextLong();
        return Long.toUnsignedString(value, 36);
    }
}
