package com.epam.beautysalonspring.model.enums;

import java.util.Arrays;

public enum UserStatus {
    ACTIVE(1),
    INACTIVE(2);

    private final Integer id;

    UserStatus(final Integer id) {
        this.id = id;
    }

    public static UserStatus getUserStatus(Integer id) {
        return Arrays.stream(values())
                .filter(status -> status.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer getId() {
        return id;
    }


}
