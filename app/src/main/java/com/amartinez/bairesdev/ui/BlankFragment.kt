package com.amartinez.bairesdev.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.amartinez.bairesdev.R
import com.amartinez.bairesdev.databinding.FragmentBlankBinding

class BlankFragment: Fragment() {
    private lateinit var binder: FragmentBlankBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = DataBindingUtil.inflate(inflater,
            R.layout.fragment_blank, container, false)
        retainInstance = true
        return binder.root
    }
}