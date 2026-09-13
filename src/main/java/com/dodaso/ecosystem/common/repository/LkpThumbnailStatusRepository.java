package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.LkpThumbnailStatus;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LkpThumbnailStatusRepository extends JpaRepository<LkpThumbnailStatus, Long> {

    /** Looks up a status row by its seed code (PENDING/PROCESSING/COMPLETED/
     * FAILED per this entity's class Javadoc) rather than a hardcoded id,
     * since ids are DB-generated and not guaranteed stable across
     * environments. */
    Optional<LkpThumbnailStatus> findByCode(String code);
}
