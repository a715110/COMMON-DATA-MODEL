package com.dodaso.ecosystem.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * ADDED 2026-11-12. Maps to common.perf_incident: one slow call, CPU heavy call, slow request, call
 * still running, or high CPU reading reported by the perf monitor of any dodaso app. Written by the
 * ingest call, read by the admin page, removed by the retention job. Times are milliseconds and
 * occurred_at is UTC. The class and method are kept in two columns so the "top calls" summary can
 * group on them.
 */
@Entity
@Table(name = "perf_incident")
@Getter
@Setter
public class PerfIncident implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "occurred_at", nullable = false)
  private LocalDateTime occurredAt;

  /** The app that reported it, such as elcm-service or ecws-ui. */
  @Column(name = "service", nullable = false, length = 60)
  private String service;

  /** SLOW_SELF, CPU_HEAVY, SLOW_ENTRY, STILL_RUNNING or HIGH_CPU, joined by commas. */
  @Column(name = "reason", nullable = false, length = 80)
  private String reason;

  @Column(name = "layer", length = 20)
  private String layer;

  @Column(name = "class_name", nullable = false, length = 150)
  private String className;

  @Column(name = "method_name", nullable = false, length = 250)
  private String methodName;

  /** CPU, WAIT, MIXED or UNKNOWN. */
  @Column(name = "kind", length = 10)
  private String kind;

  @Column(name = "own_wall_ms")
  private Long ownWallMs;

  @Column(name = "own_cpu_ms")
  private Long ownCpuMs;

  @Column(name = "wall_ms")
  private Long wallMs;

  @Column(name = "cpu_ms")
  private Long cpuMs;

  @Column(name = "outcome", length = 80)
  private String outcome;

  @Column(name = "thread_name", length = 120)
  private String threadName;

  @Column(name = "request_id", length = 64)
  private String requestId;

  @Column(name = "user_login", length = 100)
  private String userLogin;

  @Column(name = "call_chain", length = 400)
  private String callChain;

  @Column(name = "stack_text", columnDefinition = "TEXT")
  private String stackText;
}
