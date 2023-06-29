package com.ld.digitallibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class UserDTO {

    @JsonProperty("username")
    private String username;

}
