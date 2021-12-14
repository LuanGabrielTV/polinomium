package com.LuanGabriel.polinomium.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbmatriculaLicao")
public class MatriculaLicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private Boolean isLocked;
    @Column(nullable=false)
    private Boolean isFinished;
    @ManyToOne
    @JoinColumn(name="Licao")
    Licao licao;
    @ManyToOne
    @JoinColumn(name="Usuario")
    Usuario usuario;

}
