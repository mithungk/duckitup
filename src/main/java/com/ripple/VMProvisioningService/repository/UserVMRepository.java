package com.ripple.VMProvisioningService.repository;

import com.ripple.VMProvisioningService.model.UserVm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVMRepository extends JpaRepository<UserVm, Long> {

    UserVm findByAppUser(Integer appUserId);
}
