package com.uniquindio.parcial2.controller;

import com.uniquindio.parcial2.model.base;

public class CrudControllerService {

    ModelFactoryController modelFactoryController;

    public CrudControllerService(){
            modelFactoryController= ModelFactoryController.getInstance();
    }

    public base obtenerbase(){
        return modelFactoryController.getBase1();
    }

    public boolean agregarbase(base b){
        return modelFactoryController.agregarbase(b);
    }

    public boolean eliminarbase(String dato){
        return modelFactoryController.eliminarbase(dato);
    }

}
