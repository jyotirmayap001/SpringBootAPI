package com.HostelManagement.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HostelManagement.api.Model.HostelModel;

@Repository
public interface HostelManagementRepo extends JpaRepository<HostelModel,Integer>{


}
