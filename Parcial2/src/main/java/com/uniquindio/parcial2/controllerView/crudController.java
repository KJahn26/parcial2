package com.uniquindio.parcial2.controllerView;

import com.uniquindio.parcial2.controller.CrudControllerService;
import com.uniquindio.parcial2.model.base;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class crudController {
    CrudControllerService crudService;

    ObservableList<base> bases = FXCollections.observableArrayList();

    base baseseleccionada;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtdato1;

    @FXML
    private TextField txtdato2;

    @FXML
    private TextField txtdato3;

    @FXML
    private TextField txtdato4;

    @FXML
    private TextField txtdato5;

    @FXML
    private TableView<base> tableView;

    @FXML
    private TableColumn<base, String> tablecolumn1;

    @FXML
    private TableColumn<base, String> tablecolumn2;

    @FXML
    private TableColumn<base, String> tablecolumn3;

    @FXML
    private TableColumn<base, String> tablecolumn4;

    @FXML
    private TableColumn<base, String> tablecolumn5;

    @FXML
    private TableColumn<base, String> tablecolumn6;

    @FXML
    void initialize() {
        crudService = new CrudControllerService();
        initView();

    }

    void initView() {
        obtenerbase();
        initDataBinding();
        tableView.getItems().clear();
        tableView.setItems(bases);
        listenerSelection();
    }

    void initDataBinding() {
        tablecolumn1.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getNombre()));
        tablecolumn2.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getApellido()));
        tablecolumn3.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tablecolumn4.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getCedula()));
        tablecolumn5.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getTelefono()));
        //tablecolumn6.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().));



    }

    void obtenerbase() {
        bases.addAll(crudService.obtenerbase());
    }

    @FXML
    void actualizarAction(ActionEvent event) {


        actualizartabla();
        tableView.refresh();
    }

    void actualizartabla(){
        initDataBinding();
        tableView.getItems().clear();
        tableView.setItems(bases);
        obtenerbase();
    }

    @FXML
    void agregarAction(ActionEvent event) {
        crearbase();

    }

    private void crearbase() {
        base b = crearBase();
        if (datosValidos(b)) {
            if (crudService.agregarbase(b)) {
                bases.add(b);
                limpiarCamposUsuario();
            } else {

            }
        } else {

        }
    }
    private base crearBase ()
    {
        base b = new base();
        b.setNombre(txtdato1.getText());
        b.setApellido(txtdato2.getText());
        b.setCorreo(txtdato3.getText());
        b.setCedula(txtdato3.getText());
        b.setTelefono(txtdato5.getText());
        return b;
    }

    private void limpiarCamposUsuario() {
        txtdato1.setText("");
        txtdato2.setText("");
        txtdato3.setText("");
        txtdato4.setText("");
        txtdato5.setText("");
    }

    private boolean datosValidos(base usuarioDto) {
        String mensaje = "";
        /*if(usuarioDto.nombre() == null || usuarioDto.nombre().equals(""))
            mensaje += "El nombre es invalido \n" ;
        if(usuarioDto.cedula() == null || usuarioDto.cedula().equals(""))
            mensaje += "El documento es invalido \n" ;
        if (usuarioDto.direccion()==null || usuarioDto.direccion().equals(""))
            mensaje+="La dirección no es valida \n";
        if (usuarioDto.telefono()==null || usuarioDto.telefono().equals(""))
            mensaje+="El telefono no es valido \n";
        if (usuarioDto.email()==null || usuarioDto.email().equals(""))
            mensaje+="Correo no es valido \n";
        if (usuarioDto.contrasena()==null || usuarioDto.contrasena().equals(""))
            mensaje+="Contraseña es invalida \n";*/
        if (mensaje.equals("")) {
            return true;
        } else {
            //mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    @FXML
    void eliminarAction(ActionEvent event) {
        eliminarbase();
    }

    private void listenerSelection() {
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            baseseleccionada = newSelection;
        });
    }

    public void eliminarbase(){
        if(baseseleccionada!=null){
            if(crudService.eliminarbase(baseseleccionada.getdato())){
                bases.remove(baseseleccionada);
                baseseleccionada=null;
                tableView.getSelectionModel().clearSelection();
            }
            else{

            }
        }else{

        }
    }
}
