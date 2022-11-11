package com.ripple.VMProvisioningService.data;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserVmData {
    private Long id;

    private Integer appUser;

    private Integer os;

    private Integer ram;

    private Integer hardDisk;

    private Integer cpuCores;
}
