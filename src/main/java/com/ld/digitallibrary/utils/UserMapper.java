package com.ld.digitallibrary.utils;

import com.ld.digitallibrary.dto.user.ReturnableUserDTO;
import com.ld.digitallibrary.dto.user.SavableUserDTO;
import com.ld.digitallibrary.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    ReturnableUserDTO toReturnableUserDTO(User source);

    User toUser(SavableUserDTO source);

}
