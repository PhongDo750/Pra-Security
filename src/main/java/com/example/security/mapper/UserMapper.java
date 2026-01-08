package com.example.security.mapper;

import com.example.security.dto.request.UserRequest;
import com.example.security.dto.response.UserOutputV2;
import com.example.security.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {
    UserOutputV2 getOutputFromEntity(UserEntity userEntity);
    UserEntity getEntityFromRequest(UserRequest signUpRequest);
}
