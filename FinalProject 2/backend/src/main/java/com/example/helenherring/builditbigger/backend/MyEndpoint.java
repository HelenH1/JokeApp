/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.helenherring.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.example.Jokes;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.helenherring.example.com",
                ownerName = "backend.builditbigger.helenherring.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    Jokes mJoke;

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        mJoke = new Jokes();
        String joke = mJoke.getJoke();
        response.setData(joke);
        System.out.println("Joke in endpoint: "+response.getData());

        return response;
    }

}
