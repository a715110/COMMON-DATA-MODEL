package com.dodaso.ecosystem.common.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to common.file_thumbnail -- generated from the authoritative
 * dodaso-platform.dbs schema (common_schema.sql export), not hand-written.
 * One current-state row per FileUpload tracking async thumbnail generation
 * (AzureBlobStorageHandler). Rows are created lazily -- only inserted (as
 * PENDING) when the upload handler determines the file is thumbnailable
 * (e.g. content_type starts with image/); a FileUpload with no matching
 * row here was never eligible for a thumbnail. attemptCount/
 * lastErrorMessage support retry; a worker polls status=PENDING (or
 * FAILED, up to a retry cap) ordered by requestedAt. fileUploadId has a
 * DB-level UNIQUE constraint (uq_file_thumbnail_file_upload), i.e. this is
 * effectively a 1:1 extension of file_upload, modeled here as @OneToOne on
 * the owning (child) side. All @ManyToOne/@OneToOne use FetchType.LAZY
 * deliberately. created_at/updated_at are insertable=false, updatable=false
 * -- the database's own DEFAULT/ON UPDATE CURRENT_TIMESTAMP owns those
 * values, not the application.
 */
@Entity
@Table(name = "file_thumbnail", uniqueConstraints = {@UniqueConstraint(columnNames = {"file_upload_id"})})
@Getter
@Setter
public class FileThumbnail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_upload_id", nullable = false)
    private FileUpload fileUpload;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private LkpThumbnailStatus status;

    @Column(name = "blob_container", length = 150)
    private String blobContainer;

    @Column(name = "blob_path", length = 500)
    private String blobPath;

    @Column(name = "blob_url", length = 1000)
    private String blobUrl;

    @Column(name = "width_px")
    private Integer widthPx;

    @Column(name = "height_px")
    private Integer heightPx;

    @Column(name = "attempt_count", nullable = false)
    private Integer attemptCount;

    @Column(name = "last_error_message", length = 1000)
    private String lastErrorMessage;

    @Column(name = "requested_at", nullable = false)
    private LocalDateTime requestedAt;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
