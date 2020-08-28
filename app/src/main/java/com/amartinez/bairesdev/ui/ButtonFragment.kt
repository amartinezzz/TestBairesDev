package com.amartinez.bairesdev.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.amartinez.bairesdev.R
import com.amartinez.bairesdev.databinding.FragmentButtonsBinding

class ButtonFragment: Fragment() {
    private lateinit var binder: FragmentButtonsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = DataBindingUtil.inflate(inflater,
            R.layout.fragment_buttons, container, false)
        retainInstance = true
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.bToast.setOnClickListener{
            Toast.makeText(requireContext(),
                R.string.buttons_message, Toast.LENGTH_SHORT).show()
        }

        binder.bAlert.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle(R.string.buttons_alert)
            builder.setMessage(R.string.buttons_message)
            builder.setPositiveButton(android.R.string.yes) { dialog, _ ->
                dialog.dismiss()
            }
            builder.show()
        }
    }
}