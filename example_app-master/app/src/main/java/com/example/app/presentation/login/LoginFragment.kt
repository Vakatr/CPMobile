package com.example.app.presentation.login

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.app.R
import com.example.app.data.api.models.response.TokenResponse
import kotlinx.android.synthetic.main.error_component.*
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.core.KoinComponent
import org.koin.core.get

class LoginFragment : Fragment(), KoinComponent {
    lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        bt_login_login.setOnClickListener {
/*            get<LoginViewModel>().login(
                et_login_name.text.toString(),
                et_login_password.text.toString()
            ).subscribe(
                { token : TokenResponse? -> processLogin() },
                { thr : Throwable? -> processError() }
            )*/
            processLogin()
        }
    }

    private fun processLogin() {
        navController.navigate(R.id.action_loginFragment_to_feedFragment)
    }

    private fun processError() {
        showMessage(
            getString(R.string.error_login),
            activity?.let { ContextCompat.getDrawable(it, R.drawable.error_message_background) }
        )
    }

    private fun showMessage(text: String, background: Drawable?) {
        view?.findViewById<LinearLayout>(R.id.error_layout)?.let {
            error_text.text = text
            error_layout.visibility = View.VISIBLE
        }
    }
}