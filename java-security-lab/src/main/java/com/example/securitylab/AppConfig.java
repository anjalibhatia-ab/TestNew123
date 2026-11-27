package com.example.securitylab;

/**
 * Configuration examples for static-analysis practice.
 */
public final class AppConfig {
    // INTENTIONAL VULNERABILITY: hardcoded fake credential for scanner practice.
    // Never put real credentials in source code.
    public static final String DEMO_DATABASE_PASSWORD = "training-only-password";

    private AppConfig() {
    }
}
