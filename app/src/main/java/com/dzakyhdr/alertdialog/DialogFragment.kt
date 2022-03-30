package com.dzakyhdr.alertdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.dzakyhdr.alertdialog.databinding.DialogFragmentBinding
import com.google.android.material.snackbar.Snackbar
import layout.DialogDataReceiverFragment

class DialogFragment(): DialogFragment() {

    private var _binding: DialogFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnYes.setOnClickListener {
            val name = binding.edtData.text.toString()
            Toast.makeText(activity, name, Toast.LENGTH_SHORT).show()
            dialog?.dismiss()
        }

        binding.btnNo.setOnClickListener {
            dialog?.dismiss()
        }
    }
}