package com.ripple.VMProvisioningService.controller;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.model.UserVm;
import com.ripple.VMProvisioningService.repository.UserVMRepository;
import com.ripple.VMProvisioningService.service.UserVmReadService;
import com.ripple.VMProvisioningService.service.UserVmWriteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("vm")
@RequiredArgsConstructor
public class VMProvisioningResourceController {

    private final UserVmWriteService userVmWriteService;

    private final UserVmReadService userVmReadService;

    private final UserVMRepository userVMRepository;

    @PostMapping("{appUserId}")
    public ResponseData createUserVM(@PathVariable final Integer appUserId , @RequestBody final UserVm userVm){
        log.info("CreteUserVM API invoked");

        ResponseData response =  this.userVmWriteService.persistUserVm(userVm);

        return response;
    }

    @GetMapping("{appUserId}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseData getUserVM(@PathVariable final Integer appUserId){
        log.info("getUserVM API invoked");
        UserVm userVm= userVMRepository.findByAppUser(appUserId);
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), "fetch success", userVm);
        return responseData;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseData getAllUserVM(){
        log.info("get ALL UserVM API invoked");
        List<UserVm> userVmList= userVMRepository.findAll();
        ResponseData responseData = new ResponseData(HttpStatus.OK.value(), "fetch All success", userVmList);
        return responseData;
    }

}
