package com.dodaso.ecosystem.common.container;

import com.dodaso.ecosystem.baseline.common.container.DataContainer;
import com.dodaso.ecosystem.common.dto.FileUploadDTO;
import com.dodaso.ecosystem.common.dto.FileUploadRequestDTO;
import java.util.List;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DataContainer for FileUploadDTO. Carries a single FileUploadDTO for single-record
 * create/read/update/delete operations, and a FileUploadDTO list for list/search
 * operations, following the ecws-data-model / elcm-data-model container
 * convention. fileUploadRequestDTO additionally carries the inbound
 * upload request (raw file bytes + owner/company scoping) on POST
 * /api/v1/files/upload -- the request and response shapes both travel
 * through this same container so callers only need one type on the wire.
 *
 * fileUploadIds is the INBOUND counterpart used by POST
 * /api/v1/files/batch: the caller supplies the ids it wants looked up
 * here, and FileStorageController.batch() returns the matches via this
 * same container's fileUploadDTOList. Added 2026-10-02 -- the batch
 * endpoint in FileStorageController already called
 * requestContainer.getFileUploadIds() but this field was never added to
 * the container, which would fail to compile.
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class FileUploadDTOContainer extends DataContainer<FileUploadDTO> {

  FileUploadDTO fileUploadDTO;
  List<FileUploadDTO> fileUploadDTOList;
  FileUploadRequestDTO fileUploadRequestDTO;
  Set<Long> fileUploadIds;
}
