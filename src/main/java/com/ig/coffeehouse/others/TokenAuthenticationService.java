package com.riskblock.theinstitutes.security.jwt;

import com.riskblock.theinstitutes.model.MemberFirmModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class TokenAuthenticationService {

    private long expirationTime = 3600000;
    private String secret = "ThisIsASecret";
    private String tokenPrefix = "Bearer";
    private String headerString = "Authorization";

    public void addAuthentication(HttpServletResponse response, String user) {

        String jwt = Jwts.builder()
                .setSubject(user)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .claim("memberFirm", MemberFirmModel.getMemberFirm())
                .claim("policyNo", MemberFirmModel.getPolicyNo())
                .claim("userType", MemberFirmModel.getUserType())
                .claim("user", MemberFirmModel.getUserName())
                .claim("producerName", MemberFirmModel.getProducerName())
                .compact();
        response.addHeader(headerString, tokenPrefix + " " + jwt);
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(headerString);
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token.split(" ")[1])
                    .getBody()
                    .getSubject();

            final Claims claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token.split(" ")[1])
                    .getBody();

            if (user != null) {
                String memberFirm = claims.get("memberFirm", String.class);
                String policyNo = claims.get("policyNo", String.class);
                String userType = claims.get("userType", String.class);
                String userName = claims.get("user", String.class);
                String producerName = claims.get("producerName", String.class);
                MemberFirmModel.setMemberFirm(memberFirm);
                MemberFirmModel.setPolicyNo(policyNo);
                MemberFirmModel.setUserType(userType);
                MemberFirmModel.setUserName(userName);
                MemberFirmModel.setProducerName(producerName);
                return new AuthenticatedUser(user);
            }
        }
        return null;
    }
}
