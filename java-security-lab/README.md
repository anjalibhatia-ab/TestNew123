# Java Security Lab (intentionally vulnerable)

A small Java 17 / Maven project for practising code review and static application
security testing (SAST). The code is syntactically valid and deliberately
contains several security weaknesses.

## Safety

- This is a local training sample, not production software.
- Do not connect it to a real database, filesystem containing important data,
  network service, or real credentials.
- The hardcoded values are fake placeholders.
- The demo methods are not called by `main`; review them with a scanner or IDE.

## Build and run

Requires JDK 17+ and Maven.

```bash
mvn clean package
java -cp target/classes com.example.securitylab.App
```

## Deliberate findings

| File / method | Training issue | Typical remediation |
|---|---|---|
| `UserRepository.findByUsername` | SQL injection via string concatenation | Use `PreparedStatement` parameters |
| `FileService.readFile` | Path traversal: untrusted path is joined to a base directory without canonical-path validation | Normalize and verify the resolved path remains under the allowed directory |
| `AppConfig` | Hardcoded demo credential | Load secrets from a secret manager or protected environment |
| `PasswordUtil.hashPassword` | MD5 is unsuitable for password storage | Use Argon2id, bcrypt, or scrypt with unique salts |
| `TokenService.createToken` | Predictable `Random` for security token generation | Use `SecureRandom` |
| `AuditService.recordLogin` | Logs a password (sensitive data exposure) | Never log passwords or authentication secrets |

## Suggested exercise

1. Import as an existing Maven project in IntelliJ IDEA or Eclipse.
2. Run a SAST tool (for example, SonarQube or SpotBugs with security rules).
3. Record each finding, severity, affected line, impact, and recommended fix.
4. Fix one issue at a time and rerun the scan to confirm the finding is gone.

This project intentionally prioritizes clear, reviewable examples over framework
complexity. The vulnerable methods are demonstrations only.
