package com.example.security.dto.response;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOutputV2 {
    private Long id;
    private String username;
    private String fullName;
    private String role;
}
