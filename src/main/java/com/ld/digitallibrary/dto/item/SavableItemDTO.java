package com.ld.digitallibrary.dto.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;



public record SavableItemDTO(@JsonIgnore Long id,
                             @JsonProperty("name") String name,
                             @JsonProperty("item_type") String type,
                             @JsonProperty("upload_date") LocalDate uploadDate,
                             @JsonProperty("user_id") Long userId) {

}
