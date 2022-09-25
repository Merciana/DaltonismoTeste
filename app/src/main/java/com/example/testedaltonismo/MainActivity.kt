package com.example.testedaltonismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.testedaltonismo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    val setResposta1Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
       result ->
        if (result.resultCode == RESULT_OK){
            binding.textViewR1.text = result.data?.getStringExtra("result").toString()
        }else{
            Toast.makeText(this,"Cancelado", Toast.LENGTH_SHORT).show()
        }
    }

    val setResposta2Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == RESULT_OK){
            binding.textViewR2.text = result.data?.getStringExtra("result").toString()
        }else{
            Toast.makeText(this,"Cancelado", Toast.LENGTH_SHORT).show()
        }
    }

    val setResposta3Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == RESULT_OK){
            binding.textViewR3.text = result.data?.getStringExtra("result").toString()
        }else{
            Toast.makeText(this,"Cancelado", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        binding.buttontest1.setOnClickListener {
            val intent = Intent(this, Testes::class.java)

            val bundle = Bundle()
            bundle.putString("opcao", "buttontest1")
            intent.putExtras(bundle)
            setResposta1Launcher.launch(intent)


        }
        binding.buttontest2.setOnClickListener {
            val intent = Intent(this, Testes::class.java)

            val bundle = Bundle()
            bundle.putString("opcao", "buttontest2")
            intent.putExtras(bundle)

            setResposta2Launcher.launch(intent)
        }

        binding.buttontest3.setOnClickListener {
            val intent = Intent(this, Testes::class.java)

            val bundle = Bundle()
            bundle.putString("apcao", "buttontest3")
            intent.putExtras(bundle)

            setResposta3Launcher.launch(intent)
        }

        binding.buttonVerificar.setOnClickListener {
            if(binding.textViewR1.text == "" || binding.textViewR2.text == "" || binding.textViewR3.text == ""){
                Toast.makeText(this, "Faça seu teste!", Toast.LENGTH_SHORT).show()
            }else if (binding.textViewR1.text == "29" || binding.textViewR2.text == "74" || binding.textViewR3.text == "8"){
                binding.textViewResultado.text = "Normal!"
            }else{
                binding.textViewResultado.text = "Procure um Médico!"
            }
        }

    }
}