package com.example.libroturnos

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.get
import java.lang.System.out

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PedidoDeDiagramaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PedidoDeDiagramaFragment : Fragment() {
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
        var v = inflater.inflate(R.layout.fragment_pedido_de_diagrama, container, false)
        var txtPedidodeDiagrama = v.findViewById<TextView>(R.id.txtPedidoDeDiagrama)
        var listaDeDiagrama = getListaDeDiagrama()

        var spnDiagrama1 = v.findViewById<Spinner>(R.id.spnDiagramas1)
        var spnDiagrama2 = v.findViewById<Spinner>(R.id.spnDiagramas2)
        var spnDiagrama3 = v.findViewById<Spinner>(R.id.spnDiagramas3)
        var spnDiagrama4 = v.findViewById<Spinner>(R.id.spnDiagramas4)
        var spnDiagrama5 = v.findViewById<Spinner>(R.id.spnDiagramas5)
        var spnDiagrama6 = v.findViewById<Spinner>(R.id.spnDiagramas6)
        var spnDiagrama7 = v.findViewById<Spinner>(R.id.spnDiagramas7)
        var spnDiagrama8 = v.findViewById<Spinner>(R.id.spnDiagramas8)
        var spnDiagrama9 = v.findViewById<Spinner>(R.id.spnDiagramas9)
        var spnDiagrama10 = v.findViewById<Spinner>(R.id.spnDiagramas10)
        var spnDiagrama11 = v.findViewById<Spinner>(R.id.spnDiagramas11)
        var spnDiagrama12 = v.findViewById<Spinner>(R.id.spnDiagramas12)
        var spnDiagrama13 = v.findViewById<Spinner>(R.id.spnDiagramas13)
        var spnDiagrama14 = v.findViewById<Spinner>(R.id.spnDiagramas14)
        var spnDiagrama15 = v.findViewById<Spinner>(R.id.spnDiagramas15)
        var spnDiagrama16 = v.findViewById<Spinner>(R.id.spnDiagramas16)
        val adapter1 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter2 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter3 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter4 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter5 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter6 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter7 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter8 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter9 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter10 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter11 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter12 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter13 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter14 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter15 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        val adapter16 = ArrayAdapter(v.context,android.R.layout.simple_spinner_item, listaDeDiagrama)
        spnDiagrama1.adapter = adapter1
        spnDiagrama2.adapter = adapter2
        spnDiagrama3.adapter = adapter3
        spnDiagrama4.adapter = adapter4
        spnDiagrama5.adapter = adapter5
        spnDiagrama6.adapter = adapter6
        spnDiagrama7.adapter = adapter7
        spnDiagrama8.adapter = adapter8
        spnDiagrama9.adapter = adapter9
        spnDiagrama10.adapter = adapter10
        spnDiagrama11.adapter = adapter11
        spnDiagrama12.adapter = adapter12
        spnDiagrama13.adapter = adapter13
        spnDiagrama14.adapter = adapter14
        spnDiagrama15.adapter = adapter15
        spnDiagrama16.adapter = adapter16



        txtPedidodeDiagrama.findViewById<TextView>(R.id.txtPedidoDeDiagrama)


        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PedidoDeDiagramaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PedidoDeDiagramaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun getListaDeDiagrama(): Array<String> {
        return  arrayOf(
            "501 Lunes",
            "501 Martes",
            "501 Miercoles",
            "501 Jueves",
            "501 Viernes",
            "501 Sabado",
            "501 Domingo",
            "502 Lunes",
            "502 Martes",
            "502 Miercoles",
            "502 Jueves",
            "502 Viernes",
            "502 Sabado",
            "502 Domingo",
            "503 Lunes",
            "503 Martes",
            "503 Miercoles",
            "503 Jueves",
            "503 Viernes",
            "503 Sabado",
            "503 Domingo",
        )
    }
}