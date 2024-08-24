package com.search.searchpro.v2.supplier;

import org.springframework.web.bind.annotation.RestController;

import com.search.searchpro.v2.supplier.dto.SupplierRequest;
import com.search.searchpro.v2.utils.PageResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SupplierController implements SupplierApi{

  private final SupplierService supplierService;

  @Override
  public PageResponse getSuppliers(SupplierRequest supplierRequest, String startingIndex, String rows, String sortBy, String sortDir) {
    log.info("Inside getSuppliers:Controller");
    return supplierService.getSuppliers(supplierRequest, startingIndex, rows, sortBy, sortDir);
  }
  
}
