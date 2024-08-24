package com.search.searchpro.v2.utils;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PageResponse {
    private List<?> content;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;
    private String searchCount;
}
