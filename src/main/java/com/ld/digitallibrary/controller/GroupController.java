package com.ld.digitallibrary.controller;

import com.ld.digitallibrary.dto.GroupDTO;
import com.ld.digitallibrary.dto.GroupWithUsersDTO;
import com.ld.digitallibrary.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/group")
    public GroupDTO createGroup(@RequestBody GroupDTO groupDTO) {
        return groupService.createGroup(groupDTO);
    }

    @GetMapping("/group/all")
    public List<GroupDTO> getAllGroups() {
        return groupService.findAllGroups();
    }

    @GetMapping("/group/{id}")
    public GroupWithUsersDTO getGroupById(@PathVariable("id") Long groupId) {
        return groupService.findGroupById(groupId);
    }

    @PutMapping(value = "/group/{id}/update")
    public GroupDTO updateGroupById(@PathVariable("id") Long groupId, @RequestBody GroupDTO groupDTO) {
        return groupService.updateGroupById(groupDTO,groupId);
    }

    @PutMapping(value = "/group/{group_id}/user/{user_id}")
    public GroupWithUsersDTO addUserToGroup(@PathVariable("group_id") Long groupId, @PathVariable("user_id") Long userId) {
        return groupService.addUserToGroup(groupId, userId);
    }

    @DeleteMapping("/group/{id}/delete")
    public long deleteGroupById(@PathVariable("id") Long groupId) {
        groupService.deleteGroupById(groupId);
        return groupId;
    }

}
