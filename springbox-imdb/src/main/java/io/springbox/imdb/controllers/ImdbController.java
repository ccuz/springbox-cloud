package io.springbox.imdb.controllers;

import com.wordnik.swagger.annotations.ApiOperation;
import io.springbox.imdb.domain.Contributor;
import io.springbox.imdb.repositories.ImdbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableOAuth2Resource
public class ImdbController {

    @Autowired
    ImdbRepository imdbRepository;

    /*@RequestMapping(value = "/movies", method = RequestMethod.GET)
    public Iterable<Movie> movies() {
        return imdbRepository.findAll();
    }

    @RequestMapping(value = "/movies/{movie_id}", method = RequestMethod.GET)
    public Iterable<Movie> movies(@PathVariable String movie_id) {
        return imdbRepository.findByMovieID(movie_id);
    }*/

    @ApiOperation(value="Get the actors and productors of a movie", notes="Uses the remote user logged in")
    @RequestMapping(value = "/contributors/formovie/{movie_id}", method = RequestMethod.GET)
    public Iterable<Contributor> movieContributors(@PathVariable String movie_id) {
        return imdbRepository.findContributorsByMovieID(movie_id);
    }

    /**@RequestMapping(value = "/reviews", method = RequestMethod.POST)
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        reviewRepository.save(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }*/

}
