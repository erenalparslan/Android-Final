package com.example.mcugfinal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.cikis.*

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var preferences1 = getSharedPreferences("com.example.mcugfinal", Context.MODE_PRIVATE)
        var editor = preferences1.edit()
        fun fragmentGecis(menuFrag: Fragment) {
            var gecis = supportFragmentManager.beginTransaction()
            gecis.replace(R.id.background1, menuFrag)
            gecis.commit()
        }

        val popupMenu = PopupMenu(
            this, menuButton
        )
        menuButton.setOnClickListener {
            popupMenu.show()
        }
        popupMenu.menuInflater.inflate(R.menu.menu_popup, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            val id = menuItem.itemId
            if (id == R.id.menu_rgb) {
                fragmentGecis(FragRGB())
            }
            if (id == R.id.menu_snack) {
                fragmentGecis(FragSnack())
            }
            if (id == R.id.menu_cikis) {

                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setCancelable(false)
                alertDialog.setTitle("Çıkış")
                alertDialog.setMessage("Çıkmak istediğinize emin misiniz ?")
                alertDialog.setPositiveButton("Evet") { dialog, which ->
                    editor.remove(anahtarIsim)
                    editor.remove(anahtarSifre)
                    editor.apply()
                    Handler().postDelayed({
                        var gecis = Intent(this@Menu, Login::class.java)
                        startActivity(gecis)
                        finish()
                    }, 1000)

                }
                alertDialog.show()
            }
            false
        }
    }
}