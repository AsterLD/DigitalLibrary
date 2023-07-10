package com.ld.digitallibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileDTO {

    String fileName;

    byte[] fileBytes;
}
