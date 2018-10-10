package com.riskblock.theinstitutes.security.jwt;


import com.riskblock.theinstitutes.model.ErrorResponseModel;
import com.riskblock.theinstitutes.model.POIErrorConstant;
import com.riskblock.theinstitutes.model.RbUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTAuthenticationFilter extends GenericFilterBean {

    private static Logger log = LogManager.getLogger(JWTAuthenticationFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            Authentication authentication = new TokenAuthenticationService().getAuthentication((HttpServletRequest) servletRequest);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            log.error("JWTAuthenticationFilter::doFilter:JWT Exception Raised" + e);
            ErrorResponseModel errorResponse = new ErrorResponseModel(POIErrorConstant.JWT_ERROR_STATUS, POIErrorConstant.JWT_ERROR_CODE, "JWT Error");
            servletResponse.getWriter().write(RbUtility.convertObjectToJson(errorResponse));
        }
    }
}
