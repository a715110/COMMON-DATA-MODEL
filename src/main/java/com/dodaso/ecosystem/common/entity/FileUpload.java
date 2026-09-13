package com.dodaso.ecosystem.common.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to common.file_upload -- generated from the authoritative
 * dodaso-platform.dbs schema (common_schema.sql export), not hand-written.
 * Shared file/blob metadata for uploads originating in either ECWS or ELCM.
 * owner_type/owner_id is an unenforced polymorphic reference back into the
 * owning app's own schema (ecws or elcm) -- no FK is possible across
 * physical schemas, so referential integrity to the owning row is the
 * application's responsibility; kept here as plain scalar columns, not a
 * JPA relationship. source_app records which app's DB user wrote the row.
 * Thumbnail generation state lives in FileThumbnail, not here.
 * created_at/updated_at are insertable=false, updatable=false -- the
 * database's own DEFAULT/ON UPDATE CURRENT_TIMESTAMP owns those values,
 * not the application.
 */
@Entity
@Table(name = "file_upload")
@Getter
@Setter
public class FileUpload implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "source_app", nullable = false, length = 20)
    private String sourceApp;

    @Column(name = "owner_type", nullable = false, length = 50)
    private String ownerType;

    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    @Column(name = "file_name", nullable = false, length = 255)
    private String fileName;

    @Column(name = "content_type", length = 100)
    private String contentType;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "storage_type", nullable = false, length = 20)
    private String storageType;

    @Column(name = "blob_container", length = 150)
    private String blobContainer;

    @Column(name = "blob_path", length = 500)
    private String blobPath;

    @Column(name = "blob_url", length = 1000)
    private String blobUrl;

    @Column(name = "active_ind", nullable = false)
    private Boolean activeInd;

    @Column(name = "created_by", nullable = false, length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
