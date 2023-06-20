package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.ProfileRole;
import org.example.enums.ProfileStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

//    id, name, surname, login, password, phone, status, role, createdDate

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name = "surname" , nullable = false)
    private String surname;
    @Column(name = "login" , nullable = false)
    private String login;
    @Column(name = "password" , nullable = false)
    private String password;
    @Column(name = "phone" , nullable = false)
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(name = "status" , nullable = false)
    private ProfileStatus status;
    @Enumerated(EnumType.STRING)
    @Column(name = "role" , nullable = false)
    private ProfileRole role;
    @Column(name = "cratedDate" , nullable = false)
    private LocalDate cratedDate;
}
