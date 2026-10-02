package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.FileUpload;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {

    /** Active (non-soft-deleted) files for one owner, scoped to its
     * company -- the standard "list files attached to this record" query
     * used by both ECWS (Comment tab / File Attachment tab) and ELCM. */
    List<FileUpload> findByCompanyIdAndOwnerTypeAndOwnerIdAndActiveIndTrue(
        Long companyId, String ownerType, Long ownerId);
}
