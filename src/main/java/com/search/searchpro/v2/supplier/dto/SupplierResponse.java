package com.search.searchpro.v2.supplier.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.search.searchpro.v2.supplier.ManufacturingProcesses;
import com.search.searchpro.v2.supplier.NatureOfBusiness;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SupplierResponse {

    private Long supplierId;

    private String companyName;

    private String website;

    private String location;

    private NatureOfBusiness natureOfBusiness;

    private ManufacturingProcesses manufacturingProcesses;
  
}
