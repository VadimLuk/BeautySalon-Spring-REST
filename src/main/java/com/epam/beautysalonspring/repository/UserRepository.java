package com.epam.beautysalonspring.repository;

import com.epam.beautysalonspring.model.User;
import com.epam.beautysalonspring.model.enums.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("select u from User u where u.email = ?1")
    User findUserByEmail(String email);

    User findUserById(Long id);

    List<User> findByRole(Role role);

}
