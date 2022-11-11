package com.ripple.VMProvisioningService.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vm_hard_disk")
@Getter
@Setter
public class HardDisk {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "hard_disk_size", nullable = false, length = 100)
    private String hardDiskSize;
}
