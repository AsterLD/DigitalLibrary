package com.ld.digitallibrary.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;


public record SavableUserDTO(@JsonProperty("user_name") String username,
                             @JsonProperty("email") String email) {

}
