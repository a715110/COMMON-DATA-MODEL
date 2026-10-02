package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.FileThumbnail;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileThumbnailRepository extends JpaRepository<FileThumbnail, Long> {

    /** fileUploadId is DB-unique (uq_file_thumbnail_file_upload) -- at most
     * one thumbnail row per file_upload row. Used by the retrieval
     * endpoint to find "the" thumbnail for a given uploaded file. */
    Optional<FileThumbnail> findByFileUpload_Id(Long fileUploadId);
}
