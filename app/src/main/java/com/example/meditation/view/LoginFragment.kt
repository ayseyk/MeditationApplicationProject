package com.example.meditation.view

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.meditation.R
import com.example.meditation.databinding.FragmentLoginBinding
import com.example.meditation.util.Util
import com.example.meditation.util.Util.Companion.MIN_PASSWORD_LENGTH
import com.example.meditation.util.Util.Companion.MIN_USERNAME_LENGTH
import com.example.meditation.util.Util.Companion.REGEX_AT_LEAST_ONE_DIGIT
import com.example.meditation.util.Util.Companion.REGEX_AT_LEAST_ONE_UPPERCASE

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var showPassword = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changePasswordTextForm()
        initializeEvents()
    }

    private fun initializeEvents() {
        binding.btnContinue.setOnClickListener {
            val userName = binding.usernameIn.text.toString()
            val password = binding.passwordIn.text.toString()
            val prefs = Util(requireContext())
            when {
                userName.length <= MIN_USERNAME_LENGTH -> {
                    Toast.makeText(
                        context,
                        resources.getString(R.string.shortUserName),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                isPasswordValid(password) -> {
                    prefs.storeUserName(userName)
                    val action = LoginFragmentDirections.actionLoginToHome()
                    Navigation.findNavController(it).navigate(action)
                }
                else -> {
                    Toast.makeText(
                        context,
                        resources.getString(R.string.invalidPassword),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun isPasswordValid(password: String) = password.length >= MIN_PASSWORD_LENGTH
            && password.contains(Regex(REGEX_AT_LEAST_ONE_UPPERCASE))
            && password.contains(Regex(REGEX_AT_LEAST_ONE_DIGIT))

    private fun changePasswordTextForm() {
        binding.btnShowPwd.setOnClickListener {
            if (showPassword) {
                binding.passwordIn.transformationMethod = PasswordTransformationMethod.getInstance()
                showPassword = false
            } else {
                binding.passwordIn.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                showPassword = true
            }
        }
    }
}