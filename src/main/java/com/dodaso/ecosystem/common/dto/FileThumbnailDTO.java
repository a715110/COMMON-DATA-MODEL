package com.dodaso.ecosystem.common.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the common FileThumbnail entity/table. Mirrors the JPA entity's
 * persisted columns; relationship fields are represented as nested DTOs
 * (suffixed "DTO") rather than the JPA entity types, per the
 * ecws-data-model / elcm-data-model convention. Instances are placed into
 * the matching FileThumbnailDTOContainer before being passed to/from the
 * service layer.
 */
@Getter
@Setter
public class FileThumbnailDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private FileUploadDTO fileUploadDTO;
  private LkpThumbnailStatusDTO statusDTO;
  private String blobContainer;
  private String blobPath;
  private String blobUrl;
  private Integer widthPx;
  private Integer heightPx;
  private Integer attemptCount;
  private String lastErrorMessage;
  private LocalDateTime requestedAt;
  private LocalDateTime startedAt;
  private LocalDateTime completedAt;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
