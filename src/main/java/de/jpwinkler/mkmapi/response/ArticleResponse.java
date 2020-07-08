package de.jpwinkler.mkmapi.response;

import de.jpwinkler.mkmapi.model.Article;
import de.jpwinkler.mkmapi.model.LinkedObject;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "response")
public class ArticleResponse extends LinkedObject {

    private List<Article> article = new ArrayList<>();

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }
}
