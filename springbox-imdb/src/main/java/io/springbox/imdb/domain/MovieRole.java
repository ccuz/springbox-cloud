package io.springbox.imdb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="MovieRole")
public class MovieRole {
    @Id
    private final String id;

    private String ContribName;
    @Field(value = "MovieID")
    private String movieID;
    private String ContribClass;

    private String ContribRole;
    private String ContribRoleDetail;

    MovieRole(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getContribName() {
        return ContribName;
    }

    public void setContribName(String contribName) {
        ContribName = contribName;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getContribClass() {
        return ContribClass;
    }

    public void setContribClass(String contribClass) {
        ContribClass = contribClass;
    }

    public String getContribRole() {
        return ContribRole;
    }

    public void setContribRole(String contribRole) {
        ContribRole = contribRole;
    }

    public String getContribRoleDetail() {
        return ContribRoleDetail;
    }

    public void setContribRoleDetail(String contribRoleDetail) {
        ContribRoleDetail = contribRoleDetail;
    }
}
