package com.thoughtworks.mstorderservice.entity;

import com.thoughtworks.mstorderservice.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    @Id
    private String id;

    @Column(unique = true)
    private String name;

    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    private Role role;

    public User() {
        id = StringUtils.uuid();
    }
}
