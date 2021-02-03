package com.example.fiserv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company {

    /**
     * devido aos nomes dos atributos serem iguais aos nomes das colunas do banco de dados
     * não tem a necessidade do @Column
     */

    @Id
    private Long id;

    private String name;

    private String cnpj;

    private Boolean active;
}
