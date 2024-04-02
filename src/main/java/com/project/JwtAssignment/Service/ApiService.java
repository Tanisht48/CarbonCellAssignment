package com.project.JwtAssignment.Service;

import com.project.JwtAssignment.Model.ApiEntry;
import com.project.JwtAssignment.Model.ApiResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {

    @Value("${public.api.url}")
    private String publicApiUrl;

    public ApiResponse getEntries(String category, int limit) {
        String apiUrl = publicApiUrl;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                String.class);

        String responseBody = responseEntity.getBody();
        ApiResponse response = new ApiResponse();
        List<ApiEntry> entries = new ArrayList<>();

        // Process JSON response
        JSONObject jsonResponse = new JSONObject(responseBody);
        JSONArray entriesArray = jsonResponse.getJSONArray("entries");

        // Filter and limit entries
        for (int i = 0; i < entriesArray.length(); i++) {
            JSONObject entryJson = entriesArray.getJSONObject(i);
            ApiEntry entry = new ApiEntry();
            entry.setApi(entryJson.getString("API"));
            entry.setDescription(entryJson.getString("Description"));
            entry.setAuth(entryJson.getString("Auth"));
            entry.setHttps(entryJson.getBoolean("HTTPS"));
            entry.setCors(entryJson.getString("Cors"));
            entry.setLink(entryJson.getString("Link"));
            entry.setCategory(entryJson.getString("Category"));
            if (category == null || category.isEmpty() || entry.getCategory().equalsIgnoreCase(category)) {
                entries.add(entry);
            }
        }

        // Limit entries
        entries = entries.subList(0, Math.min(entries.size(), limit));

        // Update ApiResponse object
        response.setCount(entries.size());
        response.setEntries(entries);

        return response;
    }
}