package com.MayielRaja.portfolio_Backend;

public class Profile {
    public String name;
    public String profession;
    public String about;
    public String githubUrl;
    public String linkedinUrl;
    public String resumeUrl;
    public Profile(String name, String profession, String about,String githubUrl,String linkedinUrl, String resumeUrl){
        this.name=name;
        this.profession=profession;
        this.about=about;
        this.githubUrl=githubUrl;
        this.linkedinUrl=linkedinUrl;
        this.resumeUrl=resumeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }
}
