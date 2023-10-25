package com.uniquindio.parcial2.persistencia;

import com.uniquindio.parcial2.model.base;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class Persistencia {


    public static final String RUTA_DAT="";
    public  static final String Ruta_log="";

    public static final String RUTA_txt="C:\\Users\\Carlos Corrales\\OneDrive\\Documentos\\Database\\parcial2\\Parcial2\\src\\main\\resources\\Persistencia\\Datos.txt";

    public static final String Ruta_XML="C:\\Users\\Carlos Corrales\\OneDrive\\Documentos\\Database\\parcial2\\Parcial2\\src\\main\\resources\\Persistencia\\Datos.xml";

 public static void guardarDatosArchivos (ArrayList<base> listaBase) throws IOException {
      String contenido="";
      for (base s:listaBase)
      {
          contenido+=s.getNombre()+";"+s.getApellido()+";"+s.getCorreo()+";"+s.getCedula()+";"+s.getTelefono()+"\n";
      }
      ArchivoUtil.guardarArchivo(RUTA_txt,contenido,false);
 }

public static void cargarArchivos (base bases) throws IOException {
    ArrayList<base> bases2 = cargarDatosArchivos1();
    if (bases2.size()>0)
    {
        bases.getBases().addAll(bases2);
    }
}

   // ---- LOADS ----- //

 public static ArrayList<base> cargarDatosArchivos1 () throws IOException {
        ArrayList<base> datosArchivos = new ArrayList<>();
        ArrayList<String> contenido=ArchivoUtil.leerDatosArchivos(RUTA_txt);
        String centinela="";

     for (int i = 0; i < contenido.size(); i++) {
         centinela = contenido.get(i);
         String[] partes = centinela.split(";");

         if (partes.length >= 5) { // Asegúrate de que haya al menos 2 elementos.
             base bases = new base();
             bases.setNombre(partes[0].trim());
             bases.setApellido(partes[1].trim());
             bases.setCorreo(partes[2].trim());
             bases.setCedula(partes[3].trim());
             bases.setTelefono(partes[4].trim());
        /* Asegúrate de que haya más elementos antes de intentar acceder a ellos.
        bases.setCorreo(partes.length > 2 ? partes[2].trim() : "");
        bases.setCedula(partes.length > 3 ? partes[3].trim() : "");
        bases.setTelefono(partes.length > 4 ? partes[4].trim() : "");
        */
             datosArchivos.add(bases);
         } else {
             // Maneja el caso en el que la línea no tenga la cantidad esperada de elementos.
             System.err.println("Línea " + i + " no contiene la cantidad de elementos esperada: " + centinela);
         }
         centinela = "";
     }

     return datosArchivos;
 }

    public static base cargarRecursoBancoXML() {

        base bases = null;

        try {
            bases = (base)ArchivoUtil.cargarRecursoSerializadoXML(Ruta_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bases;

    }

    public static void guardarRecursoBancoXML(base bases) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(Ruta_XML,bases);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
