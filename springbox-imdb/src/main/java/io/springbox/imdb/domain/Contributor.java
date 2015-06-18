package io.springbox.imdb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Contributor")
public class Contributor {
    @Id
    private final String id;

    @Field("ContribName")
    private String contribName;

    public Contributor(String id){
        this.id = id;
    }

    public String getContribName() {
        return contribName;
    }

    public void setContribName(String contribName) {
        this.contribName = contribName;
    }
}
