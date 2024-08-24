package com.search.searchpro.v2.supplier;

import java.util.List;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.search.searchpro.v2.supplier.domain.Suppliers;
import com.search.searchpro.v2.supplier.dto.SupplierRequest;
import com.search.searchpro.v2.supplier.dto.SupplierResponse;
import com.search.searchpro.v2.utils.PageResponse;
import com.search.searchpro.v2.utils.Validators;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SupplierService {

  // private final ModelMapper modelMapper;

  private final SupplierRepository supplierRepository;

  public PageResponse getSuppliers(SupplierRequest supplierRequest, String startingIndex, String rows, String sortBy, String sortDir) {
    log.info("Inside getSuppliers:Service");
    String companyName = supplierRequest.getCompanyName();
    String location = supplierRequest.getLocation();
    String manufacturingProcess = supplierRequest.getManufacturingProcesses();
    String natureOfBusiness = supplierRequest.getNatureOfBusiness();

    PageResponse pageResponse = new PageResponse();
    Page<Suppliers> sPage = null;
    int starting = Integer.parseInt(startingIndex) - 1;
    int maxRows = Integer.parseInt(rows);
    int pageCount = starting / maxRows;

    Sort sort = Validators.buildSort(sortBy, sortDir);

    Pageable pageable = PageRequest.of(pageCount, maxRows, sort);

    sPage = supplierRepository.fetchSuppliers(companyName, location, manufacturingProcess, natureOfBusiness, pageable);

    // List<SupplierResponse> supplierResponses = new ArrayList<>();

    // for(Suppliers suppliers: sPage) {
    //   supplierResponses.add(modelMapper.map(suppliers, SupplierResponse.class));
    // }

    pageResponse.setContent(sPage.toList());
        pageResponse.setCurrentPage(sPage.getNumber());
        // if (search != null && !search.trim().isEmpty()) {
        //     pageResponse.setSearchCount(String.valueOf(sPage.getNumberOfElements()));
        // }
        pageResponse.setTotalItems(sPage.getTotalElements());
        pageResponse.setTotalPages(sPage.getTotalPages());

        return pageResponse;
    
  }
  
}
