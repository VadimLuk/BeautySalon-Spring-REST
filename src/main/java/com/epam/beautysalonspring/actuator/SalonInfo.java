package com.epam.beautysalonspring.actuator;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SalonInfo implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, String> salonDetails = new HashMap<>();
        salonDetails.put("name", "EpamBeautySalon");
        salonDetails.put("currentDateTime", LocalDateTime.now().toString());
        salonDetails.put("createdBy", "Vadym Lukianikhin");
        builder.withDetail("ProjectInfo",salonDetails);
    }
}
