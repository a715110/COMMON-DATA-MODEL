package com.dodaso.ecosystem.common.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to common.document_conversion -- same shape/conventions as
 * FileThumbnail (its closest sibling in this codebase), tracking async
 * "convert this upload to a previewable PDF via Gotenberg" state. One
 * current-state row per FileUpload; fileUploadId has a DB-level UNIQUE
 * constraint (uq_document_conversion_file_upload), modeled as @OneToOne on
 * the owning (child) side, same as FileThumbnail.fileUpload.
 *
 * ADDED 2026-10-02 -- rows are created lazily, only for formats a browser
 * can't render natively and Gotenberg CAN convert (.docx/.xlsx/.pptx and
 * their legacy .doc/.xls/.ppt equivalents -- see
 * DocumentConversionEligibility) -- unlike FileThumbnail, this is NOT
 * queued for every upload: a PDF or image already previews fine on its
 * own and would never need a row here. A FileUpload with no matching row
 * here was either never eligible, or predates this feature.
 *
 * pageCount is nullable and currently unused by any caller -- kept for
 * parity with the kind of metadata a PDF viewer might eventually want
 * (page count shown in a UI), not because anything populates it yet;
 * Gotenberg's convert response is just raw PDF bytes, so getting a page
 * count would mean a second pass (e.g. PDFBox) over the result, not
 * implemented in this first increment.
 */
@Entity
@Table(name = "document_conversion", uniqueConstraints = {@UniqueConstraint(columnNames = {"file_upload_id"})})
@Getter
@Setter
public class DocumentConversion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_upload_id", nullable = false)
    private FileUpload fileUpload;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private LkpDocumentConversionStatus status;

    @Column(name = "blob_container", length = 150)
    private String blobContainer;

    @Column(name = "blob_path", length = 500)
    private String blobPath;

    @Column(name = "blob_url", length = 1000)
    private String blobUrl;

    @Column(name = "page_count")
    private Integer pageCount;

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
