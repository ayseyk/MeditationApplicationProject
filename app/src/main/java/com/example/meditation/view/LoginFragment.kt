package com.example.meditation.view

import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.meditation.R
import com.example.meditation.databinding.FragmentLoginBinding
import java.util.regex.Pattern

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding
    private var showPwd = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
        //inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changePasswordTextForm()

        binding.btnContinue.setOnClickListener {
            val userName = binding.usernameIn.text.toString()
            val password = binding.passwordIn.text.toString()
            val passwordShouldBe = ("(?=.*[0-9])(?=.*[A-Z])").toRegex()
            val patern = Pattern.compile("(.*[0-9].*)(.*[A-Z].*)(.*[a-z].*)")
            val patern4 = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])$")
            if(userName.length <= 2){
                Toast.makeText(context,"Username should be long more than two characters!", Toast
                    .LENGTH_SHORT).show()
            }
            else if(/*password.length > 6 &&*/ patern.matcher(password).matches()){
                val action = LoginFragmentDirections.actionLoginToHome()
                Navigation.findNavController(it).navigate(action)
            }
            else{
               Toast.makeText(context,"Password should consist minimum 6 characters with at least 1 uppercase character, 1 number!", Toast
                    .LENGTH_SHORT).show()
            }
        }
    }

    private fun changePasswordTextForm() {
        binding.btnShowPwd.setOnClickListener {
            if(showPwd){
                binding.passwordIn.transformationMethod = PasswordTransformationMethod.getInstance()
                showPwd = false
            }
            else{
                binding.passwordIn.transformationMethod =  HideReturnsTransformationMethod.getInstance()
                showPwd = true
            }
        }
    }
}