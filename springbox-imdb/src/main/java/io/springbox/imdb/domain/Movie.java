package io.springbox.imdb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

/**
 * {"MovieID":"\"The Good Wife\" (2009)",
 * "SeriesID":"\"The Good Wife\" (2009)",
 * "SeriesType":"S",
 * "SeriesEndYear":"",
 * "ReleaseYear":"2009",
 * "AltTitles":["\"Good Wife\" (2009)"],
 * "Parental":{"Certificates":
 *      ["Australia:M","China:(Banned)\t(internet) (2014)",
 *      "Finland:K-12","Netherlands:9\t(seasons 1 and 2)",
 *      "Netherlands:12\t(seasons 3 and 4)",
 *      "Singapore:NC-16\t(season 1)",
 *      "Singapore:M18\t(season 2) (season 3) (season 5)",
 *      "USA:TV-14\t(some episodes)",
 *      "USA:TV-PG\t(some episodes)"
 *      ]},
 *  "Technical":{"Colors":["Color"],
 *  "Sounds":["Dolby Digital"]}
 */
public class Movie {
    @Id
    private final String id;
    @Indexed
    private String movieID;
    private String seriesID;
    private String seriesType;
    private String seriesEndYear;
    private String releaseYear;
    private List<String> altTitles;
    private List<String> countries;
    private List<String> languages;
    private List<String> genres;
    private List<String> keywords;
    private List<String> locations;

    public Movie(final String id){
        this.id = id;
    }

    public String id() {
        return id;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getSeriesID() {
        return seriesID;
    }

    public void setSeriesID(String seriesID) {
        this.seriesID = seriesID;
    }

    public String getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(String seriesType) {
        this.seriesType = seriesType;
    }

    public String getSeriesEndYear() {
        return seriesEndYear;
    }

    public void setSeriesEndYear(String seriesEndYear) {
        this.seriesEndYear = seriesEndYear;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<String> getAlternativeTitles() {
        return altTitles;
    }

    public void setAlternativeTitles(List<String> alternativeTitles) {
        this.altTitles = alternativeTitles;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

}
