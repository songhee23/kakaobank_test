package com.songhee.demo.dto;

import com.songhee.demo.common.code.DefaultValues;
import com.songhee.demo.common.code.UseYn;
import com.songhee.demo.common.utils.DateTimeUtil;
import com.songhee.demo.domain.Blog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BlogDto {

  private Integer idBlog;
  private String title;
  private String contents;
  private String url;
  private String blogName;
  private String thumbnail;
  private UseYn useYn;
  private String regDateTime;
  private String modDateTime;

  public BlogDto(Blog blog) {
    this.idBlog = blog.getIdBlog();
    this.title = blog.getTitle();
    this.contents = blog.getContents();
    this.url = blog.getUrl();
    this.thumbnail = blog.getThumbnail();
    this.useYn = blog.getUseYn();
    this.blogName = blog.getBlogName();
    this.regDateTime = DateTimeUtil.convert_ISO_8601(blog.getRegDateTime(), DefaultValues.TIME_ZONE_ASIA_SEOUL);
    this.modDateTime = DateTimeUtil.convert_ISO_8601(blog.getModDateTime(), DefaultValues.TIME_ZONE_ASIA_SEOUL);
  }

  public Blog toEntity() {
    return Blog.builder()
        .idBlog(idBlog)
        .title(title)
        .contents(contents)
        .url(url)
        .blogName(blogName)
        .thumbnail(thumbnail)
        .regDateTime(DateTimeUtil.convert_date(this.getRegDateTime()))
        .modDateTime(DateTimeUtil.convert_date(this.getModDateTime()))
        .useYn(useYn)
        .build();
  }
}
