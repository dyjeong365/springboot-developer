package me.dyjeong365.springbootdeveloper.repository;

import me.dyjeong365.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
