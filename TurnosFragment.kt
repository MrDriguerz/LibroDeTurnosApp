package com.example.libroturnos

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TurnosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TurnosFragment : Fragment() {
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
        val v = inflater.inflate(R.layout.fragment_turnos, container, false)

        val base = arrayOf("Plaza Constitucion", "K5", "Remedios De Escalada", "Temperley", "Llavallol", "A.Korn", "La Plata", "Cañuelas" )
        val jornada = arrayOf(1,2,3,4,5,6)
        val semana = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
        val spnBase = v.findViewById<Spinner>(R.id.spnBase)
        val spnJornada = v.findViewById<Spinner>(R.id.spnJornada)
        val spnSemana = v.findViewById<Spinner>(R.id.spnSemana)
        val adtJBase = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, base)
        val adtJornada = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, jornada)
        val adtSemana = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, semana)
        spnBase.adapter = adtJBase
        spnJornada.adapter = adtJornada
        spnSemana.adapter = adtSemana
        val imagenTurno = v.findViewById<ImageView>(R.id.imagenTurno)
        val vecImg = arrayOf(R.drawable.i_501_1, R.drawable.i_501_2,R.drawable.i_501_3,R.drawable.i_501_4,R.drawable.i_501_5,R.drawable.i_501_6)

        if(imagenTurno!= null){
            try {
                imagenTurno.setImageResource(vecImg[0])

            }catch (e: Exception){v.findViewById<TextView>(R.id.txtViewTurnos).text = e.toString()}
        }else v.findViewById<TextView>(R.id.txtViewTurnos).text = "el imgView es null"




        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TurnosFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TurnosFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}