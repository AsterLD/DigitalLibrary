package com.ld.digitallibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class GroupWithUsersDTO {

    @JsonProperty("name")
    private String name;
}
