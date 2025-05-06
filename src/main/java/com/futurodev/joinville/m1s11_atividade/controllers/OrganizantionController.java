package com.futurodev.joinville.m1s11_atividade.controllers;

import com.futurodev.joinville.m1s11_atividade.dtos.organizations.OrganizationRequestDto;
import com.futurodev.joinville.m1s11_atividade.dtos.organizations.OrganizationResponseDto;
import com.futurodev.joinville.m1s11_atividade.services.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("organizations")
public class OrganizantionController {

    private final OrganizationService organizationService;

    @GetMapping
    public List<OrganizationResponseDto> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @PostMapping
    public OrganizationResponseDto createOrganization(@RequestBody OrganizationRequestDto organizationDto) {
        return organizationService.createOrganization(organizationDto);
    }

    @PutMapping("/{id}")
    public OrganizationResponseDto updateOrganization(@PathVariable Long id, @RequestBody OrganizationRequestDto organizationDto) {
        return organizationService.updateOrganization(id, organizationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
    }
}
