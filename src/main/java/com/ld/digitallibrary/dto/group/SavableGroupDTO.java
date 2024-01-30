package com.ld.digitallibrary.dto.group;

import com.fasterxml.jackson.annotation.JsonProperty;


public record SavableGroupDTO(@JsonProperty("name") String name) {

}
