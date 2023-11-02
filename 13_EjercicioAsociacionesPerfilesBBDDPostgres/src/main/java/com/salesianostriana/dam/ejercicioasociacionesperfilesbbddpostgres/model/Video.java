package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long codVideo;

    private int orden;
    private String titulo;
    private String descripcion;
    private String url;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public VideoPK getId() { // Nos devuelve la PK completa
        return new VideoPK(curso, codVideo);
    }

    public void setId(VideoPK pk) { // Podemos settear la PK compelta
        this.curso = pk.getCurso();
        this.codVideo = pk.getCodVideo();
    }



}