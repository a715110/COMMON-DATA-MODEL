package com.dodaso.ecosystem.common.dto;

import com.dodaso.ecosystem.baseline.common.dto.BaseDTO;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Request body for FileStorageController's POST /api/v1/files/upload --
 * a plain JSON DTO (not multipart/form-data), so it fits the existing
 * RESTReqContainer/RESTServiceClient pattern already used for every other
 * cross-service call in this codebase (see UserHelper, PipelineMetricsBean).
 * The browser-to-elcm-ui hop is unaffected by this -- that's still a real
 * multipart post via p:fileUpload; this DTO only describes the second hop,
 * elcm-ui (or any future caller) forwarding already-received bytes on to
 * common-service.
 */
@Getter
@Setter
public class FileUploadRequestDTO extends BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String sourceApp;
    private String ownerType;
    private Long ownerId;
    /** Optional -- falls back to azure.storage.default-container-name on
     * the common-service side if omitted. */
    private String containerName;
    private List<FileItemDTO> files;
}
