package com.nombreempresa.pamelacynthia;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<String> resultadoMutable;


    public LiveData<String> getResultadoMutable(){
        if(resultadoMutable==null){
            resultadoMutable=new MutableLiveData<>();
        }
        return resultadoMutable;
    }

    public void convertir(String valor1, String valor2, Boolean radio) {

        float valor = 0;

        float res = 0;

        if (valor1.length()== 0 && valor2.length() == 0 && (radio == false || radio == true)){

            resultadoMutable.setValue("No se pueden convertir valores vacios");
        }

        else if(valor1.length()> 0 && valor2.length() > 0 && (radio == false || radio == true)){
            resultadoMutable.setValue("No se pueden convertir 2 valores a la vez");
        }

        else if (valor1 != null && valor1.length() > 0 && valor2.length() == 0 && radio == false) {
            try {
                valor = Float.parseFloat(valor1);
                resultadoMutable.setValue("Error! No se pueden convertir dolares en Dolares ");
            } catch (Exception ex) {
                    resultadoMutable.setValue("Debe colocar Números");
                }
        }

        else if (valor2 != null && valor1.length() == 0 && radio == true) {
            try {
                valor = Float.parseFloat(valor2);
                resultadoMutable.setValue("Error! No se puede convertir euros en Euros");
                } catch (Exception ex) {
                resultadoMutable.setValue("Debe colocar Números");
                                       }
        }

        else if (valor1.length()>0  && valor2.length() == 0 && radio == true) {
            try {
                valor = Float.parseFloat(valor1);
                res = (float) (valor * 0.85);
                resultadoMutable.setValue(res + " Euros");
            } catch (Exception ex) {
                resultadoMutable.setValue("Debe colocar números");
            }
        }


        else if (valor2 != null && valor1.length() == 0 && radio == false) {
            try {
                valor = Float.parseFloat(valor2);
                res = (float) (valor * 1.18);
                resultadoMutable.setValue(res + " Dolares");
            } catch (Exception ex) {
                resultadoMutable.setValue("Debe colocar Números");
            }
        }




    }


    }

