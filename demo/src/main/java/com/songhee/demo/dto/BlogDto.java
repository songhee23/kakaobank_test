package com.songhee.demo.dto;

import com.songhee.demo.domain.Blog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  public BlogDto(Blog blog) {
    this.idBlog = blog.getIdBlog();
    this.title = blog.getTitle();
    this.contents = blog.getContents();
    this.url = blog.getUrl();
    this.thumbnail = blog.getThumbnail();
  }

  public Blog toEntity() {
    return Blog.builder()
        .idBlog(idBlog)
        .title(title)
        .contents(contents)
        .url(url)
        .blogName(blogName)
        .thumbnail(thumbnail)
        .build();
  }
}
