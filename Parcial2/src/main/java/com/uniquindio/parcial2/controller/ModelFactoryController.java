package com.uniquindio.parcial2.controller;

import com.uniquindio.parcial2.model.base;

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
    }

    public base getBase1(){
        return base1;
    }

    public List<base> getArrayList(){
        return base1.getBases();
    }

    public boolean agregarbase(base b) {
        if (!base1.baseexiste(b.getdato())) {
            base1.getBases().add(b);
            return true;
        }else{
            return false;
        }
    }

    public boolean eliminarbase(String dato){
        if(base1.eliminarbase(dato)){
            return true;
        }
        else{
            return false;
        }
    }


}
