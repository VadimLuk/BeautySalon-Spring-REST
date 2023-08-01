package com.epam.beautysalonspring.mapper;

import com.epam.beautysalonspring.dto.CategoryDto;
import com.epam.beautysalonspring.model.Category;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface CategoryMapper {
    CategoryDto mapToCategoryDto(Category category);

    Category mapToCategory(CategoryDto categoryDto);

    List<CategoryDto> mapToCategoryDtoList(List<Category> all);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoryFromCategoryDto(CategoryDto categoryDto, @MappingTarget Category category);
}
