package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.DocumentConversion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Mirrors FileThumbnailRepository -- one current-state DocumentConversion
 * row per FileUpload (uq_document_conversion_file_upload), looked up by
 * the owning FileUpload's id.
 */
public interface DocumentConversionRepository extends JpaRepository<DocumentConversion, Long> {

    Optional<DocumentConversion> findByFileUpload_Id(Long fileUploadId);
}
