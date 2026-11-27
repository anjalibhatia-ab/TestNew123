package com.example.securitylab;

/**
 * Minimal audit logger for a security-review exercise.
 */
public final class AuditService {
    /**
     * INTENTIONAL VULNERABILITY: logs a password, exposing sensitive data
     * to anyone with access to application logs.
     */
    public void recordLogin(String username, String password) {
        System.out.println("Login attempt: username=" + username + ", password=" + password);
    }
}
