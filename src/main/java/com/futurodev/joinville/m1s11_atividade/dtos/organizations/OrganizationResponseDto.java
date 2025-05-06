package com.futurodev.joinville.m1s11_atividade.dtos.organizations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationResponseDto {
    private Long id;
    private String name;
    private String contact;
}
