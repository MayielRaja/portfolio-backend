package com.MayielRaja.portfolio_Backend;

public class Project {
    private String name;
    private String description;
    private String technologies;
    private String liveUrl;
    private String githubUrl;
    private String imageUrl;
    public Project(String name,String description,String technologies,String liveUrl,String githubUrl,String imageUrl){
        this.name=name;
        this.description=description;
        this.technologies=technologies;
        this.liveUrl=liveUrl;
        this.githubUrl=githubUrl;
        this.imageUrl=imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
