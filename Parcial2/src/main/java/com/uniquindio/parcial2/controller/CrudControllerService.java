package com.uniquindio.parcial2.controller;

import com.uniquindio.parcial2.model.base;

import java.util.ArrayList;

public class CrudControllerService {

    ModelFactoryController modelFactoryController;

    public CrudControllerService(){
            modelFactoryController= ModelFactoryController.getInstance();
    }

    public ArrayList<base> obtenerbase(){
        return modelFactoryController.getBase1().getBases();
    }



    public boolean agregarbase(base b){
        return modelFactoryController.agregarbase(b);
    }

    public boolean eliminarbase(String dato){
        return modelFactoryController.eliminarbase(dato);
    }

}
