package com.epam.beautysalonspring.model.enums;

import java.util.Arrays;

public enum Role {
    ADMIN(1), MASTER(2), CLIENT(3);
    private final Integer id;

    Role(final Integer id) {
        this.id = id;
    }

    public static Role getRole(Integer id) {
        return Arrays.stream(values())
                .filter(role -> role.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer getId() {
        return id;
    }
}
