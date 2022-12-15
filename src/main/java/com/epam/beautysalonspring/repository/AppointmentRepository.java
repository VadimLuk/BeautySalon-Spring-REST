package com.epam.beautysalonspring.repository;

import com.epam.beautysalonspring.model.Appointment;
import com.epam.beautysalonspring.model.User;
import com.epam.beautysalonspring.model.enums.AppointmentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentRepository extends PagingAndSortingRepository<Appointment, Long> {

    @Query("select a from Appointment a " +
            "where a.master = ?1 or a.client = ?1 and a.status = ?2 and a.bookedDateTime between ?3 and ?4")
    Page<Appointment> findByMasterOrClientAndStatusAndBookedDateTimeBetween(User user,
                                                                            AppointmentStatus status,
                                                                            LocalDateTime bookedDateTimeStart,
                                                                            LocalDateTime bookedDateTimeEnd,
                                                                            Pageable pageable);

    @Query("select a from Appointment a where a.status = ?1 and a.bookedDateTime between ?2 and ?3")
    Page<Appointment> findByStatusAndBookedDateTimeBetween(AppointmentStatus status,
                                                           LocalDateTime bookedDateTimeStart,
                                                           LocalDateTime bookedDateTimeEnd,
                                                           Pageable pageable);

}
