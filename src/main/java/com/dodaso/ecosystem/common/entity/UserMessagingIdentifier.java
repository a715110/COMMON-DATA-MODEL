package com.dodaso.ecosystem.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "user_messaging_identifiers")
public class UserMessagingIdentifier extends CommonAuditableField {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "login_id", nullable = false, length = 150)
  private String loginId;

  @Column(name = "channel_type", nullable = false, length = 50)
  private String channelType;

  @Column(name = "identifier", nullable = false)
  private String identifier;

  @ColumnDefault("0")
  @Column(name = "verified_ind")
  private Boolean verifiedInd;
}