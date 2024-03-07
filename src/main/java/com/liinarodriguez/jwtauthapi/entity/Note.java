package com.liinarodriguez.jwtauthapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="note")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id_note", length = 100)
    protected  Integer id;
    @Column(name="note", length = 250)
    protected String note;
    @ManyToOne
    @JoinColumn(name ="user_id", nullable = false)
    protected User user;
}
