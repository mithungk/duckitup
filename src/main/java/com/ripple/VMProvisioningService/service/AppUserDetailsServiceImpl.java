package com.ripple.VMProvisioningService.service;

import com.ripple.VMProvisioningService.model.AppUser;
import com.ripple.VMProvisioningService.repository.AppUserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = this.appUserRepository.findByUsername(username);
        if(appUser == null){
            throw new UsernameNotFoundException("Error: Could not find the user.");
        }
        return new AppUserDetails(appUser);
    }
}
