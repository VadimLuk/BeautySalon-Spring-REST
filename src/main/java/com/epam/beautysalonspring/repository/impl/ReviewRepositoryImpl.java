package com.epam.beautysalonspring.repository.impl;

import com.epam.beautysalonspring.model.Review;
import com.epam.beautysalonspring.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    private static HashMap<Long, Review> reviews = new HashMap<>();

    private Long entityId = 0L;

    @Override
    public List<Review> findAll() {
        log.info("Layer: {}, Getting Reviews", this.getClass().getSimpleName());
        return new ArrayList<>(reviews.values());
    }

    @Override
    public Review create(Review review) {
        log.info("Layer: {}, Creating Review: {}", this.getClass().getSimpleName(), review);
        review.setId(entityId++);
        reviews.put(review.getId(), review);
        return reviews.get(review.getId());
    }
}
