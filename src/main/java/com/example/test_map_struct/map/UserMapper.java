package com.example.test_map_struct.map;

import com.example.test_map_struct.model.UserApp;
import com.example.test_map_struct.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
//    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(source = "email", target = "emailAddress")
    @Mapping(source = "name", target = "fullName")
    UserDTO toUserDTO(UserApp userApp);
}
