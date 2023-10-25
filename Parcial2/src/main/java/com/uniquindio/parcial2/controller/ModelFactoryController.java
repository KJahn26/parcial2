package com.uniquindio.parcial2.controller;

import com.uniquindio.parcial2.model.base;
import com.uniquindio.parcial2.persistencia.Persistencia;

import java.io.IOException;
import java.util.List;

public class ModelFactoryController {

    base base1;

    public static class SingletonHolder{
        private final static ModelFactoryController eInstance= new ModelFactoryController();

    }

    public static ModelFactoryController getInstance(){
        return SingletonHolder.eInstance;

    }

    public ModelFactoryController(){

        System.out.println("Invocacion Singleton");
        cargarDatosDesdeArchivos();



    }

    public base getBase1(){
        return base1;
    }

    public List<base> getArrayList(){
        return base1.getBases();
    }

    public boolean agregarbase(base b) {
        if (!base1.baseexiste(b.getCodigo())) {
            base1.getBases().add(b);
            salvarDatosNuevosArchivo();
            guardarResourceXML();
            return true;
        }else{
            return false;
        }
    }

    public boolean eliminarbase(String dato){
        if(base1.eliminarbase(dato)){
            salvarDatosNuevosArchivo();
            return true;
        }
        else{
            return false;
        }
    }
public void cargarDatosDesdeArchivos ()
{
    base1 = new base();
    try {
        Persistencia.cargarArchivos(base1);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}

    private void cargarResourceXML() {

        base1 = Persistencia.cargarRecursoBancoXML();
    }

    private void guardarResourceXML() {

        Persistencia.guardarRecursoBancoXML(base1);
    }

private void salvarDatosNuevosArchivo ()
{
    try {
        Persistencia.guardarDatosArchivos(getBase1().getBases());
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}


}
