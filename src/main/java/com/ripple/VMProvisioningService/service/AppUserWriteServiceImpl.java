package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.model.AppUser;
import com.ripple.VMProvisioningService.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class AppUserWriteServiceImpl implements AppUserWriteService {

    private final AppUserRepository appUserRepository;

    @Override
    public ResponseData saveAppUser(AppUser appUser) {
        try {
            AppUser user = this.appUserRepository.save(appUser);
            return new ResponseData(HttpStatus.OK.value(), "User saved successfully", user);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to create user");
        }
    }
}
