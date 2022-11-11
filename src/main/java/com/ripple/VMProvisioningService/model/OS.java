package com.ripple.VMProvisioningService.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vm_os")
@Getter
@Setter
public class OS {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "os_name", nullable = false, length = 100)
    private String osName;
}
