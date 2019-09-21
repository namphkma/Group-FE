package com.web.banhang.Service.Mapper;

import com.web.banhang.Entity.User;
import com.web.banhang.Service.Dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {
    public UserDto mapToDto(User entity){
        return  new UserDto(
                entity.getIdUser(),
                entity.getUserName(),
                entity.getAccount(),
                entity.getAddress(),
                entity.getPhoneNumber(),
                entity.isGender(),
                entity.getDateOfBirth(),
                entity.getEmail(),
                entity.getUrlPhotoUser()
                );
    }
    public List<UserDto> mapToDto(List<User> listEntity){
        return listEntity.stream()
                .map(entity -> mapToDto(entity) )
                .collect(Collectors.toList());
    }
}
