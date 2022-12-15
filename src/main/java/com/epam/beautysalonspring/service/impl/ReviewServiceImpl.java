package com.epam.beautysalonspring.service.impl;

import com.epam.beautysalonspring.dto.ReviewDto;
import com.epam.beautysalonspring.mapper.ReviewMapper;
import com.epam.beautysalonspring.model.Review;
import com.epam.beautysalonspring.repository.ReviewRepository;
import com.epam.beautysalonspring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public List<ReviewDto> getAll() {
        log.info("Layer: {}, Getting Reviews", this.getClass().getSimpleName());

        return reviewMapper.mapToReviewDtoList(
                (List<Review>) reviewRepository.findAll());
    }

    @Override
    public ReviewDto create(ReviewDto reviewDto) {
        log.info("Layer: {}, Creating Review: {}", this.getClass().getSimpleName(), reviewDto);

        Review review = reviewRepository.save(reviewMapper.mapToReview(reviewDto));
        return reviewMapper.mapToReviewDto(review);
    }
}
