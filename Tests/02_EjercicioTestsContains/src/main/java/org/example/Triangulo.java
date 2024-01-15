package org.example;

public class Triangulo {
    public TipoTriangulo tipoDeTriangulo(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return TipoTriangulo.NOESUNTRIANGULO;
        }

        if (a == b && b == c) {
            return TipoTriangulo.EQUILATERO;
        } else if (a == b || a == c || b == c) {
            return TipoTriangulo.ISOSCELES;
        } else {
            return TipoTriangulo.ESCALENO;
        }
    }
}
