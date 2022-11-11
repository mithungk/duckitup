package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.model.UserVm;
import com.ripple.VMProvisioningService.repository.UserVMRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserVmWriteServiceImpl implements UserVmWriteService{
    private final UserVMRepository userVMRepository;

    @Override
    public ResponseData persistUserVm(UserVm userVm) {
        try {
            UserVm user = this.userVMRepository.save(userVm);
            return new ResponseData(HttpStatus.OK.value(),"success", user);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "error");
        }
    }
}
