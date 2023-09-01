package com.ld.digitallibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;


@Data
public class GroupWithFullInfoDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("users")
    private Set<UserDTO> users;

    @JsonProperty("items")
    private Set<ItemDTO> items;
}
