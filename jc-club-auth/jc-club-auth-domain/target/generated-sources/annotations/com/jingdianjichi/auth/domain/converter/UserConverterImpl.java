package com.jingdianjichi.auth.domain.converter;

import com.jingdianjichi.auth.domain.bo.UserBo;
import com.jingdianjichi.auth.infra.entity.User;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T18:46:26+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class UserConverterImpl implements UserConverter {

    @Override
    public User convertBoToEntity(UserBo userBo) {
        if ( userBo == null ) {
            return null;
        }

        User user = new User();

        user.setId( userBo.getId() );
        user.setUserName( userBo.getUserName() );
        user.setNickName( userBo.getNickName() );
        user.setEmail( userBo.getEmail() );
        user.setPhone( userBo.getPhone() );
        user.setPassword( userBo.getPassword() );
        user.setSex( userBo.getSex() );
        user.setAvatar( userBo.getAvatar() );
        user.setStatus( userBo.getStatus() );
        user.setIntroduce( userBo.getIntroduce() );
        user.setExtJson( userBo.getExtJson() );
        user.setIsDeleted( userBo.getIsDeleted() );

        return user;
    }
}
