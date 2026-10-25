package com.dodaso.ecosystem.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "system_messaging_config")
public class SystemMessagingConfig extends CommonAuditableField {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "channel_type", nullable = false, length = 50)
  private String channelType;

  @ColumnDefault("0")
  @Column(name = "active_ind")
  private Boolean activeInd;

  @Column(name = "display_name", length = 100)
  private String displayName;

  @ColumnDefault("0")
  @Column(name = "priority")
  private Integer priority;

  @Column(name = "tenant_id")
  private String tenantId;

  @Column(name = "client_id")
  private String clientId;

  @Column(name = "client_secret")
  private String clientSecret;

  @Column(name = "webhook_url", length = 500)
  private String webhookUrl;

  @Column(name = "api_endpoint", length = 500)
  private String apiEndpoint;

  @Column(name = "smtp_host")
  private String smtpHost;

  @Column(name = "smtp_port")
  private Integer smtpPort;

  @Column(name = "smtp_username")
  private String smtpUsername;

  @Column(name = "smtp_password")
  private String smtpPassword;

  @ColumnDefault("1")
  @Column(name = "smtp_use_tls")
  private Boolean smtpUseTls;

  @Column(name = "email_from_address")
  private String emailFromAddress;

  @Column(name = "email_from_name", length = 100)
  private String emailFromName;

  @JdbcTypeCode(SqlTypes.JSON)
  @Column(name = "additional_settings")
  private Map<String, Object> additionalSettings;
}