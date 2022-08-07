package uz.ka5.pulishla.ui.fragment.calculatr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.ka5.pulishla.R
import uz.ka5.pulishla.databinding.FragmentCalculyatorBinding


class CalculyatorFragment : Fragment() {

private lateinit var binding:FragmentCalculyatorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCalculyatorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            bir.setOnClickListener {
                console.text= "${console.text}1"
            }
            ikki.setOnClickListener {
                console.text= "${console.text}2"
            }
            uch.setOnClickListener {
                console.text= "${console.text}3"
            }
            tort.setOnClickListener {
                console.text= "${console.text}4"
            }
            besh.setOnClickListener {
                console.text= "${console.text}5"
            }
            olti.setOnClickListener {
                console.text= "${console.text}6"
            }
            yetti.setOnClickListener {
                console.text= "${console.text}7"
            }
            sakkiz.setOnClickListener {
                console.text= "${console.text}8"
            }
            toqqiz.setOnClickListener {
                console.text= "${console.text}9"
            }
            nol.setOnClickListener {
                console.text= "${console.text}0"
            }

        }
    }

}