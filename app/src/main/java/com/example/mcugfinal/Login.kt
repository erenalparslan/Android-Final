package com.example.mcugfinal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

val dosyaYolu = "com.example.mcugfinal"
var anahtarIsim = "isim"
var anahtarSifre = "sifre"


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        progressBar.visibility = View.INVISIBLE

        var preferences = getSharedPreferences(dosyaYolu, Context.MODE_PRIVATE)
        var editor = preferences.edit()

        if (anahtarIsim != "") {
            loginIsim.setText(preferences.getString(anahtarIsim, ""))
            loginSifre.setText(preferences.getString(anahtarSifre, ""))

            if (loginIsim.text.toString() == "Eren Alparslan" && loginSifre.text.toString() == "02205076019") {
                progressBar.visibility = View.VISIBLE
                Toast.makeText(
                    applicationContext,
                    "Kaydedilmiş\n" +
                            "İsim: " + "${
                        preferences.getString(
                            anahtarIsim,
                            "isim"
                        )
                    }\n" + "Şifre: " + "${
                        preferences.getString(
                            anahtarSifre,
                            "sifre"
                        )
                    }\n" + "Unutma: true"  ,
                    Toast.LENGTH_SHORT
                ).show()
                Handler().postDelayed({
                    var gecis = Intent(this@Login, Menu::class.java)
                    startActivity(gecis)
                    finish()
                }, 1500)
            }
        }

        if(loginIsim.text.toString() == ""){
            Toast.makeText(applicationContext,"Kaydedilmiş\n"+"İsim: " + "Değer Yok\n" + "Şifre: " + "Değer Yok\n" + "Unutma: ${beniHatirla.isChecked}",Toast.LENGTH_SHORT).show()
        }

        beniHatirla.setOnCheckedChangeListener({ _, isChecked ->
            loginIsim.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {}
                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence, start: Int,
                    before: Int, count: Int
                ) {

                    if (loginIsim.text.toString() == "Eren Alparslan")
                        loginSifre.addTextChangedListener(object : TextWatcher {
                            override fun afterTextChanged(s: Editable) {}
                            override fun beforeTextChanged(
                                s: CharSequence, start: Int,
                                count: Int, after: Int
                            ) {
                            }

                            override fun onTextChanged(
                                s: CharSequence, start: Int,
                                before: Int, count: Int
                            ) {
                                if (loginSifre.text.toString() == "02205076019") {
                                    progressBar.visibility = View.VISIBLE
                                    if (isChecked) {
                                        editor.putString(anahtarIsim, loginIsim.text.toString())
                                        editor.putString(anahtarSifre, loginSifre.text.toString())
                                        editor.apply()
                                    }
                                    Handler().postDelayed({
                                        var gecis = Intent(this@Login, Menu::class.java)
                                        startActivity(gecis)
                                        finish()
                                    }, 1500)
                                }
                            }
                        })
                }
            })
        })
        loginSifre.addTextChangedListener(
            object : TextWatcher {
                override fun afterTextChanged(s: Editable) {}
                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence, start: Int,
                    before: Int, count: Int
                ) {
                    if (loginSifre.text.toString() == "02205076019") {
                        loginIsim.addTextChangedListener(object : TextWatcher {
                            override fun afterTextChanged(s: Editable) {}
                            override fun beforeTextChanged(
                                s: CharSequence, start: Int,
                                count: Int, after: Int
                            ) {
                            }

                            override fun onTextChanged(
                                s: CharSequence, start: Int,
                                before: Int, count: Int
                            ) {
                                if (loginIsim.text.toString() == "Eren Alparslan") {
                                    progressBar.visibility = View.VISIBLE
                                    Handler().postDelayed({
                                        var gecis = Intent(this@Login, Menu::class.java)
                                        startActivity(gecis)
                                        finish()
                                    }, 1500)
                                }
                            }
                        })
                    }
                }
            })
    }
}