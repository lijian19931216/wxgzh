package com.wxgzh.entiy;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lijian
 * @create: 2019-08-29
 **/
@XStreamAlias("xml")
public class PictureTextMessage extends Message {
    @XStreamAlias("ArticleCount")
    private String articleCount = "1" ;
    @XStreamAlias("Articles")
    private List<Article> articles = new ArrayList<>();
    public PictureTextMessage(Map<String,Object> map) {
        super(map);
        setMsgType("news");
        setMyArticles();
    }
    public void setMyArticles(){
        Article article = new Article();
        article.setTitle("标题");
        article.setDescription("描述");
        article.setPicUrl("https://www.baidu.com/img/bd_logo1.png?where=super");
        article.setUrl("http://www.baidu.com");
        articles.add(article);
    }



    public String getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
