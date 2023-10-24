package br.com.sprintum

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private val emails = mutableListOf("emailTeste@teste.com") // Adicionando o email padrão
    private val senhas = mutableListOf("senhaTeste") // Adicionando a senha padrão
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextSenha)
        val loginButton = findViewById<Button>(R.id.buttonEntrar)
        val textViewRegistreSe = findViewById<TextView>(R.id.textViewRegistreSe)

        loginButton.setOnClickListener {
            val enteredEmail = emailEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            if (emails.contains(enteredEmail) && senhas.contains(enteredPassword)) {
                // Login válido, abrir nova página ou atividade
                val intent = Intent(this, MainActivityPaginaInicial::class.java)
                startActivity(intent)
                Toast.makeText(this, "Bem Vindo!", Toast.LENGTH_SHORT).show()
            } else {
                // Exibir uma mensagem de erro
                Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_SHORT).show()
            }
        }

        textViewRegistreSe.setOnClickListener {
            // Redirecionar para a página de registro
            val intent = Intent(this, MainActivityRegistreSe::class.java)
            registrarResult.launch(intent)
        }
    }

    private val registrarResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val novoEmail = data?.getStringExtra("novoEmail")
            val novaSenha = data?.getStringExtra("novaSenha")

            if (!novoEmail.isNullOrBlank() && !novaSenha.isNullOrBlank()) {
                emails.add(novoEmail)
                senhas.add(novaSenha)
            }
        }
    }

}