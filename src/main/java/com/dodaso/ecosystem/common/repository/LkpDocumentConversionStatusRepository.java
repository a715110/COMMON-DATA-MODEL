package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.LkpDocumentConversionStatus;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LkpDocumentConversionStatusRepository extends JpaRepository<LkpDocumentConversionStatus, Long> {

    /** Same convention as LkpThumbnailStatusRepository.findByCode() --
     * application code branches on seeded codes (PENDING/PROCESSING/
     * COMPLETED/FAILED), never on DB-generated ids. */
    Optional<LkpDocumentConversionStatus> findByCode(String code);
}
