package com.dodaso.ecosystem.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * ADDED 2026-10-24. Audit columns of the messaging tables in the common schema, same shape as the
 * ECWS AuditableField they replace. The times are stamped as true UTC instants (see the note in
 * the ECWS class: the audit provider supplies a UTC wall clock that would otherwise be shifted by
 * the JVM time zone).
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class CommonAuditableField {

  @CreatedDate
  @Column(name = "created_at", nullable = false, columnDefinition = "timestamp")
  private Instant createdAt;

  @CreatedBy
  @Column(name = "created_by", nullable = false, length = 100)
  private String createdBy;

  @LastModifiedDate
  @Column(name = "updated_at", columnDefinition = "timestamp")
  private Instant updatedAt;

  @LastModifiedBy
  @Column(name = "updated_by", length = 100)
  private String updatedBy;

  @PrePersist
  void stampCreated() {
    final Instant now = Instant.now();
    createdAt = now;
    updatedAt = now;
  }

  @PreUpdate
  void stampUpdated() {
    updatedAt = Instant.now();
  }
}
