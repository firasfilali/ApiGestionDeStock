package com.filali.gestiodestock.config;

import com.flickr4java.flickr.Flickr;

import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class FlickrConfiguration {
    @Value("${flickr.api.key}")
    private String apiKey;
    @Value("${flickr.api.secret}")
    private String apiSecret;
    @Value("${flickr.app.key}")
    private String appKey;
    @Value("${flickr.app.secret}")
    private String appSecret;
    @Bean
    public Flickr getFlickr(){
        Flickr flickr = new Flickr(apiKey, apiSecret, new REST());

        Auth auth = new Auth();

        auth.setPermission(Permission.DELETE);

        auth.setToken(appKey);
        auth.setTokenSecret(appSecret);

        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);

        flickr.setAuth(auth);

        return flickr;

    }

  /*  @Bean
    public Flickr getFlickr() throws IOException, ExecutionException, InterruptedException, FlickrException {
        Flickr flickr = new Flickr(apiKey, apiSecret, new REST());

        OAuth10aService service = new ServiceBuilder(apiKey)
                .apiSecret(apiSecret)
                .build(FlickrApi.instance(FlickrApi.FlickrPerm.DELETE));

        final Scanner scanner = new Scanner(System.in);

        final OAuth1RequestToken request = service.getRequestToken();

        final String authUrl = service.getAuthorizationUrl(request);

        System.out.println(authUrl);
        System.out.println("Paste it here >> ");

        final String authVerifier = scanner.nextLine();

        OAuth1AccessToken accessToken = service.getAccessToken(request, authVerifier);

        System.out.println(accessToken.getToken());
        System.out.println(accessToken.getTokenSecret());

        Auth auth = flickr.getAuthInterface().checkToken(accessToken);

        System.out.println("-------------------------------");
        System.out.println(auth.getToken());
        System.out.println(auth.getTokenSecret());


        return flickr;
    }*/
}
