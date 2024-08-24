package com.search.searchpro.v2.supplier;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.search.searchpro.v2.supplier.dto.SupplierRequest;
import com.search.searchpro.v2.utils.PageResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@Tag(name = "Supplier API")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@Validated
public interface SupplierApi {
  
  @Operation(summary = "Get suppliers", description = "Retrieve a list of suppliers based on search criteria")
  @PostMapping(value = "/supplier/query")
  PageResponse getSuppliers(
    @RequestBody @Valid SupplierRequest supplierRequest,
    @Parameter(description = "Starting Index", required = false, example = "1") @RequestHeader(required = false, defaultValue = "1", name = "starting_index") @Positive(message = "Starting index must be greater than 0.") String startingIndex,
    @Parameter(description = "Max Rows", required = false, example = "10") @RequestHeader(required = false, defaultValue = "5", name = "rows") @Positive(message = "Starting index must be greater than 0.") String rows,
    @Parameter(description = "Sorting By", required = false, example = "company name") @RequestHeader(required = false, defaultValue = "supplier_id", name = "sort_by") String sortBy,
    @Parameter(description = "Sorting through ascending or descending", required = false, example = "asc/desc") @RequestHeader(required = false, defaultValue = "asc", name = "sort_dir") String sortDir
  );
  
}
