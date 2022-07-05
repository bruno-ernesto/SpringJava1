package com.example.h2.api.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(nullable = false)
    private  String code_L;
    @Column(nullable = false)
    private  String name_L;
}
