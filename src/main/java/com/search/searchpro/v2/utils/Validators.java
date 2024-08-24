package com.search.searchpro.v2.utils;

import org.springframework.data.domain.Sort;

import io.micrometer.common.util.StringUtils;

public class Validators {
  
  public static Sort buildSort(String sortBy, String sortDir) {
		if (StringUtils.isNotBlank(sortBy)) {
	        return (sortDir != null && !sortDir.trim().isEmpty() && sortDir.equalsIgnoreCase("asc")) ?
	                Sort.by(sortBy).ascending() :
	                Sort.by(sortBy).descending();
	    } else {
	        return Sort.by(sortBy).ascending();
	    }
    }

}
