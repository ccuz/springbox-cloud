package io.springbox.apigateway.services.imdb;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.ObservableResult;
import io.springbox.apigateway.services.catalog.Movie;
import io.springbox.apigateway.services.reviews.Review;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.util.Arrays;
import java.util.List;

@Service
public class ImdbIntegrationService {

    private Log log = LogFactory.getLog(ImdbIntegrationService.class);

    @Autowired
    @Qualifier("loadBalancedRestTemplate")
    @LoadBalanced
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "circuitBreakerContributors",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
            }
    )
    public List<Contributor> getMovieContributors(final String mlId) {
        //return new ObservableResult<List<Contributor>>() {
        //    @Override
            //public List<Contributor> invoke() {
                return restTemplate.exchange("http://springbox-imdb/contributors/formovie/{mlId}",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Contributor>>(){}, mlId).getBody();
            //}
        //};
    }

    @SuppressWarnings("unused")
    private List<Contributor> circuitBreakerContributors(final String mlId) {
        Contributor contributor = new Contributor();
        contributor.setContribName("...no contributor available...");
        return Arrays.asList(contributor);
    }
}
