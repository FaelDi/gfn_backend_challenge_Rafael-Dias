package com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

import javax.persistence.Id;

@AllArgsConstructor // cria automaticamente um construtor com todas os atributos da classe como argumento.
@NoArgsConstructor //  cria automaticamente um construtor vazio (sem argumentos).
@Data //  cria automaticamente os métodos toString, equals, hashCode, getters e setters.
@Entity // A anotação @Entity pertence ao JPA e isso significa que a classe será automaticamente mapeada à tabela com o mesmo
public class Stores {
    @Id
    private String name;
    private String city;
    private String state;
    private Float latitude;
    private Float longitude;
    private Float revenue;
}