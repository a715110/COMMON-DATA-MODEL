package com.dodaso.ecosystem.common.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * One file's raw bytes, as carried inside FileUploadRequestDTO from
 * elcm-ui (or any future caller) to common-service's FileStorageController.
 * Not persisted directly -- content is written to Azure and discarded;
 * only the resulting FileUploadDTO (id, blobUrl, etc.) is persisted/
 * returned. "content" serializes as a base64 JSON string via Jackson's
 * default byte[] handling -- no custom (de)serializer needed.
 */
@Getter
@Setter
public class FileItemDTO implements Serializable {
    private String fileName;
    private String contentType;
    private byte[] content;
}
