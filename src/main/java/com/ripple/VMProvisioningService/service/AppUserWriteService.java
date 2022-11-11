package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.model.AppUser;

public interface AppUserWriteService {
    ResponseData saveAppUser(AppUser appUser);
}
