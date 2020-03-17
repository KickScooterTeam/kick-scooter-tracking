package com.softserve.tracking.TrackingService.service;

import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

class ApiJsonParser {

    private String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = reader.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    JSONObject parse(String url) {
        try {
            InputStream is = new URL(url).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonTxt = readAll(reader);
            JSONObject json = new JSONObject(jsonTxt);
            return json.getJSONArray("routes").getJSONObject(0).getJSONObject("overview_polyline");
        } catch (IOException e) {
            return null;
        }
    }


}
