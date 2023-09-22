package com.ld.digitallibrary.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ld.digitallibrary.dto.item.ReturnableItemDTO;
import com.ld.digitallibrary.dto.user.ReturnableUserDTO;
import lombok.Data;

import java.util.Set;


@Data
public class ReturnableFullGroupDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("users")
    private Set<ReturnableUserDTO> users;

    @JsonProperty("items")
    private Set<ReturnableItemDTO> items;
}
