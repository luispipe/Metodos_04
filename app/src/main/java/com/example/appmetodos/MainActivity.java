package com.example.appmetodos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //Una Clase (class) puede tener n cantidad de funciones o metodos

    TextView tv_imc,tv_classification;
    EditText name, weight, height;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_imc= findViewById(R.id.tvIMC);
        tv_classification=findViewById(R.id.tvClassification);
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
                    claficacionIMC(imcResult);
                }
            }
        });


    }
    /*Definición de variables y constantes
    *Variables:
    1. tipo de dato ->  Nativos:String,char,boolean,byte,short,int,lon,float,double
                    ->  otros tipos: Button,Intent,TextView,EditText

    2. Nombre ->  Solo carácteres alfanúmericos
              ->  Se permite el uso del _
              ->  Un nombre no puede iniciar con números
              ->  No se pueden definir nombres de variables iguales
                  a palabras reservadas del sistemas. Ej: for,if,public,protected,private,final,while,else,etc.
              -> No puedo tener dos variables con el mismo nombre
              -> Las variables comienzan por minuscula
    3. Asignar un valor -> el valor debe ser del mismo tipo de dato de la variable
                        -> Esto no aplica para tipo de dato double que recibe cualquier tipo de dato de enteros

    Ejemplos: String nombre="Luis";
              int edad= 30;
              double estatura= 170;
              boolean esMayorEdad= true;

    Constantes:
    1. Agregar la etiqueta final
    2. tipo de dato ->  Nativos:String,char,boolean,byte,short,int,lon,float,double
                    ->  otros tipos: Button,Intent,TextView,EditText
    2. Nombre ->  Solo carácteres alfanúmericos
              ->  Se permite el uso del _
              ->  Un nombre no puede iniciar con números
              ->  No se pueden definir nombres de constantes iguales
                  a palabras reservadas del sistemas. Ej: for,if,public,protected,private,final,while,else,etc.
              -> No puedo tener dos constantes con el mismo nombre
              -> El nombre de las constantes va por completo en mayuscula

    3. Asignar un valor -> el valor debe ser del mismo tipo de dato de la variable
                        -> Esto no aplica para tipo de dato double que recibe cualquier tipo de dato de enteros

    Ejemplos: final String UNIVERSIDAD="Universidad Nacional de Colombia";
              final int NIT= 87463214;
      */

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
        //Redondear o limitar los decimales del imc
        double imc2= Math.round(imc*100d)/100d;
        tv_imc.setText("El usuario: "+nombre+ ", tiene un IMC de "+imc2);
        //Dentro de String hay una función de concatenar o combinar (+)
        // 55+""="55",  25.5 +"Hola"= "25.5Hola"
    }

    //Metodo que permita definir la clasificación del IMC de un usuario

    public void claficacionIMC(double imc){
        if(imc<18.5){
            tv_classification.setText("Bajo Peso");
            tv_classification.setTextColor(Color.YELLOW);
        } else if (imc>=18.5 && imc<24.99) {
            tv_classification.setText("Peso Normal");
            tv_classification.setGravity(Gravity.CENTER);
            tv_classification.setTextColor(Color.GREEN);
        } else if (imc>=25 && imc<30) {
            tv_classification.setText("Sobrepeso");
            tv_classification.setTextColor(Color.MAGENTA);
        } else if (imc>=30) {
            tv_classification.setText("Obesidad");
            tv_classification.setTextColor(Color.RED);
        } else {
            tv_classification.setText("No se pudo calcular el IMC");
            tv_classification.setTextColor(Color.CYAN);
        }
    }




}