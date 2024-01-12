package me.dyjeong365.springbootdeveloper.config.error.exception;

import me.dyjeong365.springbootdeveloper.config.error.ErrorCode;

public class ArticleNotFoundException extends NotFoundException{
    public ArticleNotFoundException() {
        super(ErrorCode.ARTICLE_NOT_FOUND);
    }
}
