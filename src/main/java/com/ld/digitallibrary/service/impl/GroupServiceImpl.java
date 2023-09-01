package com.ld.digitallibrary.service.impl;

import com.ld.digitallibrary.dto.GroupDTO;
import com.ld.digitallibrary.dto.GroupWithFullInfoDTO;
import com.ld.digitallibrary.entity.Group;
import com.ld.digitallibrary.entity.Item;
import com.ld.digitallibrary.entity.User;
import com.ld.digitallibrary.repo.GroupRepository;
import com.ld.digitallibrary.repo.ItemRepository;
import com.ld.digitallibrary.repo.UserRepository;
import com.ld.digitallibrary.service.GroupService;
import com.ld.digitallibrary.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    private final UserRepository userRepository;

    private final ItemRepository itemRepository;

    @Override
    public GroupDTO createGroup(GroupDTO groupDTO) {
        groupRepository.save(Mapper.mapGroupDTOToGroup(groupDTO));
        return groupDTO;
    }

    @Override
    public List<GroupDTO> findAllGroups() {
        List<Group> groupList = groupRepository.findAll();
        return groupList.stream().map(Mapper::mapGroupToGroupDTO).collect(Collectors.toList());
    }

    @Override
    public GroupWithFullInfoDTO findGroupById(long groupId) {
        return Mapper.mapGroupToGroupWithUsersDTO(groupRepository.findById(groupId).orElseThrow());
    }

    @Override
    public GroupDTO updateGroupById(GroupDTO groupDTO, long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        Mapper.updateGroup(group, groupDTO);
        groupRepository.save(group);
        return groupDTO;
    }

    @Override
    public GroupWithFullInfoDTO addUserToGroup(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        group.getUsers().add(user);
        groupRepository.save(group);
        return Mapper.mapGroupToGroupWithUsersDTO(group);
    }

    @Override
    public GroupWithFullInfoDTO addItemToGroup(Long groupId, Long itemId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        Item item = itemRepository.findById(itemId).orElseThrow();
        group.getItems().add(item);
        groupRepository.save(group);
        return Mapper.mapGroupToGroupWithUsersDTO(group);
    }

    @Override
    public void deleteGroupById(long groupId) {
        groupRepository.delete(groupRepository.findById(groupId).orElseThrow());
    }
}
