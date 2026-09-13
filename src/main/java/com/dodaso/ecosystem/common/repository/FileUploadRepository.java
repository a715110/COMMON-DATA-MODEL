package com.dodaso.ecosystem.common.repository;

import com.dodaso.ecosystem.common.entity.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {
}
