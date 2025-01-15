package com.aluraLatam.literaluraChalllenge.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class ConsumoAPI {
    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException("Error de E/S al obtener datos de la API", e);
        } catch (InterruptedException e) {
            throw new RuntimeException("La solicitud fue interrumpida", e);
        }
        String json = response.body();
        return json;
    }
}
