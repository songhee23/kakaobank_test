package com.songhee.demo.dto;

import com.songhee.demo.common.code.DefaultValues;
import com.songhee.demo.common.code.UseYn;
import com.songhee.demo.common.utils.DateTimeUtil;
import com.songhee.demo.domain.Blog;
import com.songhee.demo.domain.SearchHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SearchHistoryDto {

  private Integer idSearchHistory;
  private String query;
  private String regDateTime;

  public SearchHistoryDto(SearchHistory searchHistory) {
    this.idSearchHistory = searchHistory.getIdSearchHistory();
    this.query = searchHistory.getQuery();
    this.regDateTime = DateTimeUtil.convert_ISO_8601(searchHistory.getRegDateTime(), DefaultValues.TIME_ZONE_ASIA_SEOUL);
  }

  public SearchHistory toEntity() {
    return SearchHistory.builder()
        .idSearchHistory(idSearchHistory)
        .query(query)
        .regDateTime(DateTimeUtil.convert_date(this.getRegDateTime()))
        .build();
  }
}
