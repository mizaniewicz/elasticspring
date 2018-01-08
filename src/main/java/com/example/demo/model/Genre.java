package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Genre {

    @NonNull
    private String name;
}
