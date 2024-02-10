package com.ld.digitallibrary.service;

import com.ld.digitallibrary.dto.group.ReturnableFullGroupDTO;
import com.ld.digitallibrary.dto.group.ReturnableGroupDTO;
import com.ld.digitallibrary.dto.group.SavableGroupDTO;

import java.util.List;

public interface GroupService {

    ReturnableGroupDTO createGroup(SavableGroupDTO savableGroupDTO);

    List<ReturnableGroupDTO> findAllGroups(Integer page, Integer pageSize);

    ReturnableFullGroupDTO findGroupById(long groupId);

    ReturnableGroupDTO updateGroupById(SavableGroupDTO savableGroupDTO, long groupId);

    ReturnableFullGroupDTO addUserToGroup(Long groupId, Long userId);

    ReturnableFullGroupDTO addItemToGroup(Long groupId, Long itemId);

    void deleteGroupById(long groupId);
}
