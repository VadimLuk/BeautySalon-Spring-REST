package com.epam.beautysalonspring.repository;

import com.epam.beautysalonspring.model.SalonService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface SalonServiceRepository extends CrudRepository<SalonService, Long> {
    SalonService findSalonServiceById(Long id);

    @Query("select s from SalonService s where :subcategoryId is null OR s.subcategory.id = :subcategoryId")
    Set<SalonService> findAllSalonServicesOrBySubcategory(Long subcategoryId);
}
