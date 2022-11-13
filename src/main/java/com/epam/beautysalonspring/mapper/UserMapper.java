package com.epam.beautysalonspring.mapper;

import com.epam.beautysalonspring.dto.UserDto;
import com.epam.beautysalonspring.dto.UserStaffDto;
import com.epam.beautysalonspring.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = EnumMapper.class)
public interface UserMapper {

    @Mappings({
            @Mapping(target = "role", source = "role", qualifiedByName = "toEnumCase"),
            @Mapping(target = "userStatus", source = "userStatus", qualifiedByName = "toEnumCase")
    })
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    UserStaffDto userToUserStaffDto(User user);

    List<UserStaffDto> usersToUserStaffDto(List<User> users);

}
