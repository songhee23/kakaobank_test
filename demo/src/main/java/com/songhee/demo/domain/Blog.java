package com.songhee.demo.domain;

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
@Table(name = "blog")
public class Blog extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idBlog", length = 11, nullable = false)
  private Integer idBlog;

  // 블로그 글 제목
  @Column(name = "title", length = 800)
  private String title;

  // 블로그 글 요약
  @Column(name = "contents", length = 3000)
  private String contents;

  // 블로그 글 URL
  @Column(name = "url", length = 2000)
  private String url;

  // 블로그의 이름
  @Column(name = "blogName", length = 2000)
  private String blogName;

  // 검색 시스템에서 추출한 대표 미리보기 이미지 URL, 미리보기 크기 및 화질은 변경될 수 있음
  @Column(name = "thumbnail", length = 2000)
  private String thumbnail;

}
