package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.PerfIncident;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/** ADDED 2026-11-12. Perf incidents: filtered lists use Specifications, the summary one query. */
public interface PerfIncidentRepository
    extends JpaRepository<PerfIncident, Long>, JpaSpecificationExecutor<PerfIncident> {

  /** One line of the "calls that use the most CPU" summary. */
  interface TopCallRow {
    String getClassName();

    String getMethodName();

    long getIncidents();

    long getTotalOwnCpuMs();

    long getMaxOwnWallMs();
  }

  /** Calls grouped by class and method since a time, most own CPU first. JVM readings excluded. */
  @Query("SELECT i.className AS className, i.methodName AS methodName, COUNT(i) AS incidents, "
      + "COALESCE(SUM(i.ownCpuMs), 0) AS totalOwnCpuMs, COALESCE(MAX(i.ownWallMs), 0) AS maxOwnWallMs "
      + "FROM PerfIncident i WHERE i.occurredAt >= :since AND i.className <> 'JVM' "
      + "GROUP BY i.className, i.methodName "
      + "ORDER BY COALESCE(SUM(i.ownCpuMs), 0) DESC, COUNT(i) DESC")
  List<TopCallRow> topCalls(@Param("since") LocalDateTime since, Pageable page);

  /** Removes incidents older than the cutoff and returns how many. */
  long deleteByOccurredAtBefore(LocalDateTime cutoff);
}
