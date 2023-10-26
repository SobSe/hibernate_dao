package ru.sobse.hibernate_dao.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerMethodSecurity {
    @GetMapping("/read")
    @Secured("ROLE_READ")
    public String read() {
        return "READ";
    }

    @GetMapping("/write")
    @RolesAllowed("WRITE")
    public String write() {
        return "WRITE";
    }

    @GetMapping("/has-any-role")
    @PreAuthorize("hasAnyRole('READ', 'WRITE')")
    public String hasOneRole() {
        return "HAS ANY ROLE";
    }

    @GetMapping("/user-data")
    @PreAuthorize("#userName == authentication.name")
    public String userData(@RequestParam(name = "username") String userName) {
        return userName;
    }
}
