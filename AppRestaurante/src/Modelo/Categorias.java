/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author samuel
 */
public class Categorias {
    int ID_CATEGORIA;
    String CATEGORIA;
    String MEDIDA_CATEGORIA;

    public Categorias() {   
    }
    
    
    public Categorias(int ID_CATEGORIA, String CATEGORIA, String MEDIDA_CATEGORIA) {
        this.ID_CATEGORIA = ID_CATEGORIA;
        this.CATEGORIA = CATEGORIA;
        this.MEDIDA_CATEGORIA = MEDIDA_CATEGORIA;
    }

    public int getID_CATEGORIA() {
        return ID_CATEGORIA;
    }

    public void setID_CATEGORIA(int ID_CATEGORIA) {
        this.ID_CATEGORIA = ID_CATEGORIA;
    }

    public String getCATEGORIA() {
        return CATEGORIA;
    }

    public void setCATEGORIA(String CATEGORIA) {
        this.CATEGORIA = CATEGORIA;
    }

    public String getMEDIDA_CATEGORIA() {
        return MEDIDA_CATEGORIA;
    }

    public void setMEDIDA_CATEGORIA(String MEDIDA_CATEGORIA) {
        this.MEDIDA_CATEGORIA = MEDIDA_CATEGORIA;
    }

    @Override
    public String toString() {
        return "Categorias{" + "ID_CATEGORIA=" + ID_CATEGORIA + ", CATEGORIA=" + CATEGORIA + '}';
    }

    
    
}
