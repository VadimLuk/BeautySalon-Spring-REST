package com.epam.beautysalonspring.mapper;

import com.epam.beautysalonspring.dto.ReviewDto;
import com.epam.beautysalonspring.model.Review;
import com.epam.beautysalonspring.repository.UserRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = UserRepository.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ReviewMapper {
    @Mapping(target = "client", source = "clientId")
    Review mapToReview(ReviewDto reviewDto);

    ReviewDto mapToReviewDto(Review review);

    List<ReviewDto> mapToReviewDtoList(List<Review> reviews);
}
