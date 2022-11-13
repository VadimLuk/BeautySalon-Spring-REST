package com.epam.beautysalonspring.mapper;

import com.epam.beautysalonspring.dto.SubcategoryDto;
import com.epam.beautysalonspring.model.Subcategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface SubcategoryMapper {
    Subcategory mapToSubcategory(SubcategoryDto subcategoryDto);

    SubcategoryDto mapToSubcategoryDto(Subcategory subcategory);

    List<SubcategoryDto> mapToSubcategoryDtoList(List<Subcategory> byCategory);
}
