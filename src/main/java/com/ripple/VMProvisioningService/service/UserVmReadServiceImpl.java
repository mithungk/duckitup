package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.data.UserVmData;
import com.ripple.VMProvisioningService.model.UserVm;
import com.ripple.VMProvisioningService.repository.UserVMRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserVmReadServiceImpl implements UserVmReadService{


    @Override
    public UserVm getUserVmById(Integer appUserId) {
        return null;
    }
}
