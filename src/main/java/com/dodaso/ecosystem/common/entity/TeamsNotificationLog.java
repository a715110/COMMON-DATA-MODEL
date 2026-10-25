package com.dodaso.ecosystem.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

/**
 * ADDED 2026-10-23, moved to the common schema 2026-10-24. One row per Teams notification the
 * system tried to send (task assigned, mentioned, overdue and any later event). The event key
 * (checked together with status SENT) stops the same event being sent twice, for example the daily
 * overdue reminder for one task. It does not extend the audit class on purpose: rows are written by
 * background jobs that have no signed-in user.
 */
@Getter
@Setter
@Entity
@Table(name = "teams_notification_log")
public class TeamsNotificationLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "event_key", nullable = false, length = 250)
  private String eventKey;

  @Column(name = "event_type", nullable = false, length = 150)
  private String eventType;

  @Column(name = "task_id")
  private Integer taskId;

  @Column(name = "recipient_login", length = 150)
  private String recipientLogin;

  /** SENT, FAILED or SKIPPED. */
  @Column(name = "status", nullable = false, length = 20)
  private String status;

  @Column(name = "detail", length = 500)
  private String detail;

  @Column(name = "sent_at", nullable = false)
  private Instant sentAt;
}
