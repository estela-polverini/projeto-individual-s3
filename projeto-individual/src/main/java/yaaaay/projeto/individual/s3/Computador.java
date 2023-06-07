/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yaaaay.projeto.individual.s3;

/**
 *
 * @author teteg
 */
public class Computador {

    private Integer idComputador;
    private Integer idEmpresa;

    public Computador(Integer idComputador, Integer idEmpresa) {
        this.idComputador = idComputador;
        this.idEmpresa = idEmpresa;
    }

    public Computador() {
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public Integer getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(Integer idComputador) {
        this.idComputador = idComputador;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public String toString() {
        return "Computador{" + "idComputador=" + idComputador + ", idEmpresa=" + idEmpresa + '}';
    }

}
