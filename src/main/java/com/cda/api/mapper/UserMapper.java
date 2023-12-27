package com.cda.api.mapper;

import com.cda.api.dto.user.UserDto;
import com.cda.api.dto.utilisateur.UtilisateurCoDto;
import com.cda.api.dto.utilisateur.UtilisateurDto;
import com.cda.api.model.User;
import com.cda.api.model.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

}
