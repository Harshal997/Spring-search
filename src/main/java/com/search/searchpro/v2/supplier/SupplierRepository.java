package com.search.searchpro.v2.supplier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.search.searchpro.v2.supplier.domain.Suppliers;

@Repository
public interface SupplierRepository extends JpaRepository<Suppliers, Long> {

  @Query(value = "SELECT * FROM Suppliers " +
    "WHERE " +
    "(:companyName IS NULL OR company_name ILIKE CONCAT('%', :companyName, '%')) AND " +
    "(:location IS NULL OR location ILIKE CONCAT('%', :location, '%')) AND " +
    "(:manufacturingProcesses IS NULL OR manufacturing_processes ILIKE CONCAT('%', :manufacturingProcesses, '%')) AND " +
    "(:natureOfBusiness IS NULL OR nature_of_business ILIKE CONCAT('%', :natureOfBusiness, '%'))",
    nativeQuery = true)
Page<Suppliers> fetchSuppliers(
    @Param("companyName") String companyName,
    @Param("location") String location,
    @Param("manufacturingProcesses") String manufacturingProcesses,
    @Param("natureOfBusiness") String natureOfBusiness,
    Pageable pageable);

}
