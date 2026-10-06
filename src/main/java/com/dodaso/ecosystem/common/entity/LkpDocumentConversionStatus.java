package com.dodaso.ecosystem.common.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Maps to common.lkp_document_conversion_status -- same pattern/shape as
 * LkpThumbnailStatus, but kept as its own dedicated lookup table rather
 * than reusing lkp_thumbnail_status, per this codebase's convention of one
 * lookup table per concept even when the code values happen to coincide
 * (PENDING/PROCESSING/COMPLETED/FAILED) -- the two processes
 * (thumbnail-generation vs. office-document-to-PDF conversion) are
 * unrelated and can evolve independently (e.g. a future SKIPPED status for
 * conversion, for a format Gotenberg itself doesn't support, would have no
 * meaning for thumbnails).
 *
 * ADDED 2026-10-02 -- backs DocumentConversion, the new async "convert
 * .docx/.xlsx/.pptx to PDF via Gotenberg" feature for the Stage Documents
 * dashboard's file-preview pane (see DocumentConversionService's Javadoc).
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "lkp_document_conversion_status")
@Getter
@Setter
public class LkpDocumentConversionStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "label", nullable = false, length = 150)
    private String label;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @CreatedBy
    @Column(name = "created_by", updatable = false, length = 255)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
