package com.songhee.demo.controller;

import com.songhee.demo.common.code.SortCode;
import com.songhee.demo.common.wrapper.Result;
import com.songhee.demo.dto.BlogDto;
import com.songhee.demo.service.BlogService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/test")
public class TestApiController {

	@Autowired
	BlogService blogService;

	@GetMapping("/search/blog")
	@Operation(summary = "블로그 검색하기", description = "블로그 검색하기")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "query", value = "검색을 원하는 질의어 - 특정 블로그 글만 검색하고 싶은 경우, 블로그 url과 검색어를 공백(' ') 구분자로 넣을 수 있음", required = true),
		@ApiImplicitParam(name = "sort", value = "결과 문서 정렬 방식, accuracy(정확도순) 또는 latest(발간일순), 기본값 accuracy\t", required = false),
		@ApiImplicitParam(name = "page", value = "결과 페이지 번호, 1~50 사이의 값, 기본 값 1", required = false),
		@ApiImplicitParam(name = "size", value = "한 페이지에 보여질 문서 수, 1~50 사이의 값, 기본 값 10", required = false),
	})
	public Result<Page<BlogDto>> searchBlog(
			@RequestParam("query") String query,
			@RequestParam(value = "sort", required = false, defaultValue = "accuracy") String sort,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {

		SortCode sortCode = SortCode.find(sort);
		Page<BlogDto> blogDtos = blogService.searchManager(sortCode, query, size, page);
		return Result.<Page<BlogDto>>builder()
			.result(blogDtos)
			.build();
	}

}
