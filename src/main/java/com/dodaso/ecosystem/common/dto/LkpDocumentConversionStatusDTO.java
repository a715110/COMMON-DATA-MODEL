package com.dodaso.ecosystem.common.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the common LkpDocumentConversionStatus entity/table. Same
 * shape/convention as LkpThumbnailStatusDTO.
 */
@Getter
@Setter
public class LkpDocumentConversionStatusDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private String code;
  private String label;
  private String description;
  private Integer sortOrder;
  private Boolean isActive;
  private String createdBy;
  private LocalDateTime createdAt;
  private String updatedBy;
  private LocalDateTime updatedAt;
}
