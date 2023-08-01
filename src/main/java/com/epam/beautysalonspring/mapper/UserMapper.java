package com.epam.beautysalonspring.mapper;

import com.epam.beautysalonspring.converters.StringCaseConverter;
import com.epam.beautysalonspring.dto.UserDto;
import com.epam.beautysalonspring.dto.UserStaffDto;
import com.epam.beautysalonspring.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = StringCaseConverter.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    @Mapping(target = "role", source = "role", qualifiedByName = "toEnumCase")
    @Mapping(target = "userStatus", source = "userStatus", qualifiedByName = "toEnumCase")
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    UserStaffDto userToUserStaffDto(User user);

    List<UserStaffDto> usersToUserStaffDto(List<User> users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @InheritConfiguration
    void updateUserFromUserDto(UserDto userDto, @MappingTarget User user);
}
