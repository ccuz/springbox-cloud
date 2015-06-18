package io.springbox.imdb.repositories;

import io.springbox.imdb.domain.Contributor;
import io.springbox.imdb.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImdbRepositoryCustom {
    public Iterable<Contributor> findContributorsByMovieID(String movieId);
}
