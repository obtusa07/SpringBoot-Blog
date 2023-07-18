package com.obtusa07.springbootdeveloper.controller;

import com.obtusa07.springbootdeveloper.domain.Article;
import com.obtusa07.springbootdeveloper.dto.AddArticleRequest;
import com.obtusa07.springbootdeveloper.dto.ArticleResponse;
import com.obtusa07.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Blog api controller.
 */
@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON으로 반환하는 컨트롤러
public class BlogApiController {
    private final BlogService blogService;

    /**
     * Add article response entity.
     * 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
     * @param request the request
     * @return the response entity
     */
    @PostMapping("/api/articles")

    // @RequestBody로 요청 본문 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);
        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }
}
