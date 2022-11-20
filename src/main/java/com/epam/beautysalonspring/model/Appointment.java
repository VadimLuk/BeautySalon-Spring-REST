package com.epam.beautysalonspring.model;

import com.epam.beautysalonspring.model.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "salon_service_id")
    private SalonService salonService;


    @ManyToOne
    @JoinColumn(name = "master_id")
    private User master;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;


    @Column(name = "cost")
    private Integer cost;

    @Column(name = "booked_date_time")
    private LocalDateTime bookedDateTime;


    @Column(name = "status_id")
    private AppointmentStatus status;


}
