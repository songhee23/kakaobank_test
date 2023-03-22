package com.songhee.demo.dto;

import com.songhee.demo.common.code.UseYn;
import com.songhee.demo.domain.Blog;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BlogDto extends BaseTimeDto {

  private Integer idBlog;
  private String title;
  private String contents;
  private String url;
  private String blogName;
  private String thumbnail;
  private UseYn useYn;
  private Timestamp regDateTime;
  private Timestamp modDateTime;

  public BlogDto(Blog blog) {
    this.idBlog = blog.getIdBlog();
    this.title = blog.getTitle();
    this.contents = blog.getContents();
    this.url = blog.getUrl();
    this.thumbnail = blog.getThumbnail();
    this.useYn = blog.getUseYn();
    this.blogName = blog.getBlogName();
    this.regDateTime = blog.getRegDateTime();
    this.modDateTime = blog.getModDateTime();
  }

  public Blog toEntity() {
    return Blog.builder()
        .idBlog(idBlog)
        .title(title)
        .contents(contents)
        .url(url)
        .blogName(blogName)
        .thumbnail(thumbnail)
        .regDateTime(regDateTime)
        .modDateTime(modDateTime)
        .useYn(useYn)
        .build();
  }
}
