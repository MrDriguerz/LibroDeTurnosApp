package com.example.libroturnos

data class Conductor(val legajo: Int, val nombre: String, var diagrama: Diagrama, var franco: String, val email: String, val telefono: Long)
{

    val semana = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    var jornadaaux = getJornada() //arrayOf("","","","","","","")
    lateinit var pedidoDeDiagrama : MutableList<Diagrama>








    override fun toString(): String
    {

        return  legajo.toString() + " " +
                nombre + " " +
                diagrama.numero + " " +
                "Franco:" + " " + diagrama.franco + "\n"+
                "Jornada:\n" +
                diagrama.numero + "." + "1" + " "+ jornadaaux[1] + "\n"+
                diagrama.numero + "." + "2" + " "+ jornadaaux[2] + "\n"+
                diagrama.numero + "." + "3" + " "+ jornadaaux[3] + "\n"+
                diagrama.numero + "." + "4" + " "+ jornadaaux[4] + "\n"+
                diagrama.numero + "." + "5" + " "+ jornadaaux[5] + "\n"+
                diagrama.numero + "." + "6" + " "+ jornadaaux[6]
                //"$legajo $nombre $diagrama $franco"
    }


   fun getJornada():Array<String>{

    var i = 0
    var j = 0
    var contador = 0
    var flag = false
    var jornada = arrayOf("","","","","","","")

    for (dia in semana){

        if(dia == franco){
            flag = true
        }
        if(flag){
            jornada[contador] = dia
            contador++
        }/*else{
            jornada[i] = dia
            i--
        }*/

    }
    while (contador <= 6){
        jornada[contador] = semana[i]
        contador++
        i++
    }
       return jornada
}
}

