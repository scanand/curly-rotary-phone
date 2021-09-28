package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
public class Part04Transform {

//========================================================================================
    
    // TODO Capitalize the user username, firstname and lastname
    Mono<User> capitalizeOne(Mono<User> mono) {
        return mono.map(e -> {
            return new User(e.getUsername()
                                    .toUpperCase(),
                            e.getFirstname()
                                    .toUpperCase(),
                            e.getLastname()
                                    .toUpperCase());
        });
    }

//========================================================================================
    
    // TODO Capitalize the users username, firstName and lastName
    Flux<User> capitalizeMany(Flux<User> flux) {
        return flux.flatMap(e -> Flux.just(new User(e.getUsername()
                                                            .toUpperCase(),
                                                    e.getFirstname()
                                                            .toUpperCase(),
                                                    e.getLastname()
                                                            .toUpperCase())));
    }

//========================================================================================
    
    // TODO Capitalize the users username, firstName and lastName using #asyncCapitalizeUser
    Flux<User> asyncCapitalizeMany(Flux<User> flux) {
        return flux.flatMap ( u -> asyncCapitalizeUser(u));
    }
    
    Mono<User> asyncCapitalizeUser(User u) {
        return Mono.just(new User(u.getUsername()
                                          .toUpperCase(),
                                  u.getFirstname()
                                          .toUpperCase(),
                                  u.getLastname()
                                          .toUpperCase()));
    }
    
}
