package com.epam.beautysalonspring.model;

import com.epam.beautysalonspring.model.enums.AppointmentStatus;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Appointment that = (Appointment) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
