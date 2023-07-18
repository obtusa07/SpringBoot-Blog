package com.obtusa07.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The type Article.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //デフォルト コンストラクター
public class Article {
    @Id //　기본키 지정 プライマリーキー
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가 プライマリーキーを自動的に１ずつ増加
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    /**
     * Instantiates a new Article.
     *
     * @param title   the title
     * @param content the content
     */
    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
