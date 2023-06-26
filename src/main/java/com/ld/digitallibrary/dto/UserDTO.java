package com.ld.digitallibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class UserDTO {

    @JsonProperty("user_id")
    private Long user_id;

    @JsonProperty("username")
    private String username;

}
