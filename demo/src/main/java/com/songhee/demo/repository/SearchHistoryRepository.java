package com.songhee.demo.repository;

import com.songhee.demo.domain.SearchHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {

  List<SearchHistory> findTop10ByOrderByRegDateTimeDesc();
}
