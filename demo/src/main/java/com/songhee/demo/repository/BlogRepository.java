package com.songhee.demo.repository;


import com.songhee.demo.domain.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

  Page<Blog> findByTitleContainingOrderByRegDateTimeDesc(String keyword, Pageable pageable);

  Page<Blog> findByTitleContainingOrderByIdBlogAsc(String keyword, Pageable pageable);
}
