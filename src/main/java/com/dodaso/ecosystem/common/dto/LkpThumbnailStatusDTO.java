package com.dodaso.ecosystem.common.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for the common LkpThumbnailStatus entity/table. Mirrors the JPA
 * entity's persisted columns; relationship fields are represented as
 * nested DTOs (suffixed "DTO") rather than the JPA entity types, per the
 * ecws-data-model / elcm-data-model convention. Instances are placed into
 * the matching LkpThumbnailStatusDTOContainer before being passed to/from
 * the service layer.
 */
@Getter
@Setter
public class LkpThumbnailStatusDTO extends BaseDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  // id is inherited from BaseDTO -- see FileUploadDTO for why the
  // redeclaration that used to be here was removed.

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
