package com.ld.digitallibrary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;


@Data
public class ItemDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("item_type")
    private String type;

    @JsonProperty("upload_date")
    private LocalDate uploadDate;

    @JsonProperty("user_id")
    private Long userId;

}
