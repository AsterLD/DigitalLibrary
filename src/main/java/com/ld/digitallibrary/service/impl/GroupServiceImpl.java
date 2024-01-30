package com.ld.digitallibrary.service.impl;

import com.ld.digitallibrary.dto.group.ReturnableFullGroupDTO;
import com.ld.digitallibrary.dto.group.ReturnableGroupDTO;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    private final UserRepository userRepository;

    private final ItemRepository itemRepository;

    private final GroupMapper groupMapper;

    @Override
    public ReturnableGroupDTO createGroup(SavableGroupDTO savableGroupDTO) {
        Group group = groupRepository.save(groupMapper.toGroup(savableGroupDTO));
        log.info("Group with name: " + group.getName() + " has been saved, with id: " + group.getId());
        return groupMapper.toReturnableDTO(group);
    }

    @Override
    public List<ReturnableGroupDTO> findAllGroups(Integer page, Integer pageSize) {
        List<Group> groupList = groupRepository.findAll(PageRequest.of(page - 1, pageSize)).getContent();
        return groupList.stream().map(groupMapper::toReturnableDTO).collect(Collectors.toList());
    }

    @Override
    public ReturnableFullGroupDTO findGroupById(long groupId) {
        return groupMapper.toReturnableFullGroupDTO(groupRepository.findById(groupId).orElseThrow());
    }

    @Override
    public ReturnableGroupDTO updateGroupById(SavableGroupDTO savableGroupDTO, long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        Updater.updateGroup(group, savableGroupDTO);
        groupRepository.save(group);
        log.info("Group with id: " + group.getId() + " has been updated");
        return groupMapper.toReturnableDTO(group);
    }

    @Override
    public ReturnableFullGroupDTO addUserToGroup(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        group.getUsers().add(user);
        groupRepository.save(group);
        log.info("User, id: " + user.getId() + " has been added to group, id: " + group.getId());
        return groupMapper.toReturnableFullGroupDTO(group);
    }

    @Override
    public ReturnableFullGroupDTO addItemToGroup(Long groupId, Long itemId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        Item item = itemRepository.findById(itemId).orElseThrow();
        group.getItems().add(item);
        groupRepository.save(group);
        log.info("Item, id: " + item.getId() + " has been added to group, id: " + group.getId());
        return groupMapper.toReturnableFullGroupDTO(group);
    }

    @Override
    public void deleteGroupById(long groupId) {
        groupRepository.delete(groupRepository.findById(groupId).orElseThrow());
        log.info("Group, id: " + groupId + " has been deleted");
    }
}
