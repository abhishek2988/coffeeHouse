package com.riskblock.theinstitutes.service.impl;

import com.riskblock.theinstitutes.model.MemberFirmModel;
import com.riskblock.theinstitutes.model.UsersModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AppUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {

        UsersModel usersModel = new UserService().getUserDetails(user);
        MemberFirmModel.setMemberFirm(usersModel.getMemberFirm());
        MemberFirmModel.setPolicyNo(usersModel.getPolicyNo());
        MemberFirmModel.setUserType(usersModel.getUserType());
        MemberFirmModel.setUserName(usersModel.getUser());
        MemberFirmModel.setProducerName(usersModel.getProducerName());

        return org.springframework.security.core.userdetails.User
                .withUsername(user)
                .password(usersModel.getPassword())
                .authorities(Collections.emptyList())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();

    }
}
