package com.salesianostriana.dam.ejercicioasociacionesperfilesbbddpostgres.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "curso")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private double puntucion;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @OneToMany(mappedBy = "curso")
    private List<Video> listVideos = new ArrayList<>();

    public void addVideo(Video video) {
        listVideos.add(video);
        video.setCurso(this);
    }

    public void removeVideo(Video video) {
        listVideos.remove(video);
        video.setCurso(null);
    }




}