package com.burger_menu.burger_menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    Integer[] numerossalsas={0,1,2,3,4,5};
    @FXML
    private ToggleGroup bebida;

    @FXML
    private Button btnCalcular;

    @FXML
    private CheckBox checkHamburguesa;

    @FXML
    private CheckBox checkPatatas;

    @FXML
    private CheckBox checkQueso;

    @FXML
    private ChoiceBox<Integer> choiceBarbacoa;


    @FXML
    private ChoiceBox<Integer> choiceKetchup;


    @FXML
    private ChoiceBox<Integer> choiceMostarda;


    @FXML
    private ToggleGroup hamburguesa;

    @FXML
    private ToggleGroup pan;

    @FXML
    private ToggleGroup patatas;

    @FXML
    private RadioButton radioButtonAgua;

    @FXML
    private RadioButton radioButtonCaseras;

    @FXML
    private RadioButton radioButtonCenteno;

    @FXML
    private RadioButton radioButtonCerdo;

    @FXML
    private RadioButton radioButtonCerveza;

    @FXML
    private RadioButton radioButtonCola;

    @FXML
    private RadioButton radioButtonDomicilio;

    @FXML
    private RadioButton radioButtonFritas;

    @FXML
    private RadioButton radioButtonGajo;

    @FXML
    private RadioButton radioButtonIntegral;

    @FXML
    private RadioButton radioButtonLimon;

    @FXML
    private RadioButton radioButtonNaranja;

    @FXML
    private RadioButton radioButtonNormal;

    @FXML
    private RadioButton radioButtonPollo;

    @FXML
    private RadioButton radioButtonRecogida;

    @FXML
    private RadioButton radioButtonTernera;

    @FXML
    private RadioButton radioButtonVegana;

    @FXML
    private ToggleGroup recorrida;

    @FXML
    private TextArea txtIVA;

    @FXML
    private TextArea txtPVP;

    @FXML
    private TextArea txtPrecio;

    @FXML
    private Label welcomeText;

    @FXML
    void Calcular(ActionEvent event) {

        //iniciando la variable
        Double gastos=0.0;

        //chekbox,  items extras
        if(checkHamburguesa.isSelected()){
            gastos+=2.0;
        }
        if(checkQueso.isSelected() ){
            gastos+=0.5;
        }
        if(checkPatatas.isSelected()){
            gastos+=0.5;
        }

        //  carnes
        if (radioButtonPollo.isSelected() ||radioButtonCerdo.isSelected()){
            gastos+=2.0;
        }

        if (radioButtonTernera.isSelected() || radioButtonVegana.isSelected()){
            gastos+=3.0;
        }

        //  pan
        if (radioButtonNormal.isSelected() ||radioButtonIntegral.isSelected()||radioButtonCenteno.isSelected()){
            gastos+=2.0;
        }

        //  patatas
        if (radioButtonFritas.isSelected() || radioButtonGajo.isSelected()){
            gastos+=2.0;
        }

        if (radioButtonCaseras.isSelected()){
            gastos+=3.0;
        }

        //  bebida
        if (radioButtonAgua.isSelected() ||radioButtonCerveza.isSelected()||radioButtonCola.isSelected()||radioButtonLimon.isSelected() ||radioButtonNaranja.isSelected() ){
            gastos+=2.0;
        }

        // recogida
        if (radioButtonRecogida.isSelected()){
            gastos-=gastos*0.2;
        }

        //las salsas
        if(choiceMostarda.getValue()==1){
            gastos+=0.5;
        }
        if(choiceMostarda.getValue()==2){
            gastos+=1.0;
        }
        if(choiceMostarda.getValue()==3){
            gastos+=1.5;
        }
        if(choiceMostarda.getValue()==4){
            gastos+=2.0;
        }
        if(choiceMostarda.getValue()==5){
            gastos+=2.5;
        }
        if(choiceKetchup.getValue()==1){
            gastos+=0.5;
        }
        if(choiceKetchup.getValue()==2){
            gastos+=1.0;
        }
        if(choiceKetchup.getValue()==3){
            gastos+=1.5;
        }
        if(choiceKetchup.getValue()==4){
            gastos+=2.0;
        }
        if(choiceKetchup.getValue()==5){
            gastos+=2.5;
        }
        if(choiceBarbacoa.getValue()==1){
            gastos+=0.5;
        }
        if(choiceBarbacoa.getValue()==2){
            gastos+=1.0;
        }
        if(choiceBarbacoa.getValue()==3){
            gastos+=1.5;
        }
        if(choiceBarbacoa.getValue()==4){
            gastos+=2.0;
        }
        if(choiceBarbacoa.getValue()==5){
            gastos+=2.5;
        }


        //iniciando las variables
        Double iva= gastos*0.21;
        Double pvp=gastos+iva;

        //añadindo as variables en el textoArea
        txtPrecio.setText(String.valueOf(gastos));
        txtIVA.setText(String.valueOf(iva));
        txtPVP.setText(String.valueOf(pvp));


        //la informacion de la compra o un error si el pedido es inferior a 8 Euros
        if(gastos>=8.0){
            //la informacion de la compra
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hola");
            alert.setContentText("Gracias por venir, tu pedido saldrá luego, el valor es: " +gastos);
            alert.showAndWait();
        }else{
            Alert alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setContentText("Hola, es necesario hacer un pedido como minino 8,00€");
            alert.showAndWait();
        }


    }

    //metodo de la clase initialize, muestra las opciones que tenemos en el choicebox
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceMostarda.setValue(0);
        choiceKetchup.setValue(0);
        choiceBarbacoa.setValue(0);
        choiceMostarda.getItems().addAll(numerossalsas);
        choiceKetchup.getItems().addAll(numerossalsas);
        choiceBarbacoa.getItems().addAll(numerossalsas);
    }
}
