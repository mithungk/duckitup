package com.ripple.VMProvisioningService.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtHelper {
    private final RSAPrivateKey rsaPrivateKey;
    private final RSAPublicKey rsaPublicKey;

    public String createJwtForClaims(String subject, Map<String, String> claims) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Instant.now().toEpochMilli());
        calendar.add(Calendar.DATE, 1);

        JWTCreator.Builder jwtBuilder = JWT.create().withSubject(subject);

        claims.forEach(jwtBuilder::withClaim);

        return jwtBuilder.withNotBefore(new Date()).withExpiresAt(calendar.getTime()).sign(Algorithm.RSA256(rsaPublicKey, rsaPrivateKey));
    }

}
