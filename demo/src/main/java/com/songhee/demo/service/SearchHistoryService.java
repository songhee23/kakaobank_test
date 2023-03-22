package com.songhee.demo.service;

import com.songhee.demo.domain.SearchHistory;
import com.songhee.demo.dto.SearchHistoryDto;
import com.songhee.demo.repository.SearchHistoryRepository;
import java.sql.Timestamp;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SearchHistoryService {

  @Autowired
  SearchHistoryRepository searchHistoryRepository;

  @Transactional
  public SearchHistoryDto insertSearchHistory(String query) {
    SearchHistory SearchHistoryBuilder = SearchHistory.builder()
        .query(query)
        .regDateTime(new Timestamp(System.currentTimeMillis()))
        .build();
    // 검색 이력 등록
    SearchHistory insertSearchHistoryRepository = searchHistoryRepository.save(SearchHistoryBuilder);
    return new SearchHistoryDto(insertSearchHistoryRepository);
  }

  @Transactional(readOnly = true)
  public List<SearchHistoryDto> getTop10SearchHistories() {
    List<SearchHistory> searchHistories = searchHistoryRepository.findTop10ByOrderByRegDateTimeDesc();
    List<SearchHistoryDto> searchHistoryDtos = searchHistories.stream().map(SearchHistoryDto::new).toList();
    return searchHistoryDtos;
  }
}
