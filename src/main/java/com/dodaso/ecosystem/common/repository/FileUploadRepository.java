package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.FileUpload;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {

    /** Backs FileStorageController's "list files for a given owner" endpoint
     * (e.g. ownerType="STAGED_DOCUMENT", ownerId=<elcm staged_document id>).
     * companyId is included in the lookup, not just ownerType/ownerId --
     * ownerId alone isn't guaranteed globally unique now that this table
     * spans multiple companies (each company's own app schema may well
     * reuse the same id ranges). activeInd=true only -- soft-deleted rows
     * stay in the table but shouldn't show up here. */
    List<FileUpload> findByCompanyIdAndOwnerTypeAndOwnerIdAndActiveIndTrue(
        Long companyId, String ownerType, Long ownerId);
}
