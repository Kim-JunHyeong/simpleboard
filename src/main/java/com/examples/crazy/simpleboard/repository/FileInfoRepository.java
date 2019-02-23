package com.examples.crazy.simpleboard.repository;

import com.examples.crazy.simpleboard.domain.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
}
