package com.ld.digitallibrary.dto.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class SavableGroupDTO {

    @JsonIgnore
    private Long id;

    @JsonProperty("name")
    private String name;
}
