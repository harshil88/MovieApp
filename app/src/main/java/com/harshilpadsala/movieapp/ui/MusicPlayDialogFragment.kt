package com.harshilpadsala.movieapp.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.harshilpadsala.movieapp.R

class MusicPlayDialogFragment : DialogFragment() {

    internal lateinit var listener: MusicPlayDialogListener

    interface MusicPlayDialogListener{

        fun onDialogPositiveClick(dialogFragment: DialogFragment)
        fun onDialogNegativeClick(dialogFragment: DialogFragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as MusicPlayDialogListener
        }
        catch (e : ClassCastException){
            throw ClassCastException((context.toString()) + "Must Implement Listners")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return requireActivity().let {
            val builder = AlertDialog.Builder(it)
            val inflator = requireActivity().layoutInflater
            builder.setView(
                inflator.inflate(R.layout.music_pop_up_window , null)
            ).setPositiveButton("PLAY" , DialogInterface.OnClickListener{
                dialog, id -> listener.onDialogPositiveClick(this)
            }
            ).setNegativeButton("STOP" , DialogInterface.OnClickListener{
                dialog, id -> listener.onDialogNegativeClick(this)
            }
            )
            builder.create()
        }
    }
}