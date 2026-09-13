package com.dodaso.ecosystem.common.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.common.dto.LkpThumbnailStatusDTO;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for LkpThumbnailStatusDTO. Carries a single LkpThumbnailStatusDTO for single-record
 * create/read/update/delete operations, and a LkpThumbnailStatusDTO list for list/search
 * operations, following the ecws-data-model / elcm-data-model container
 * convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class LkpThumbnailStatusDTOContainer extends DataContainer<LkpThumbnailStatusDTO> {

  LkpThumbnailStatusDTO lkpThumbnailStatusDTO;
  List<LkpThumbnailStatusDTO> lkpThumbnailStatusDTOList;
}
