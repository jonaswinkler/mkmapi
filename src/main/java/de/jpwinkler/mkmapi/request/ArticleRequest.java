package de.jpwinkler.mkmapi.request;

import de.jpwinkler.mkmapi.model.Article;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "request")
public class ArticleRequest {

    private List<Article> article;

    public ArticleRequest() {}

    public ArticleRequest(List<Article> article) {
        this.article = article;
    }

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }
}
