package com.songhee.demo.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "searchHistory")
public class SearchHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idSearchHistory", length = 11, nullable = false)
  private Integer idSearchHistory;

  // 검색어
  @Column(name = "query", length = 3000)
  private String query;

  // 검색 등록일
  @Column(name="regDateTime", columnDefinition = "TIMESTAMP", updatable = false)
  private Timestamp regDateTime;
}
