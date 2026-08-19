package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

    @RestController
    @RequestMapping("/albums")
    public class AlbumController {

        private final List<Album> Album = new ArrayList<>() {{
            add(new Album("DC", "Anirudh", 2026, 50));
            add(new Album("MJ", "Michael Jackson", 1960, 100));
            add(new Album("2026", "George", 2026, 328));
        }};

        @GetMapping("/json")
        public List<Album> getAlbumJson() {
            return Album;
        }

        @GetMapping("/html")
        public String getAlbumHtml() {
            String albumList = "<ul>";
            for (Album album : Album) {
                albumList += "<li>" + Album + "</li>";
            }
            albumList += "</ul>";

            return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """ +
                    albumList +
                    """
                            </ul>
                        </body>
                    """;
        }

    }


