package com.example.appmetodos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Una Clase (class) puede tener n cantidad de funciones o metodos

    TextView tv_imc;
    EditText name, weight, height;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_imc= findViewById(R.id.tvIMC);
        name=findViewById(R.id.etName);
        weight=findViewById(R.id.etWeight);
        height=findViewById(R.id.etHeight);
        calculate=findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtengo el texto de los campos de la app
                String nameText= name.getText().toString();
                String weightText= weight.getText().toString();
                String heightTexto= height.getText().toString();
                //Validar que los textos no esten vacios
                //String tiene un metodo para validar si es vacio
                if (nameText.isEmpty() || weightText.isEmpty() || heightTexto.isEmpty()){
                    Toast.makeText(getBaseContext(),"Todos los campos deben llenarse",
                            Toast.LENGTH_LONG).show();
                }else{
                    //Convertir texto a double
                    double peso= Double.parseDouble(weightText);
                    double altura= Double.parseDouble(heightTexto);
                    double imcResult= calcularIMC(peso,altura);
                    message(imcResult,nameText);
                }
            }
        });


    }

    //Declaración de metodos
    //Primero va el nivel de acceso(public,protected,privado,default)
    //Por lo general se utiliza public o protected
    //private solo se utiliza en funciones que tienen secretos institucionales, una grado de seguridad alto
    //default no es una buena práctica

    /*Segundo va el Tipo de dato del metodo
    * int,String,double,boolean,Button,TextView, etc --> nos obliga a retornar(return)
    * o devolver un resultado del mismo tipo de dato

    * Cuando no se debe returnar nada solo realizar acciones se utiliza el tipo de dato
    (void)

    * Tercero se asigna el nombre del metodo
    * Los nombres solo pueden tener carácteres alfanúmericos y _

    *Cuarto parametros, estos son los datos que requerimos para poder solucionar
    * un problema y van dentro de () y se separan por , .
    * un metodo puede tener o no parametros.
    * Los parametros que se coloquen deben tener un tipo de dato y nombre del parametro

    *Quinto se abren las llaves {} y dentro se realiza el código fuente para
    * realizar la funcionalidad que se espera de dicho metodo.
    *

    *Sexto en caso de que el tipo de dato del metodo sea diferente a void
    * se deber return un reusltado
    *  (return valor del tipo de dato del metodo)
    *
    * */

    /* Usted esta desarrollando una aplicación para definir dietas alimenticias
    *  Entonces para iniciar requiere que la app calcule el IMC con los datos
    *  de peso y altura que el usuario registro la app.
    * */

    public double calcularIMC(double peso,double altura){
        double imc= peso/(altura*altura);//imc= peso/altura^2
        return imc;
    }

    //Un método que al llamarlo me devuelva un saludo con mi nombre
    String saludar(String nombre){
        return "Buenos días "+nombre;
    }

    //un método que dado el IMC y el nombre del usuario genera un mensaje

    //Entrada: 40,Luis
    protected void message(double imc, String nombre){
        System.out.println("El usuario: "+nombre+ ", tiene un IMC de "+imc);
        // "El usuario: Luis, tiene un IMC de 40"
        tv_imc.setText("El usuario: "+nombre+ ", tiene un IMC de "+imc);
        //Dentro de String hay una función de concatenar o combinar (+)
        // 55+""="55",  25.5 +"Hola"= "25.5Hola"
    }





}