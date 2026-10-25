package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.SystemMessagingConfig;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemMessagingConfigRepository extends JpaRepository<SystemMessagingConfig, Integer> {

  /**
   * Find all active/enabled messaging configurations ordered by priority
   */
  List<SystemMessagingConfig> findByActiveIndTrueOrderByPriorityAsc();

  /**
   * Find all configurations ordered by priority
   */
  List<SystemMessagingConfig> findAllByOrderByPriorityAsc();

  /**
   * Find configuration by channel type
   */
  Optional<SystemMessagingConfig> findByChannelType(String channelType);

  /**
   * Check if channel type already exists
   */
  boolean existsByChannelType(String channelType);

  /**
   * Find active configuration by channel type
   */
  Optional<SystemMessagingConfig> findByChannelTypeAndActiveIndTrue(String channelType);

  /**
   * Count active configurations
   */
  long countByActiveIndTrue();

  /**
   * Get maximum priority value
   */
  @Query("SELECT COALESCE(MAX(s.priority), 0) FROM SystemMessagingConfig s")
  Integer findMaxPriority();
}