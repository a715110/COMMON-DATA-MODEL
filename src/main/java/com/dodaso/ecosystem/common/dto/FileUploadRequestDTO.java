package com.dodaso.ecosystem.common.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Request payload for POST /api/v1/files/upload. Carries the raw file
 * bytes (as FileItemDTO) plus the polymorphic owner reference
 * (sourceApp/ownerType/ownerId) and companyId that FileUpload rows are
 * scoped/tagged by. containerName is optional -- when null, the service
 * falls back to azure.storage.default-container-name. This is a request
 * shape, not a persisted entity's DTO, but extends BaseDTO to stay
 * consistent with the container/DataContainer convention used to carry it.
 */
@Getter
@Setter
public class FileUploadRequestDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String sourceApp;
  private Long companyId;
  private String ownerType;
  private Long ownerId;
  private String containerName;
  private List<FileItemDTO> files;
}
