package com.obtusa07.springbootdeveloper.service;

import com.obtusa07.springbootdeveloper.BlogRepository.BlogRepository;
import com.obtusa07.springbootdeveloper.domain.Article;
import com.obtusa07.springbootdeveloper.dto.AddArticleRequest;
import com.obtusa07.springbootdeveloper.dto.UpdateArticleRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional // Transaction method
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
