package com.dodaso.ecosystem.common.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Maps to common.lkp_thumbnail_status -- generated from the authoritative
 * dodaso-platform.dbs schema (common_schema.sql export), not hand-written.
 * Seed rows expected: PENDING, PROCESSING, COMPLETED, FAILED -- no SKIPPED
 * status; a file_upload row that isn't thumbnailable simply never gets a
 * file_thumbnail row (see FileThumbnail). Relationships are unidirectional
 * (owning side only, no inverse @OneToMany collections) to keep this first
 * pass simple. created_at/updated_at are insertable=false, updatable=false
 * -- the database's own DEFAULT/ON UPDATE CURRENT_TIMESTAMP owns those
 * values, not the application.
 */
@Entity
@Table(name = "lkp_thumbnail_status")
@Getter
@Setter
public class LkpThumbnailStatus implements Serializable {

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

    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by", length = 255)
    private String updatedBy;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
