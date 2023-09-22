package com.ld.digitallibrary.service.impl;

import com.ld.digitallibrary.dto.group.ReturnableGroupDTO;
import com.ld.digitallibrary.dto.group.ReturnableFullGroupDTO;
import com.ld.digitallibrary.dto.group.SavableGroupDTO;
import com.ld.digitallibrary.entity.Group;
import com.ld.digitallibrary.entity.Item;
import com.ld.digitallibrary.entity.User;
import com.ld.digitallibrary.repo.GroupRepository;
import com.ld.digitallibrary.repo.ItemRepository;
import com.ld.digitallibrary.repo.UserRepository;
import com.ld.digitallibrary.service.GroupService;
import com.ld.digitallibrary.utils.GroupMapper;
import com.ld.digitallibrary.utils.Updater;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
    public ReturnableGroupDTO createGroup(SavableGroupDTO savableGroupDTO) {
        Group group = groupRepository.save(GroupMapper.mapSavableDTOToGroup(savableGroupDTO));
        return GroupMapper.mapGroupToReturnableDTO(group);
    }

    @Override
    public List<ReturnableGroupDTO> findAllGroups(Integer page, Integer pageSize) {
        List<Group> groupList = groupRepository.findAll(PageRequest.of(page -1, pageSize)).getContent();
        return groupList.stream().map(GroupMapper::mapGroupToReturnableDTO).collect(Collectors.toList());
    }

    @Override
    public ReturnableFullGroupDTO findGroupById(long groupId) {
        return GroupMapper.mapGroupToReturnableFullGroupDTO(groupRepository.findById(groupId).orElseThrow());
    }

    @Override
    public ReturnableGroupDTO updateGroupById(SavableGroupDTO savableGroupDTO, long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        Updater.updateGroup(group, savableGroupDTO);
        groupRepository.save(group);
        return GroupMapper.mapGroupToReturnableDTO(group);
    }

    @Override
    public ReturnableFullGroupDTO addUserToGroup(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        group.getUsers().add(user);
        groupRepository.save(group);
        return GroupMapper.mapGroupToReturnableFullGroupDTO(group);
    }

    @Override
    public ReturnableFullGroupDTO addItemToGroup(Long groupId, Long itemId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        Item item = itemRepository.findById(itemId).orElseThrow();
        group.getItems().add(item);
        groupRepository.save(group);
        return GroupMapper.mapGroupToReturnableFullGroupDTO(group);
    }

    @Override
    public void deleteGroupById(long groupId) {
        groupRepository.delete(groupRepository.findById(groupId).orElseThrow());
    }
}
