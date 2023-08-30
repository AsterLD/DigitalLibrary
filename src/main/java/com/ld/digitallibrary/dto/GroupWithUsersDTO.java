package com.ld.digitallibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;


@Data
public class GroupWithUsersDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("users")
    private Set<UserDTO> users;
}
