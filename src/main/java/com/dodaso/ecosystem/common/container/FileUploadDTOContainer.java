package com.dodaso.ecosystem.common.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.common.dto.FileUploadRequestDTO;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for FileUploadDTO. Carries a single FileUploadDTO for single-record
 * create/read/update/delete operations, and a FileUploadDTO list for list/search
 * operations, following the ecws-data-model / elcm-data-model container
 * convention.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class FileUploadDTOContainer extends DataContainer<FileUploadRequestDTO> {
  List<FileUploadRequestDTO> fileUploadRequestDTOList;
  FileUploadRequestDTO fileUploadRequestDTO;
}
