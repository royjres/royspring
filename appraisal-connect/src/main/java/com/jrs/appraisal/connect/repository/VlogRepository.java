package com.jrs.appraisal.connect.repository;

import com.jrs.appraisal.connect.model.Vlog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VlogRepository extends JpaRepository<Vlog, String>  {

    List<Vlog> findByVlogFileId(String vlogFileId);
}
