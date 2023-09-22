package com.ld.digitallibrary.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class ReturnableGroupDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;
}
