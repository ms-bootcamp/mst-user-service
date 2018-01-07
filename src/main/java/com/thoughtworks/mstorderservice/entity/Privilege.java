package com.thoughtworks.mstorderservice.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_privilege")
public class Privilege implements Serializable {

    public enum Symbol {
        RETRIVE_USER("查看用户"),
        CREATE_USER("创建用户"),
        UPDATE_USER("更改用户"),
        DELETE_USER("删除用户");

        private String description;

        Symbol(String description) {
            this.description = description;
        }

        public String description() {
            return description;
        }
    }

    @Id
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private Symbol symbol;

    private String name;

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
        this.name = symbol.description();
    }
}
