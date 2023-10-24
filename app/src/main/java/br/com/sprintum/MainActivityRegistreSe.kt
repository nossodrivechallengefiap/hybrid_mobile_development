package br.com.sprintum

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivityRegistreSe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_registre_se)

        val nomeEditText = findViewById<EditText>(R.id.editTextNome)
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val senhaEditText = findViewById<EditText>(R.id.editTextSenha)
        val cepEditText = findViewById<EditText>(R.id.editTextCep)
        val estadoEditText = findViewById<EditText>(R.id.editTextEstado)
        val logradouroEditText = findViewById<EditText>(R.id.editTextLogradouro)
        val numeroEditText = findViewById<EditText>(R.id.editTextNumero)
        val complementoEditText = findViewById<EditText>(R.id.editComplemento)
        val bairroEditText = findViewById<EditText>(R.id.editTextBairro)
        val cidadeEditText = findViewById<EditText>(R.id.editTextCidade)
        val registrarButton = findViewById<Button>(R.id.buttonRegistrarSe)
        val textViewEntrar = findViewById<TextView>(R.id.textViewEntrar)

        registrarButton.setOnClickListener {
            val novoEmail = emailEditText.text.toString()
            val novaSenha = senhaEditText.text.toString()

            if (novoEmail.isNotBlank() && novaSenha.isNotBlank()) {
                val resultIntent = Intent()
                resultIntent.putExtra("novoEmail", novoEmail)
                resultIntent.putExtra("novaSenha", novaSenha)
                setResult(Activity.RESULT_OK, resultIntent)

                Toast.makeText(this, "Cadastro realizado com sucesso! Faça o login", Toast.LENGTH_SHORT).show()

                finish()
            }
        }

        textViewEntrar.setOnClickListener {
            // Redirecionar para a página de registro
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}