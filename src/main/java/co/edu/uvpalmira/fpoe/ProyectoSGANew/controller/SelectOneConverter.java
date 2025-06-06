/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uvpalmira.fpoe.ProyectoSGANew.controller;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@FacesConverter(value = "selectOneConverter")
public class SelectOneConverter implements Converter<Object> {
    private final Map<String,Object> map = new HashMap<>();
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.isBlank()) {
            return null;
        }

        return map.get(string);
    }
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null) {
            return "";
        }
        if (!map.containsKey(t.toString())) {
            map.put(t.toString(), t);
        }
        return t.toString();
    }
}
