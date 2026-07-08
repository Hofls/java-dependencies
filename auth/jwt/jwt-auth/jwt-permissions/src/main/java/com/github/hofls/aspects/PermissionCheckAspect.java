package com.github.hofls.aspects;

import com.github.hofls.jwt.JwtService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Component
@Aspect
public class PermissionCheckAspect {

    @Before("@annotation(requiresPermission)")
    public void checkPrivilege(RequiresPermission requiresPermission) {
        JwtService.checkPermission(requiresPermission.value());
    }

}