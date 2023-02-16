package com.example.test_map_struct.controller;

import com.example.test_map_struct.map.UserMapper;
import com.example.test_map_struct.model.UserApp;
import com.example.test_map_struct.model.UserDTO;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class TestController {

    List<UserApp> users = new ArrayList<>();

    @PostMapping("/register")
    public ResponseEntity register(
            @RequestBody UserApp userApp
    ) {
        UserMapper userMapper = Mappers.getMapper(UserMapper.class);

        UserApp user = new UserApp(userApp.getEmail(), userApp.getPassword(), userApp.getName());
        users.add(user);

//      UserDTO userDTO = UserMapper.INSTANCE.toUserDTO(user);
        UserDTO userDTO = userMapper.toUserDTO(user);
        return ResponseEntity.ok().body(userDTO);
    }
}
