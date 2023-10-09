package com.salesianostriana.dam.ejemplorecordjsonviews.model.entities;

public class RutaView {
    //son clases estaticas el numero de clases estaticas depende de cuantas vistas
    //tengamos de la entidad ruta: formulario, detalles, editar y los atributos
    //de la entidad que queramos motrar en cada caso
    //Pueden tener herencia para no repetir la anotación en la entidad
    public static class RutaList/*GetRutaDto*/{}
    public static class RutaEdit /*EditRutaDto*/{}

}
