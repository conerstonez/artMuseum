package com.art.gallery.model.dto.request;

import com.art.gallery.model.data.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ArtistRequestDto {
    private String FirstName;
    private  String lastName;
    private String username;
    private Gender gender;
    private String email;
    private LocalDate dateOfBirth;
    private String password;
    public void setDateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }
}
