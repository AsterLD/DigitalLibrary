package com.ld.digitallibrary.controller;

import com.ld.digitallibrary.dto.group.ReturnableFullGroupDTO;
import com.ld.digitallibrary.dto.group.ReturnableGroupDTO;
import com.ld.digitallibrary.dto.group.SavableGroupDTO;
import com.ld.digitallibrary.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/group")
    public ReturnableGroupDTO createGroup(@RequestBody SavableGroupDTO savableGroupDTO) {
        return groupService.createGroup(savableGroupDTO);
    }

    @GetMapping("/group/all")
    public List<ReturnableGroupDTO> getAllGroups(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return groupService.findAllGroups(page, pageSize);
    }

    @GetMapping("/group/{id}")
    public ReturnableFullGroupDTO getGroupById(@PathVariable("id") Long groupId) {
        return groupService.findGroupById(groupId);
    }

    @PutMapping(value = "/group/{id}/update")
    public ReturnableGroupDTO updateGroupById(@PathVariable("id") Long groupId,
                                              @RequestBody SavableGroupDTO savableGroupDTO) {
        return groupService.updateGroupById(savableGroupDTO, groupId);
    }

    @PutMapping(value = "/group/{group_id}/user/{user_id}")
    public ReturnableFullGroupDTO addUserToGroup(@PathVariable("group_id") Long groupId,
                                                 @PathVariable("user_id") Long userId) {
        return groupService.addUserToGroup(groupId, userId);
    }

    @PutMapping(value = "/group/{group_id}/item/{item_id}")
    public ReturnableFullGroupDTO addItemToGroup(@PathVariable("group_id") Long groupId,
                                                 @PathVariable("item_id") Long itemId) {
        return groupService.addItemToGroup(groupId, itemId);
    }

    @DeleteMapping("/group/{id}/delete")
    public long deleteGroupById(@PathVariable("id") Long groupId) {
        groupService.deleteGroupById(groupId);
        return groupId;
    }

}
