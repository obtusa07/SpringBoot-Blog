package com.obtusa07.springbootdeveloper.service;

import com.obtusa07.springbootdeveloper.BlogRepository.BlogRepository;
import com.obtusa07.springbootdeveloper.domain.Article;
import com.obtusa07.springbootdeveloper.dto.AddArticleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The type Blog service.
 */
@RequiredArgsConstructor // final or @NotNull 필드 생성자 추가 フィールどコンストラクターの追加
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    /**
     * Save article.
     *
     * @param request the request
     * @return the article
     */
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
