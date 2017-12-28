package com.example.android.newsfeed.data;

/**
 * Created by Rashid Saleem on 12/22/2017.
 */

public class Article {

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publicedAt;

    public Article(String author, String title, String description, String url, String urlToImage, String publicedAt) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publicedAt = publicedAt;
    }

    // Setter Methods
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public void setPublicedAt(String publicedAt) {
        this.publicedAt = publicedAt;
    }

    // Getter Methods


    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublicedAt() {
        return publicedAt;
    }
}
