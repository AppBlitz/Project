package com.example.spring.dto;

import lombok.NonNull;

public record CommentDto(@NonNull String nameUser, @NonNull String text, @NonNull String date) {
}
