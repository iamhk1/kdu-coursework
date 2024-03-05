package org.example.service;

import org.example.entity.Tenant;
import org.example.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {
    TenantRepository tenantRepository;
    @Autowired
    public TenantService(TenantRepository tenantRepository)
    {
        this.tenantRepository=tenantRepository;
    }
    public void addTenant(Tenant tenant)
    {
        tenantRepository.save(tenant);
    }
}
