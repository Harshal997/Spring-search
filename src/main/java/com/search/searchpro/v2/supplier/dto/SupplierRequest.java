package com.search.searchpro.v2.supplier.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SupplierRequest {

    @Schema(description = "Name of the supplier company", example = "Acme Corp")
    private String companyName;

    @Schema(description = "Website of the supplier", example = "https://www.acmecorp.com")
    private String website;

    @Schema(description = "City location of the supplier", example = "New York")
    private String location;

    @Schema(description = "Nature of the business", example = "small_scale", allowableValues = {"small_scale", "medium_scale", "large_scale"})
    @Pattern(regexp = "small_scale|medium_scale|large_scale", message = "Invalid nature of business")
    private String natureOfBusiness;

    @Schema(description = "Manufacturing processes used by the supplier", example = "3d_printing", allowableValues = {"moulding", "3d_printing", "casting", "coating"})
    @Pattern(regexp = "moulding|3d_printing|casting|coating", message = "Invalid manufacturing process")
    private String manufacturingProcesses;
}
