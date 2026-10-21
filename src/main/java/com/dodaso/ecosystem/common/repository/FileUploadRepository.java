package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.FileUpload;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {

    /** Active (non-soft-deleted) files for one owner, scoped to its
     * company -- the standard "list files attached to this record" query
     * used by both ECWS (Comment tab / File Attachment tab) and ELCM. */
    List<FileUpload> findByCompanyIdAndOwnerTypeAndOwnerIdAndActiveIndTrue(
        Long companyId, String ownerType, Long ownerId);

    /**
     * ADDED 2026-10-21 (purge job). The source apps that have at least one soft-deleted
     * file, so the retention rule of each app can be applied on its own.
     */
    @Query("SELECT DISTINCT f.sourceApp FROM FileUpload f WHERE f.activeInd = false")
    List<String> findSourceAppsWithSoftDeleted();

    /**
     * ADDED 2026-10-21 (purge job). Soft-deleted files of one source app that were last
     * changed before the cutoff, oldest first. updated_at is the time of the soft delete,
     * because the delete is the last change a deleted file ever gets.
     */
    List<FileUpload> findByActiveIndFalseAndSourceAppAndUpdatedAtBeforeOrderByIdAsc(
        String sourceApp, LocalDateTime cutoff, Pageable pageable);
}
