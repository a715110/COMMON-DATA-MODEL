package com.dodaso.ecosystem.common.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the common FileUpload entity/table. Mirrors the JPA entity's
 * persisted columns exactly, including ownerType/ownerId (the unenforced
 * polymorphic reference back into the owning app's own ecws/elcm schema --
 * kept as scalars here, never a nested DTO, since no real relationship
 * exists to represent). Instances are placed into the matching
 * FileUploadDTOContainer before being passed to/from the service layer.
 */
@Getter
@Setter
public class FileUploadDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  // id is inherited from BaseDTO (getId()/setId()) -- redeclaring it here
  // shadowed rather than reused it, meaning two separate "id" fields
  // existed on this class in practice. Removed now; audit fields
  // (createdBy/createdAt/updatedBy/updatedAt) are left as-is for now per
  // instruction, to revisit once file upload itself is settled.

  private String sourceApp;
  private String ownerType;
  private Long ownerId;
  private Long companyId;
  private String fileName;
  private String contentType;
  private Long fileSize;
  private String storageType;
  private String blobContainer;
  private String blobPath;
  private String blobUrl;
  private Boolean activeInd;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
