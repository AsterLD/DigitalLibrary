package com.ld.digitallibrary.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class SavableUserDTO {

    @JsonIgnore
    private Long id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

}
