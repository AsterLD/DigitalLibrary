package com.ld.digitallibrary.dto.file;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileDTO {

    String fileName;

    byte[] fileBytes;
}
