package org.example.examen.models;

import javafx.scene.control.DatePicker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrada {
    private String matricula;
    private String modelo;
    private String cliente;
    private String tarifa;
    private DatePicker entrada;
    private DatePicker salida;
    private double coste;
}
