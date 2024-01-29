package com.ld.digitallibrary.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public record SavableUserDTO(@JsonIgnore Long id,
                             @JsonProperty("username") String username,
                             @JsonProperty("email") String email) {

}
