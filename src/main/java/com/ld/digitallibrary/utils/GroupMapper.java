package com.ld.digitallibrary.utils;

import com.ld.digitallibrary.dto.group.ReturnableFullGroupDTO;
import com.ld.digitallibrary.dto.group.ReturnableGroupDTO;
import com.ld.digitallibrary.dto.group.SavableGroupDTO;
import com.ld.digitallibrary.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupMapper {

    ReturnableGroupDTO toReturnableDTO(Group group);

    ReturnableFullGroupDTO toReturnableFullGroupDTO(Group group);

    Group toGroup(SavableGroupDTO savableGroupDTO);

}
