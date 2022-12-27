package com.epam.beautysalonspring.model.enums;

import java.util.Arrays;

public enum AppointmentStatus {
    NEW(1), APPROVED(2), DONE(3), PAID(4), CANCELED(5);
    private final Integer id;


    AppointmentStatus(final Integer id) {
        this.id = id;
    }

    public static AppointmentStatus getAppointmentStatus(Integer id) {
        return Arrays.stream(values())
                .filter(status -> status.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer getId() {
        return id;
    }
}
