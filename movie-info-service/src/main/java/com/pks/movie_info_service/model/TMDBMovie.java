package com.pks.movie_info_service.model;

public class TMDBMovie {
    private String id;
    private String title;
    private String overview;

    public TMDBMovie(String id,String title,String overview)
    {
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getOverview() {return overview;}
    public void setOverview(String overview) {this.overview = overview;}

    @Override
    public String toString()
    {
        return "TMDBMovie { id = " +id +
                ", title = " + title +
                ", overview = " + overview + " }" ;
    }
}
