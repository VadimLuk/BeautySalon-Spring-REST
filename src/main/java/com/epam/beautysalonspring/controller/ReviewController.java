package com.epam.beautysalonspring.controller;

import com.epam.beautysalonspring.dto.ReviewDto;
import com.epam.beautysalonspring.dto.groups.OnCreate;
import com.epam.beautysalonspring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> getReviews() {
        log.info("Layer: {}, Getting Reviews", this.getClass().getSimpleName());
        return reviewService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewDto createReview(@RequestBody @Validated(OnCreate.class) ReviewDto reviewDto) {
        log.info("Layer: {}, Creating Review: {}", this.getClass().getSimpleName(), reviewDto);
        return reviewService.create(reviewDto);
    }
}
