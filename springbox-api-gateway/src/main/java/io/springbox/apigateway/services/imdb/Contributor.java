package io.springbox.apigateway.services.imdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by camp2015 on 6/18/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contributor {
    private String contribName;

    public String getContribName() {
        return contribName;
    }

    public void setContribName(String contribName) {
        this.contribName = contribName;
    }
}
