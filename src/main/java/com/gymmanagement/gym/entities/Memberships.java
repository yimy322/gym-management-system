package com.gymmanagement.gym.entities;

import java.math.BigDecimal;

import com.gymmanagement.gym.utils.EstadoMembresia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membresia")
@Data
@NoArgsConstructor
public class Memberships {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_membresia")
    private Long idMembresia;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "duracion_meses", nullable = false)
    private Integer duracionMeses;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoMembresia estado;

}
