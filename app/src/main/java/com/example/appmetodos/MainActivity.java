package com.example.appmetodos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //Una Clase (class) puede tener n cantidad de funciones o metodos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //Dentro de String hay una función de concatenar o combinar (+)
        // 55+""="55",  25.5 +"Hola"= "25.5Hola"
    }





}