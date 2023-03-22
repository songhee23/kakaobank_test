package com.songhee.demo.controller;

import com.songhee.demo.common.wrapper.Result;
import com.songhee.demo.service.TestService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/test")
public class TestApiController {

	@Autowired
	TestService testService;

	@PostMapping("/search")
	@Operation(summary = "검색", description = "검색")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "searchWord", value = "검색어", required = true),
	})
	public Result<Object> sumPoint(@RequestParam("searchWord") Integer searchWord) {
		return Result.<Object>builder()
			.result(null)
			.build();
	}
}
