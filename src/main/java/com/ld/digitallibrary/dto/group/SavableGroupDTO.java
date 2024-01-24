package com.ld.digitallibrary.dto.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



public record SavableGroupDTO(@JsonIgnore Long id,
                              @JsonProperty("name") String name) {

}
