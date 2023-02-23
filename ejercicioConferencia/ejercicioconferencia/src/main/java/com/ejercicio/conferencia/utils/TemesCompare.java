/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejercicio.conferencia.utils;

import com.ejercicio.conferencia.dto.EventConferenceDto;
import java.util.Comparator;

/**
 *
 * @author esanchez
 */
public class TemesCompare implements Comparator<EventConferenceDto> {

    @Override
    public int compare(EventConferenceDto o1, EventConferenceDto o2) {
        if(o1.getMinutes() < o2.getMinutes())
        {
            return 1;
        }else{
            return -1;
        }
    }
    
}
