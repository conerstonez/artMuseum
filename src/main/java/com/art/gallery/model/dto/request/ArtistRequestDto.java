package com.art.gallery.model.dto.request;

import com.art.gallery.model.data.Address;
import com.art.gallery.model.data.Gender;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;

@Data
public class ArtistRequestDto {
    public HttpStatus code;
    private Long id;
    private String FirstName;
    private  String lastName;
    private String email;
    private String password;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String webpageUrl;
    private String socialMediaUrl;
    private List<PostDto> posts;
    private Address address;
    public void setDateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }
}
