package com.epam.beautysalonspring.mapper;

import com.epam.beautysalonspring.dto.SubcategoryDto;
import com.epam.beautysalonspring.model.Subcategory;
import com.epam.beautysalonspring.repository.CategoryRepository;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = CategoryRepository.class
)
public interface SubcategoryMapper {
    @Mapping(target = "category", source = "categoryId")
    Subcategory mapToSubcategory(SubcategoryDto subcategoryDto);

    @Mapping(target = "categoryId", source = "category.id")
    SubcategoryDto mapToSubcategoryDto(Subcategory subcategory);

    List<SubcategoryDto> mapToSubcategoryDtoList(List<Subcategory> byCategory);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSubcategoryFromSubcategoryDto(SubcategoryDto subcategoryDto, @MappingTarget Subcategory subcategory);
}
