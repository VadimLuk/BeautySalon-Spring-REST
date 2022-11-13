package com.epam.beautysalonspring.mapper;

import com.epam.beautysalonspring.dto.ReviewDto;
import com.epam.beautysalonspring.model.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface ReviewMapper {
    Review mapToReview(ReviewDto reviewDto);

    ReviewDto mapToReviewDto(Review review);

    List<ReviewDto> mapToReviewDtoList(List<Review> reviews);
}
