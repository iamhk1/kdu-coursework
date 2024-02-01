package org.example.controller;

import org.example.entity.Tenant;
import org.example.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantController {
    TenantService tenantService;
    @Autowired
    public TenantController(TenantService tenantService)
    {
        this.tenantService=tenantService;
    }
    @PostMapping("/tenant")
    public ResponseEntity<String> addShiftUser(@RequestBody Tenant tenant)
    {
        tenantService.addTenant(tenant);
        return ResponseEntity.ok("ShiftUser Added Successfully");
    }
}
