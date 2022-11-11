package com.ripple.VMProvisioningService.data;

import lombok.Data;

@Data
public class ResponseData {
    final Integer responseStatus;
    final String responseMsg;
    final Object data;
}
