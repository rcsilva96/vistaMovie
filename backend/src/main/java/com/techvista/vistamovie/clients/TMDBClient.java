package com.techvista.vistamovie.clients;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TMDBClient {

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.themoviedb.org/3/movie/popular?language=en-US&page=1"))
            .header("accept", "application/json")
            .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzZmE5YjFmOTMwMzdmOTQxYjczM2FjNzc3ZWYyYmJlMSIsIm5iZiI6MTcyNjk2NDgzMS4xMDMyNSwic3ViIjoiNjZlZGY2MGVhODJiMDA1NzAzMjVjYjhiIiwic2NvcGVzIjpbImFwaV9yZWFkIl0sInZlcnNpb24iOjF9.wX-20BKhRa8a9yXXzXicvaSFZHfkToJfTLenwEbiWBE")
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

    public TMDBClient() throws IOException, InterruptedException {
    }

    public HttpResponse<String> getMovie(){
        return response;
    }

}

@Component
class Apiremota {

    @Cacheable
    @PostConstruct
    public void getApi() throws IOException, InterruptedException {
        var response = new TMDBClient().response.body();
        System.out.println(response);
    }
}

