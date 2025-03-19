package com.stl.site_news.repositories;

import com.stl.site_news.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository  extends CrudRepository<Post, Long> {

}
