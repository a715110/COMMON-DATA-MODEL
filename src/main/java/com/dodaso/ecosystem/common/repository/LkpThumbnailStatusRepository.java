package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.LkpThumbnailStatus;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LkpThumbnailStatusRepository extends JpaRepository<LkpThumbnailStatus, Long> {

    /**
     * Looks up a status row by its seeded code (PENDING/PROCESSING/COMPLETED/
     * FAILED). Codes, not ids, are what application code should ever branch
     * on -- ids are DB-generated and not guaranteed stable across
     * environments.
     */
    Optional<LkpThumbnailStatus> findByCode(String code);
}
