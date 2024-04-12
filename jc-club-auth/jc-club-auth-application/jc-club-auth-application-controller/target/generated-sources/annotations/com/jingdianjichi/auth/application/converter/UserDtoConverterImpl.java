package com.jingdianjichi.auth.application.converter;

import com.jingdianjichi.auth.application.dto.UserDto;
import com.jingdianjichi.auth.domain.bo.UserBo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T18:46:29+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class UserDtoConverterImpl implements UserDtoConverter {

    @Override
    public UserBo convertDtoToInfoBo(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserBo userBo = new UserBo();

        userBo.setId( userDto.getId() );
        userBo.setUserName( userDto.getUserName() );
        userBo.setNickName( userDto.getNickName() );
        userBo.setEmail( userDto.getEmail() );
        userBo.setPhone( userDto.getPhone() );
        userBo.setPassword( userDto.getPassword() );
        userBo.setSex( userDto.getSex() );
        userBo.setAvatar( userDto.getAvatar() );
        userBo.setStatus( userDto.getStatus() );
        userBo.setIntroduce( userDto.getIntroduce() );
        userBo.setExtJson( userDto.getExtJson() );
        userBo.setIsDeleted( userDto.getIsDeleted() );

        return userBo;
    }
}
