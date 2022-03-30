package com.dzakyhdr.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.dzakyhdr.alertdialog.databinding.ActivityMainBinding
import com.dzakyhdr.alertdialog.databinding.CustomDialogLayoutBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancelable.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Dialog Cancelable")
                .setMessage("Ini bisa di tutup dengan klik bagian luar dialog")
                .setCancelable(true)
                .show()
        }

        binding.btnNonCancelable.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Dialog Non Cancelable")
                .setMessage("Dialog Non Cancelable harus ditutup dari tombol Action")
                .setCancelable(false)
                .setPositiveButton("Tutup") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        binding.btnPositiveNegative.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Dialog Dengan Button")
                .setMessage("Dialog Dengan Button untuk berbagai Aksi")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Oke") { dialog, _ ->
                    Toast.makeText(this, "Oke Diklik", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                .setNeutralButton("Lainnya") { dialog, _ ->
                    Snackbar.make(binding.root, "Neutral di Click", Snackbar.LENGTH_LONG).show()
                }
                .show()
        }

        binding.btnCustom.setOnClickListener {
            val bindingCustom = CustomDialogLayoutBinding.inflate(layoutInflater)
            val dialogBuilder = AlertDialog.Builder(this).setView(bindingCustom.root)

            val dialog = dialogBuilder.create()

            bindingCustom.btnYes.setOnClickListener {
                Toast.makeText(this, "Yes Di klik", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            bindingCustom.btnNo.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }

        binding.btnFragmentDialog.setOnClickListener {
            val dialog = DialogFragment()
            dialog.show(supportFragmentManager, "exit")
        }

    }
}