package com.LuanGabriel.polinomium.domain;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbUsuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, length = 45)
    private String nome;
    @Column(nullable=false, length = 45)
    private String username;
    @Column(nullable=false)
    @Temporal(TemporalType.DATE)
    private java.util.Date dataNascimento;
    @Column(nullable=false, length = 45)
    private String email;
    @Column(nullable=false, length = 45)
    private String senha;
    @Column(nullable=false)
    private int XP;
    @Column(nullable=false)
    private int ofensiva;
    @Column(nullable=false)
    private int nível;
    @OneToMany(mappedBy = "usuario")
    private List<MatriculaLicao> matriculaLicao;


}
