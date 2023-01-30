package com.example.libroturnos


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.nio.file.Paths


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

try {
   // var listaConductor = leerConductores()

    /*for (c in listaConductor)
    {
        txtView.append(c.toString() + "\n")
    }*/




    //val bufferedReader =  BufferedReader(FileReader(Environment.DIRECTORY_DOWNLOADS + "dgm2020.CSV"))
    //txtView.text=leerArchivo().get(2).toString()

}catch ( e : Exception  ){ e.toString()}//Toast.makeText(this,e.toString(),Toast.LENGTH_LONG) }








                //onCreateOptionsMenu()

    }
    //Funciones de la barra de menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_res, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val frgMiTurno = MiTurnoFragment()
        val frgTurnos = TurnosFragment()
        val frgTrenes = TrenesFragment()
        val frgPedidoDeDiagrama = PedidoDeDiagramaFragment()
        val transaction = supportFragmentManager.beginTransaction()
        val id = item.itemId

        when(id)
        {
            R.id.MiTurno->onClickMiTurno(frgMiTurno,transaction )//transaction.replace(R.id.frameLayout,frgMiTurno).commit()
            R.id.Turnos->onClickTurno(frgTurnos,transaction)//transaction.replace(R.id.frameLayout,frgTurnos).commit()
            R.id.Trenes->onClickTrenes(frgTrenes,transaction)//transaction.replace(R.id.frameLayout,frgTrenes).commit()
            R.id.Pedido->onClickPedidoDeDiagramas(frgPedidoDeDiagrama,transaction)
        }

        return super.onOptionsItemSelected(item)
    }
    //Funciones de los archivos
    fun escribirArchivo(v: View){

       val archivoescritura = OutputStreamWriter(openFileOutput("dgm2020", Activity.MODE_PRIVATE))
       archivoescritura.write(
               "1,30552,BERTOLUCCI JAVIER,564,Miércoles\n" +
                   "2,30256,SASIAIN GABRIEL,523,Miércoles\n" +
                   "3,31004,DOTTAVIO SERGIO,532,Viernes\n" +
                   "4,31286,DE SARRO NESTOR, 567,Martes\n" +
                   "5,32302,SANTOS ANDRES,502,Sábado\n" +
                   "6,32309,ARAÑA ADRIAN,539,Viernes\n" +
                   "7,32310,PARAVAGNA FABIAN,Prog.2,Lunes\n" +
                   "8,32314,DE LUCA ADRIAN,563,Miércoles\n" +
                   "9,32490,VEGA JUAN,535,Jueves\n" +
                   "10,32494,RAMOS MARIO,565,Sábado\n")

       archivoescritura.close()
      // v.findViewById<TextView>(R.id.textView).text = archivoescritura.encoding.toString()
       //Toast.makeText(this, archivoescritura.encoding, Toast.LENGTH_LONG)

   }
    fun leerConductores():MutableList<Conductor>{
        val archivo = InputStreamReader(openFileInput("dgm2020"))
        val bufferedReader =  BufferedReader(archivo)
        val csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT);
        var listaConductores : MutableList<Conductor> = mutableListOf()

        for (csvRecord in csvParser) {
            val legajo = csvRecord.get(1);
            val nombre = csvRecord.get(2);
            val diagrama = csvRecord.get(3);
            var franco = csvRecord.get(4);
            var c = Conductor(legajo.toInt(), nombre, Diagrama(diagrama,franco), franco, "",456 )
            listaConductores.add(c)
        }
       return listaConductores

   }
    //Fragments
    fun onClickMiTurno(fragment: MiTurnoFragment, transaction: FragmentTransaction){

        var listaConductores = leerConductores()


        transaction.replace(R.id.frameLayout, fragment).commit()
    }
    fun onClickTurno(fragment: TurnosFragment, transaction: FragmentTransaction){

        transaction.replace(R.id.frameLayout, fragment).commit()
    }
    fun onClickTrenes(fragment: TrenesFragment, transaction: FragmentTransaction){

        transaction.replace(R.id.frameLayout, fragment).commit()
    }
    fun onClickPedidoDeDiagramas(fragment: PedidoDeDiagramaFragment, transaction: FragmentTransaction){

        transaction.replace(R.id.frameLayout, fragment).commit()
    }
    //Pedido de Diagrama

    fun asignarDiagrama(conductor: Conductor){

        var listaDeDiagramas : MutableList<Diagrama>  = mutableListOf()
        var listaDeConductores: MutableList<Conductor>

        for(pedido in conductor.pedidoDeDiagrama){

            for (diagrama in listaDeDiagramas){

                if(pedido == diagrama){

                    conductor.diagrama = pedido
                    conductor.franco = pedido.franco
                    listaDeDiagramas.remove(pedido)
                    break
                }
            }

        }



    }

}
