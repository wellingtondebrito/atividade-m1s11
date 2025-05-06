package com.futurodev.joinville.m1s11_atividade.services;

import com.futurodev.joinville.m1s11_atividade.dtos.organizations.OrganizationRequestDto;
import com.futurodev.joinville.m1s11_atividade.dtos.organizations.OrganizationResponseDto;
import com.futurodev.joinville.m1s11_atividade.entities.Organization;

import com.futurodev.joinville.m1s11_atividade.mappers.OrganizationMapper;

import com.futurodev.joinville.m1s11_atividade.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public List<OrganizationResponseDto> getAllOrganizations() {
        List<Organization> organizations = organizationRepository.findAll();
        return OrganizationMapper.toDtoList(organizations);
    }

    @Override
    public OrganizationResponseDto getOrganizationById(Long id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found"));
        return OrganizationMapper.toDto(organization);
    }


    @Override
    public OrganizationResponseDto createOrganization(OrganizationRequestDto organizationDto) {
        Organization organization = new Organization();
        OrganizationMapper.toEntity(organization, organizationDto);

        organization = organizationRepository.save(organization);
        return OrganizationMapper.toDto(organization);
    }

    @Override
    public OrganizationResponseDto updateOrganization(Long id, OrganizationRequestDto organizationDto) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found"));
        OrganizationMapper.toEntity(organization, organizationDto);
        organizationRepository.save(organization);
        return OrganizationMapper.toDto(organization);
    }

    @Override
    public void deleteOrganization(Long id) {
        Organization organization = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found"));
        organizationRepository.delete(organization);
    }
}
