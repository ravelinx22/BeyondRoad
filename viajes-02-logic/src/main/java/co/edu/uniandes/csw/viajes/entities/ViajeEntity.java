/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jm.dominguez
 */

@Entity
public class ViajeEntity implements Serializable{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * id del viaje
     */
    private Long idViaje;
    /**
     * número de kilometros del viaje.
     */
    private Integer Kilometros;
    /**
     * Cantidad a pagar por una reserva en el viaje.
     */
    private Double gastosCompartidos;
    /**
     * Día y Hora de partida
     */
    @Temporal(TemporalType.DATE)
    private Date diaYHoraPartida;
    /**
     * Dia y Hora de llegada
     */
    @Temporal(TemporalType.DATE)
    private Date diaYHoraLlegada;
    /**
     * Lugar de origen del viaje
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    private LugarEntity origen;
    /**
     * Lugar de destino del viaje
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    private LugarEntity destino;
    /**
     * Automovil a utilizar en el viaje.
     */
    @OneToOne (cascade = CascadeType.MERGE)
    private AutomovilEntity automovil;
    /**
     * Persona que va a ejercer como conductor a lo largo del viaje
     */
    @ManyToOne 
    private ConductorEntity conductor;
    /**
     * Retorna el conductor del viaje
     * @return Conductor del viaje
     */
    public ConductorEntity getConductor() {
        return conductor;
    }
    /**
     * Permite cambiar el conductor
     * @param conductor del viaje
     */
    public void setConductor(ConductorEntity conductor) {
        this.conductor = conductor;
    }
    
    
    /**
     * Retorna el automovil del viaje
     * @return Automovil del viaje
     */
    public AutomovilEntity getAutomovil() {
        return automovil;
    }
    /**
     * Asigna el automovil del viaje
     * @param automovil del viaje
     */
    public void setAutomovil(AutomovilEntity automovil) {
        this.automovil = automovil;
    }
    
    /**
     * Retorna el origen del viaje
     * @return Lugar de origen
     */
    public LugarEntity getOrigen() {
        return origen;
    }
    /**
     * Establece el origen de viaje
     * @param origen del viaje
     */
    public void setOrigen(LugarEntity origen) {
        this.origen = origen;
    }
    /**
     * Establece el destino del viaje
     * @return destino del viaje
     */
    public LugarEntity getDestino() {
        return destino;
    }
    
    /**
     * Establece el destino del viaje
     * @param destino del viaje
     */
    public void setDestino(LugarEntity destino) {
        this.destino = destino;
    }
    /**
     * Retorna la id del viaje
     * @return id del viaje
     */
    public Long getIdViaje() {
        return idViaje;
    }
    /**
     * Asigna la id del viaje
     * @param idViaje 
     */
    public void setIdViaje(Long idViaje) {
        this.idViaje = idViaje;
    }
    /**
     * Retorna el número de kilometros del viaje
     * @return Kilometros del viaje
     */
    public Integer getKilometros() {
        return Kilometros;
    }
    /**
     * Establece el numero de kilometros del viaje
     * @param Kilometros 
     */
    public void setKilometros(Integer Kilometros) {
        this.Kilometros = Kilometros;
    }
/**
 * Retorna el costo de una reserva del viaje
 * @return 
 */
    public Double getGastosCompartidos() {
        return gastosCompartidos;
    }
/**
 * Permite ajustar el costo de una reserva en el viaje
 * @param gastosCompartidos 
 */
    public void setGastosCompartidos(Double gastosCompartidos) {
        this.gastosCompartidos = gastosCompartidos;
    }
/**
 * Retorna día y hora de partida del viaje
 * @return 
 */
    public Date getDiaYHoraPartida() {
        return diaYHoraPartida;
    }
    /**
     * Permite ajustar la fecha de partida del viaje
     * @param diaYHoraPartida 
     */
    public void setDiaYHoraPartida(Date diaYHoraPartida) {
        this.diaYHoraPartida = diaYHoraPartida;
    }
    /**
     * Retorna día y hora de llegada del viaje
     * @return 
     */
    public Date getDiaYHoraLlegada() {
        return diaYHoraLlegada;
    }
    /**
     * Permite ajustar día y hora de llegada del viaje
     * @param diaYHoraLlegada 
     */
    public void setDiaYHoraLlegada(Date diaYHoraLlegada) {
        this.diaYHoraLlegada = diaYHoraLlegada;
    }
    /**
     * Método equals sobreescrito
     * @param obj
     * @return true, si los objetos son iguales. False de lo contrario.
     */
    @Override
    public boolean equals(Object obj){
        ViajeEntity v = (ViajeEntity) obj;
        return v.getIdViaje().equals(idViaje);
    }
    /**
     * Método hashCode sobreescrito
     * @return Codigo hash del objeto en cuestión.
     */
    @Override
    public int hashCode(){
        if(this.getIdViaje() != null){
            return this.getIdViaje().hashCode();
        }
        
        return super.hashCode();
    }
}
