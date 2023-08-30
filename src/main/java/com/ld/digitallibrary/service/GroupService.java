package com.ld.digitallibrary.service;

import com.ld.digitallibrary.dto.GroupDTO;
import com.ld.digitallibrary.dto.GroupWithUsersDTO;

import java.util.List;

public interface GroupService {

    GroupDTO createGroup(GroupDTO groupDTO);

    List<GroupDTO> findAllGroups();

    GroupWithUsersDTO findGroupById(long groupId);

    GroupDTO updateGroupById(GroupDTO groupDTO, long groupId);

    GroupWithUsersDTO addUserToGroup(Long groupId, Long userId);

    void deleteGroupById(long groupId);
}
