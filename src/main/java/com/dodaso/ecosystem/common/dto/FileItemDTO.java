package com.dodaso.ecosystem.common.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Carries one raw file's bytes across the wire as part of a
 * FileUploadRequestDTO. Not a persisted entity's DTO -- there is no
 * FileItem table -- so this does NOT extend BaseDTO. Jackson serializes
 * `content` as base64 automatically since the declared type is byte[].
 */
@Getter
@Setter
public class FileItemDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String fileName;
  private String contentType;
  private byte[] content;
}
