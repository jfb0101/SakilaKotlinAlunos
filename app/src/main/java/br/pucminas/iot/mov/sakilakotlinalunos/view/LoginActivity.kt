package br.pucminas.iot.mov.sakilakotlinalunos.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import br.pucminas.iot.mov.sakilakotlinalunos.R
import br.pucminas.iot.mov.sakilakotlinalunos.use_cases.security.ILoginUseCase
import br.pucminas.iot.mov.sakilakotlinalunos.use_cases.security.LoginUseCase
import br.pucminas.iot.mov.sakilakotlinalunos.use_cases.security.LoginUseCaseFake
import br.pucminas.iot.mov.sakilakotlinalunos.use_cases.security.LoginUseCaseInput
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var loginUsecase: ILoginUseCase
    private lateinit var txtUsername: EditText
    private lateinit var txtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var scope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginUsecase = LoginUseCase()

        scope = CoroutineScope(Job() + Dispatchers.Main)

        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            scope.launch {
                var loginResult = loginUsecase(LoginUseCaseInput(txtUsername.text.toString(), txtPassword.text.toString()))

                Log.d("LoginActivity",loginResult.Token)

                startActivity(Intent(this@LoginActivity, ListFilmsActivity::class.java))
            }
        }
    }


}