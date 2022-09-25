package com.example.testedaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.testedaltonismo.databinding.ActivityTestesBinding

class Testes : AppCompatActivity() {

    lateinit var binding:ActivityTestesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_testes)

        var params:Bundle? = intent.extras
        var opcao = params?.getString("opcao")
        if (opcao.toString() == "buttontest1") {
            binding.imageView.setImageResource(R.drawable.primeiro)
        }else if (opcao.toString() == "buttontest2") {
            binding.imageView.setImageResource(R.drawable.segundo)
        }else if (opcao.toString() == "buttontest3") {
            binding.imageView.setImageResource(R.drawable.terceiro)
        }



        binding.buttonok.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()

            bundle.putString("result", binding.editTextResultado.text.toString())
            intent.putExtras(bundle)

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        binding.buttonCancelar.setOnClickListener {
            Toast.makeText(this, "cancelado", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}