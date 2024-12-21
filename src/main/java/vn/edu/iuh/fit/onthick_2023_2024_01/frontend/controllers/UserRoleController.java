package vn.edu.iuh.fit.onthick_2023_2024_01.frontend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {

    @GetMapping("/api/user/role")
    public ResponseEntity<String> getUserRole(Authentication authentication) {
        if (authentication != null) {
            return ResponseEntity.ok(authentication.getAuthorities().stream()
                    .findFirst()
                    .map(GrantedAuthority::getAuthority)
                    .orElse("ROLE_ANONYMOUS"));
        }
        return ResponseEntity.ok("ROLE_ANONYMOUS");
    }
}
