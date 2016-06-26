package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.builditbigger.JokeProvider;

import javax.inject.Named;

@Api(
  name = "jokeApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.builditbigger.gradle.udacity.com",
    ownerName = "backend.builditbigger.gradle.udacity.com",
    packagePath=""
  )
)
public class JokeEndpoint {
    private static final JokeProvider JOKE_PROVIDER = new JokeProvider();

    @ApiMethod(name = "getJokeByIndex")
    public Joke getJokeByIndex(@Named("index") int index) {
        return new Joke(JOKE_PROVIDER.getJokeByIndex(index));
    }

    @ApiMethod(name = "getRandomJoke")
    public Joke getRandomJoke() {
        return new Joke(JOKE_PROVIDER.getRandomJoke());
    }

}
