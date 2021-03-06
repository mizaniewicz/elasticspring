package com.example.demo.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Director {

    @NonNull
    private String name;

    private List<Movie> movies;
}
