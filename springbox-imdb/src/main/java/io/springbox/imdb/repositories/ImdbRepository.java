package io.springbox.imdb.repositories;

import io.springbox.imdb.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImdbRepository extends MongoRepository<Movie, String>, ImdbRepositoryCustom {
    Iterable<Movie> findByMovieID(String movieId);
}
