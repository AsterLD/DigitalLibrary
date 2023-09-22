package com.ld.digitallibrary.utils;

import com.ld.digitallibrary.dto.group.ReturnableGroupDTO;
import com.ld.digitallibrary.dto.group.ReturnableFullGroupDTO;
import com.ld.digitallibrary.dto.group.SavableGroupDTO;
import com.ld.digitallibrary.entity.Group;
import org.modelmapper.ModelMapper;

public class GroupMapper {

    public static ReturnableGroupDTO mapGroupToReturnableDTO(Group group) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(group, ReturnableGroupDTO.class);
    }

    public static ReturnableFullGroupDTO mapGroupToReturnableFullGroupDTO(Group group) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(group, ReturnableFullGroupDTO.class);
    }

    public static Group mapSavableDTOToGroup(SavableGroupDTO savableGroupDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(savableGroupDTO, Group.class);
    }

}
