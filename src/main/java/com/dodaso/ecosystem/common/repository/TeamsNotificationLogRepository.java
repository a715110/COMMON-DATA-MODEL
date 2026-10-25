package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.TeamsNotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** ADDED 2026-10-23. Log and duplicate check for Teams notifications. */
@Repository
public interface TeamsNotificationLogRepository extends JpaRepository<TeamsNotificationLog, Long> {

  boolean existsByEventKeyAndStatus(String eventKey, String status);
}
