package com.songhee.demo.service;

import com.songhee.demo.common.code.ErrorCode;
import com.songhee.demo.common.code.SortCode;
import com.songhee.demo.common.error.exception.BusinessException;
import com.songhee.demo.domain.Blog;
import com.songhee.demo.dto.BlogDto;
import com.songhee.demo.repository.BlogRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class BlogService {

  @Autowired
  BlogRepository blogRepository;

  @Transactional(readOnly = true)
  public Page<BlogDto> searchManager(SortCode sortCode, String query, Integer size, Integer page) {
    PageRequest pageRequest = PageRequest.of(page, size);
    Page<Blog> blogs;

    if(SortCode.Accuracy == sortCode) {
      // 정확도순 -> id_Blog asc
      blogs = blogRepository.findByTitleContainingOrderByIdBlogAsc(query, pageRequest);
    } else {
      // 발간일순 -> reg_date_time desc
      blogs = blogRepository.findByTitleContainingOrderByRegDateTimeDesc(query, pageRequest);
    }
    if (blogs.getTotalPages() == 0) {
      throw new BusinessException(ErrorCode.NO_SEARCHED_BLOG);
    }
    return blogs.map(BlogDto::new);
  }
}
