package com.futurodev.joinville.m1s11_atividade.dtos.organizations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationRequestDto {
    private String name;
    private String contact;
}
