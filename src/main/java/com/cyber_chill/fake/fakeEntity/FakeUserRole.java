package com.cyber_chill.fake.fakeEntity;


public enum FakeUserRole {
    ADMIN("Admin"),
    CLIENT("Client");

    private final String displayName;

    FakeUserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}