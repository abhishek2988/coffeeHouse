package com.riskblock.theinstitutes.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {


    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException exc) throws IOException {


        Authentication auth
                = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            response.setStatus(HttpStatus.FORBIDDEN.value());

            Map<String, Object> data = new HashMap<>();
            data.put("TimeStamp", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
            data.put("Status", HttpStatus.FORBIDDEN.value());
            data.put("Message", "Access Denied");
            data.put("Path", request.getRequestURL().toString());


            OutputStream out = response.getOutputStream();
            com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, data);
            out.flush();

        }
    }

}
