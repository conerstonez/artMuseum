package com.art.gallery.model.dto.request;

import com.art.gallery.model.data.Address;
import lombok.Data;

@Data
public class UserDetailDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Address address;
}
