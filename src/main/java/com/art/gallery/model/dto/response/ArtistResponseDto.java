package com.art.gallery.model.dto.response;

import com.art.gallery.model.data.Gender;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
public class ArtistResponseDto {
    public HttpStatus code;
    private Long id;
    private String name;
    private String username;
    private String email;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String webpageUrl;
    private String socialMediaUrl;
}
