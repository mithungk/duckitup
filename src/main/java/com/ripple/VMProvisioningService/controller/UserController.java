package com.ripple.VMProvisioningService.controller;

import com.ripple.VMProvisioningService.data.ResponseData;
import com.ripple.VMProvisioningService.model.AppUser;
import com.ripple.VMProvisioningService.repository.AppUserRepository;
import com.ripple.VMProvisioningService.service.AppUserWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("appUser")
@RequiredArgsConstructor
public class UserController {
    private final AppUserWriteService appUserWriteService;
    private final AppUserRepository appUserRepository;

    @PostMapping("signUp")
    public ResponseData createAppUser(@RequestBody final AppUser appUser){
        return this.appUserWriteService.saveAppUser(appUser);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseData retrieveAppUsers(){
        List<AppUser> appUser = this.appUserRepository.findAll();
        return new ResponseData(HttpStatus.OK.value(),"List of all users", appUser);
    }

    @DeleteMapping("{appUserId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseData deleteAppUsers(@PathVariable final Integer appUserId){
        this.appUserRepository.deleteById(Long.valueOf(appUserId));
        return new ResponseData(HttpStatus.OK.value(),"Deleted", appUserId);
    }

}
