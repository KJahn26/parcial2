package com.uniquindio.parcial2.model;

import java.io.Serializable;
import java.util.ArrayList;

public class base  implements Serializable {
    private static final long serialVersionUID = 2L;
    public base (){}

    public String getDato() {
        return dato;
    }

    ArrayList<base> bases= new ArrayList<>();
    private String codigo="";
    private String correo="";
    private String nombre="";
    private String apellido="";
    private String cedula="";
    private String telefono="";


    String dato;



    public ArrayList<base> getBases() {
        return bases;
    }

    public void setBases(ArrayList<base> bases) {
        this.bases = bases;
    }

    public String getdato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public boolean baseexiste(String r){
        if(verificarexistencia(r)){
            //JOptionPane.showMessage(null,"el objeto ya existe");
            return true;
        }else{
            return false;
        }
    }

    public boolean verificarexistencia(String r){
        boolean flag=false;
        for(base b :getBases()) {
            if(b.getCedula().equalsIgnoreCase(r)){
                flag=true;
                break;
            }
        }
        return flag;
    }

    public boolean eliminarbase(String dato){
        base bas= null;
        bas=obetenerbase(dato);
        if(bas!=null){
            getBases().remove(bas);
            return true;
        }else{
            return false;
        }
    }

    public base obetenerbase(String dato){
        base bas= null;
        for(base ba:getBases()){
            if(dato.equalsIgnoreCase(ba.getCedula())){
                bas=ba;
                break;
            }
        }
    return bas;}

}
