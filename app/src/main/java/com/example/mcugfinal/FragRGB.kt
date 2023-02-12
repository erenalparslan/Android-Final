package com.example.mcugfinal

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.fragment_frag_r_g_b.*
import kotlinx.android.synthetic.main.fragment_frag_snack.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragRGB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragRGB : Fragment() {
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

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        var redValue = seekBarRed.getProgress()
        var greenValue = seekBarGreen.getProgress()
        var blueValue = seekBarBlue.getProgress()

        //SeekBar'ların max değerlerini 255 olarak set ediyoruz.

        //SeekBar'ların max değerlerini 255 olarak set ediyoruz.
        seekBarRed.setMax(255)
        seekBarGreen.setMax(255)
        seekBarBlue.setMax(255)

        //Arkaplanın başlangıç rengini set ediyoruz.

        //Arkaplanın başlangıç rengini set ediyoruz.

        background.setBackgroundColor(Color.rgb(redValue,greenValue,blueValue))

        seekBarRed.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(
                seekBar: SeekBar, progress: Int,
                fromUser: Boolean
            ) {
                //Arkaplanı yeni değere göre set ediyoruz.

                val hex = java.lang.String.format("#%02X%02X%02X", seekBarRed.progress, seekBarGreen.progress, seekBarBlue.progress)
                textView.setText(hex)
                redValue = progress
                background.setBackgroundColor(Color.argb(255,redValue, greenValue, blueValue))


            }
        })

        seekBarGreen.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(
                seekBar: SeekBar, progress: Int,
                fromUser: Boolean
            ) {
                //Arkaplanı yeni değere göre set ediyoruz.
                val hex = java.lang.String.format("#%02X%02X%02X", seekBarRed.progress, seekBarGreen.progress, seekBarBlue.progress)
                textView.setText(hex)
                greenValue = progress
                background.setBackgroundColor(Color.argb(255,redValue, greenValue, blueValue))
            }
        })

        seekBarBlue.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(
                seekBar: SeekBar, progress: Int,
                fromUser: Boolean
            ) {
                //Arkaplanı yeni değere göre set ediyoruz.
                val hex = java.lang.String.format("#%02X%02X%02X", seekBarRed.progress, seekBarGreen.progress, seekBarBlue.progress)
                textView.setText(hex)
                blueValue = progress
                background.setBackgroundColor(Color.argb(255,redValue, greenValue, blueValue))
            }
        })


    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_r_g_b, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragRGB.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragRGB().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}