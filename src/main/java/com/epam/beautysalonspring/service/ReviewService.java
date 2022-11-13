package com.epam.beautysalonspring.service;

import com.epam.beautysalonspring.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> getAll();

    ReviewDto create(ReviewDto reviewDto);
}
