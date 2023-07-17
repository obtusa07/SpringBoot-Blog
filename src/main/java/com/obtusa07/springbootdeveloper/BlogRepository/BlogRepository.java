package com.obtusa07.springbootdeveloper.BlogRepository;

import com.obtusa07.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA레포지토리가 제공하는 메서드를 사용하기 위함
public interface BlogRepository extends JpaRepository<Article, Long> {
}
