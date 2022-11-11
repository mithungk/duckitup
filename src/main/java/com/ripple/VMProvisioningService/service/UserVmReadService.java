package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.data.UserVmData;
import com.ripple.VMProvisioningService.model.UserVm;

public interface UserVmReadService {
    UserVm getUserVmById(final Integer appUserId);
}
