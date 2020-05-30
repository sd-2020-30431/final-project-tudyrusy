package com.rustudor.Util;

import java.time.Duration;
import java.time.Instant;


public class Session {
    public static final Duration EXPIRATION_TIME = Duration.ofHours(2);
    private String username;
    private Instant creationTime;
    private Duration expirationPeriod;
    private String role;

    public Session() {
    }

    public Session(String username, Instant creationTime, Duration expirationPeriod, String role) {
        this.username = username;
        this.creationTime = creationTime;
        this.expirationPeriod = expirationPeriod;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public Duration getExpirationPeriod() {
        return expirationPeriod;
    }

    public void setExpirationPeriod(Duration expirationPeriod) {
        this.expirationPeriod = expirationPeriod;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Session{" +
                "username='" + username + '\'' +
                ", creationTime=" + creationTime +
                ", expirationPeriod=" + expirationPeriod +
                ", role=" + role +
                '}';
    }
}
