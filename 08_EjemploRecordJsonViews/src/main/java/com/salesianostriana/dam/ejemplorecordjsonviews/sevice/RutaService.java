package com.salesianostriana.dam.ejemplorecordjsonviews.sevice;

import com.salesianostriana.dam.ejemplorecordjsonviews.dto.EditRutaDto;
import com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.Dificultad;
import com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.Monumento;
import com.salesianostriana.dam.ejemplorecordjsonviews.model.entities.Ruta;
import com.salesianostriana.dam.ejemplorecordjsonviews.model.repos.MonumentoRepository;
import com.salesianostriana.dam.ejemplorecordjsonviews.model.repos.RutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RutaService {
    private final RutaRepository rutaRepository;

    // Inyectamos el repositorio mientras no tengamos servicio
    private final MonumentoRepository monumentoRepository;

    public Ruta save(EditRutaDto nuevo) {

        Ruta r = new Ruta();
        r.setNombre(nuevo.nombre());
        r.setTiempo(nuevo.duracion());
        r.setDificultad(Dificultad.valueOf(nuevo.dificultad()));

        // Supongamos que todo va bien
        /*List<Monumento> monumentos = nuevo.monumentos()
                .stream()
                .map(monumentoRepository::getReferenceById) // Vlad Mihalcea
                .toList();
        */
        List<Monumento> monumentos = new ArrayList<>();

        //reference by id es
        for(Long id : nuevo.monumentos()) {
            Monumento m = monumentoRepository.getReferenceById(id);
            monumentos.add(m);
        }


        r.setMonumentos(monumentos);


        return rutaRepository.save(r);
    }
}
