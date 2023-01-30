package com.example.libroturnos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MiTurnoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MiTurnoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_mi_turno, container, false)

        var b = v.findViewById<Button>(R.id.btnMiTurno)
        var txtLegajo = v.findViewById<TextView>(R.id.txtLegajo)
        var txtConductor = v.findViewById<TextView>(R.id.txtConductor)
        b.setOnClickListener{

            val listaConductores = leerConductores()
            val conductor = getConductor(txtLegajo.text.toString() ,listaConductores)
            if (conductor==null){
                txtConductor.text="legajo incorrecto"
            }else txtConductor.text = conductor.toString()

        }

        return v
    }

    fun leerConductores():MutableList<Conductor>{

        var listaConductores : MutableList<Conductor> = mutableListOf()

        try {
            val archivo = InputStreamReader(activity?.openFileInput("dgm2020"))
            val bufferedReader =  BufferedReader(archivo)
            val csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT);

            for (csvRecord in csvParser) {
                val legajo = csvRecord.get(1);
                val nombre = csvRecord.get(2);
                val diagrama = csvRecord.get(3);
                var franco = csvRecord.get(4);
                var c = Conductor(legajo.toInt(), nombre, Diagrama(diagrama,franco), franco, "",456 )
                c.getJornada()
                listaConductores.add(c)
            }

        }catch (e: Exception){Toast.makeText(context, "no se pudo abrir el archivo", Toast.LENGTH_LONG).show()}

        return listaConductores

    }
fun getConductor(legajo: String, listaConductores: MutableList<Conductor> ):Conductor?{

    var conductor: Conductor? = null

    for (condutor in listaConductores){
        if(legajo.toInt() == condutor.legajo) {
            conductor = condutor
            break
        }
    }
    return conductor

}




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MiTurnoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MiTurnoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}