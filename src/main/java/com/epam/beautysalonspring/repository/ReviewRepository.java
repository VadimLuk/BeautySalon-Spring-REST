package com.epam.beautysalonspring.repository;

import com.epam.beautysalonspring.model.Review;

import java.util.List;

public interface ReviewRepository {
    List<Review> findAll();

    Review create(Review review);
}
