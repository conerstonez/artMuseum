package com.art.gallery.model.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeId;
    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private User user;

}
