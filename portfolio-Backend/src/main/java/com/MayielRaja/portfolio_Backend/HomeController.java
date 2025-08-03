package com.MayielRaja.portfolio_Backend;

import java.util.*;
import org.springframework.web.bind.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import java.io.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class HomeController {
    @GetMapping("/projects")
    public List<Project> getProjects(){
        List<Project> projects=new ArrayList<>();
        projects.add(new Project("MoneyMate - Android Expense Tracker App",
                "Built a mobile application to track student expenses with add, delete, and view features. Used SQLite for offline data storage.",
                "Java, Android Studio, SQLite, XML",
                "https://drive.google.com/file/d/1C8R2F7vuqdlsAXGYMAXtZ9TYbaspQZi7/view?usp=drive_link",
                "https://github.com/MayielRaja/MoneyMate",
                "MoneyMate.jpeg"));
        projects.add(new Project(
                "Automated Smart Sericulture System",
                "Designed an automated system for silkworm rearing using ESP32 to monitor and control environmental conditions, integrated with Firebase.",
                "ESP32, C++, Firebase Realtime Database",
                "https://youtu.be/wXf8mHY8bQo?si=YHi0FRVdg77AMbP4",
                "https://github.com/MayielRaja/Sericulture-IOT",
                "logo2.jpeg"
        ));
        projects.add(new Project(
                "Asteroid Classification Predictive Model",
                "Developed a predictive model achieving 90% accuracy using Python and machine learning algorithms to classify asteroids based on their properties.",
                "Python, NumPy, Pandas, Seaborn, Matplotlib, Linear Regression",
                "https://docs.google.com/document/d/1hfCGK9fKPjOdBaydT_IwN5FgtQFJ6Q0M/edit?usp=sharing&ouid=105358392269625459786&rtpof=true&sd=true",
                "https://github.com/MayielRaja/Asteroid-Classification",
                "asteroid.jpg"
        ));
        return projects;
    }
    //llm for project
    @GetMapping("/profile-from-llm")
    public Profile getProfileFromLlm(){
        String prompt = "Write a concise and professional 'About Me' summary for a portfolio website. The person's name is Mayiel Raja Sundar B and he is an Electronics and Communication Engineer. The summary should be a single paragraph, less than 150 words. Also mention that he has practical experience as a Student Coordinator for the IEEE Student Branch and as a Placement Coordinator for the ECE Department.";

        Profile defaultProfile = new Profile(
                "MAYIEL RAJA SUNDAR B",
                "Electronics and Communication Engineer",
                "An aspiring Electronics and Communication Engineering student with a passion for programming and data analysis. Skilled in JAVA, Python, and machine learning, I’m eager to build innovative solutions and tackle challenging technical problems.",
                "https://github.com/MayielRaja",
                "https://www.linkedin.com/in/mayiel-raja-sundar-balamurugan-64a4641a7/",
                "https://drive.google.com/file/d/1sOa_5CPN0YVrZbJv7pJfjT9SDX8hGCBp/view?usp=sharing"
        );

        try {
            String jsonPayload = new ObjectMapper().writeValueAsString(Map.of(
                    "contents", List.of(Map.of(
                            "role", "user",
                            "parts", List.of(Map.of("text", prompt))
                    ))
            ));

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash-preview-05-20:generateContent?key="))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonResponse = objectMapper.readValue(response.body(), Map.class);
            List<Map<String, Object>> candidates = (List<Map<String, Object>>) jsonResponse.get("candidates");

            if (candidates != null && !candidates.isEmpty()) {
                Map<String, Object> candidate = candidates.get(0);
                Map<String, Object> content = (Map<String, Object>) candidate.get("content");
                List<Map<String, Object>> parts = (List<Map<String, Object>>) content.get("parts");

                if (!parts.isEmpty()) {
                    String generatedText = (String) parts.get(0).get("text");
                    defaultProfile.setAbout(generatedText);
                    return defaultProfile;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return defaultProfile;
    }
}
