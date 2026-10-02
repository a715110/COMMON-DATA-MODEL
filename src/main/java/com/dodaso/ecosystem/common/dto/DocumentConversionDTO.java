package com.dodaso.ecosystem.common.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the common DocumentConversion entity/table. Same shape/
 * convention as FileThumbnailDTO -- see that class and DocumentConversion
 * entity's Javadoc for the full feature context.
 */
@Getter
@Setter
public class DocumentConversionDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private FileUploadDTO fileUploadDTO;
  private LkpDocumentConversionStatusDTO statusDTO;
  private String blobContainer;
  private String blobPath;
  private String blobUrl;
  private Integer pageCount;
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
