package com.tabeldata.pln.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Data
@ToString(exclude = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "s_user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String username;
    private String password;
    private boolean active;
    
    
    @OneToMany(mappedBy = "user")
    private List<UserRoles> roles = new ArrayList<>();
}
