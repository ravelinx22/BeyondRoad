/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.LugarEntity;

/**
 *
 * @author wr.ravelo
 */
public class LugarDTO {
    
    private Long id;
    private String lugar;
    private String dirrecion;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the dirrecion
     */
    public String getDirrecion() {
        return dirrecion;
    }

    /**
     * @param dirrecion the dirrecion to set
     */
    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }
    
    public LugarEntity toEntity() {
        LugarEntity en = new LugarEntity();
        en.setDireccion(this.dirrecion);
        en.setId(this.id);
        en.setLugar(this.lugar);
        return en;
    }
}
