package com.uniquindio.parcial2.model;

import java.util.ArrayList;

public class base {

    String dato;

    ArrayList<base> bases= new ArrayList<>();

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
            if(b.getdato().equalsIgnoreCase(r)){
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
            if(dato.equalsIgnoreCase(ba.dato)){
                bas=ba;
                break;
            }
        }
    return bas;}

}
