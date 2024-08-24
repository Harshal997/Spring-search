package com.search.searchpro.v2.supplier.domain;

import com.search.searchpro.v2.supplier.ManufacturingProcesses;
import com.search.searchpro.v2.supplier.NatureOfBusiness;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "suppliers")
@Data
@RequiredArgsConstructor
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "website")
    private String website;

    @Column(name = "location", nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "nature_of_business", nullable = false)
    private NatureOfBusiness natureOfBusiness;

    @Enumerated(EnumType.STRING)
    @Column(name = "manufacturing_processes", nullable = false)
    private ManufacturingProcesses manufacturingProcesses;
}