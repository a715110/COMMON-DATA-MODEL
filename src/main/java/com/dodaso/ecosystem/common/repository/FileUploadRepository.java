package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.FileUpload;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {

    /** Backs FileStorageController's "list files for a given owner" endpoint
     * (e.g. ownerType="STAGED_DOCUMENT", ownerId=<elcm staged_document id>).
     * activeInd=true only -- soft-deleted rows stay in the table but
     * shouldn't show up here. */
    List<FileUpload> findByOwnerTypeAndOwnerIdAndActiveIndTrue(String ownerType, Long ownerId);
}
