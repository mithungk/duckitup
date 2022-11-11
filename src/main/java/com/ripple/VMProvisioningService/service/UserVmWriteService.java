package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.model.UserVm;

public interface UserVmWriteService {
    ResponseData persistUserVm(UserVm userVm);
}
