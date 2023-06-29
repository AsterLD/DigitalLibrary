package com.ld.digitallibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ld.digitallibrary.entity.User;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class ItemDTO {


    @JsonProperty("name")
    private String name;

    @JsonProperty("item_type")
    private String type;

    @JsonProperty("user_id")
    private Long userId;

}
