package com.cda.api.controller;

import com.cda.api.dto.user.UserDto;
import com.cda.api.mapper.UserMapper;
import com.cda.api.model.User;
import com.cda.api.service.IUserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {


    @Autowired
    IUserService userService;

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserDto> login(@RequestBody @NonNull final UserDto userDto) {
        Boolean isLoginOk = false;
        User userResult = userService.login(userDto.getMail(), userDto.getPassword());
        if(userResult == null) {
            return ResponseEntity.notFound().build();
        }
        UserDto userCo = userMapper.userToUserDto(userResult);
        return ResponseEntity.ok(userCo);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<UserDto> create(@RequestBody @NonNull UserDto userDto) {

        User newUser = userMapper.userDtoToUser(userDto);
        userService.save(newUser);
        User userFind = userService.findById(newUser.getId());

        if(userFind == null) {
            return ResponseEntity.notFound().build();
        }

        UserDto userFindDto = userMapper.userToUserDto(userFind);

        return ResponseEntity.ok(userFindDto);
    }
}
