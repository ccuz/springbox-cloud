package io.springbox.imdb.repositories;

import com.mongodb.Mongo;
import io.springbox.imdb.domain.Contributor;
import io.springbox.imdb.domain.Movie;
import io.springbox.imdb.domain.MovieRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by camp2015 on 6/18/15.
 */
public class ImdbRepositoryImpl implements ImdbRepositoryCustom {


    private final MongoTemplate mongoTemplate;

    @Autowired
    public ImdbRepositoryImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Iterable<Contributor> findContributorsByMovieID(String movieId) {
        Criteria mongoQuery = Criteria.where("MovieID").is(movieId);
        List<MovieRole> movieRoles = mongoTemplate.find(Query.query(mongoQuery), MovieRole.class);
        List<Contributor> contributors = new ArrayList<Contributor>();
        for (MovieRole movieRole : movieRoles){
            final Criteria contribName = Criteria.where("ContribName").is(movieRole.getContribName());
            final List<Contributor> contribs = mongoTemplate.find(Query.query(contribName), Contributor.class);
            contributors.addAll(contribs);
        }
        return contributors;
    }
}
