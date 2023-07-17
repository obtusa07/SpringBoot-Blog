package com.obtusa07.springbootdeveloper.dto;

import com.obtusa07.springbootdeveloper.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * The type Add article request.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    /**
     * To entity article.
     * 생성자를 이용해 객체 생성 コンストラクターを利用してオブジェクトを生成
     * DTO　to Entity
     * @return the article
     */
    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
