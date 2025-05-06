package com.futurodev.joinville.m1s11_atividade.mappers;

import com.futurodev.joinville.m1s11_atividade.dtos.organizations.OrganizationRequestDto;
import com.futurodev.joinville.m1s11_atividade.dtos.organizations.OrganizationResponseDto;
import com.futurodev.joinville.m1s11_atividade.entities.Organization;

import java.util.List;

public class OrganizationMapper {

    private OrganizationMapper() {}

    public static OrganizationResponseDto toDto(Organization organization) {
        return OrganizationResponseDto.builder()
                .id(organization.getId())
                .name(organization.getName())
                .contact(organization.getContact())
                .build();
    }

    public static List<OrganizationResponseDto> toDtoList(List<Organization> organizations) {
        return organizations.stream()
                .map(OrganizationMapper::toDto)
                .toList();
    }

    public static Organization toEntity(Organization organization, OrganizationRequestDto organizationDto) {
        organization.setName(organizationDto.getName());
        organization.setContact(organizationDto.getContact());
        return organization;
    }
}
