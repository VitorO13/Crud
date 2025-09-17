package com.vitorprojects.projetocrud.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email", unique = true)//isso vai ser unic no sistema
    private String email;                //n pode ter 2 emails iguais no sistema

    @Column(name = "nome")
    private String nome;

    @Column(name = "celular", unique = true)
    private Integer celular;

    @Column(name = "idade", length = 140)
    private byte idade;


}
