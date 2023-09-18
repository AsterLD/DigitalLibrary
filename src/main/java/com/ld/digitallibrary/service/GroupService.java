package com.ld.digitallibrary.service;

import com.ld.digitallibrary.dto.GroupDTO;
import com.ld.digitallibrary.dto.GroupWithFullInfoDTO;

import java.util.List;

public interface GroupService {

    GroupDTO createGroup(GroupDTO groupDTO);

    List<GroupDTO> findAllGroups(Integer page, Integer pageSize);

    GroupWithFullInfoDTO findGroupById(long groupId);

    GroupDTO updateGroupById(GroupDTO groupDTO, long groupId);

    GroupWithFullInfoDTO addUserToGroup(Long groupId, Long userId);

    GroupWithFullInfoDTO addItemToGroup(Long groupId, Long itemId);

    void deleteGroupById(long groupId);
}
