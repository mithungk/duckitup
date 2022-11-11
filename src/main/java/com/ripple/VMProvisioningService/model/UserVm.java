package com.ripple.VMProvisioningService.model;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "user_vm")
@Getter
@Setter
public class UserVm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "app_user_id", nullable = false, length = 100)
    private Integer appUser;

    @Column(name = "vm_os_id", nullable = false, length = 100)
    private Integer os;

    @Column(name = "vm_ram_id", nullable = false, length = 100)
    private Integer ram;

    @Column(name = "vm_hard_disk_id", nullable = false, length = 100)
    private Integer hardDisk;

    @Column(name = "vm_cpu_cores_id", nullable = false, length = 100)
    private Integer cpuCores;

}
