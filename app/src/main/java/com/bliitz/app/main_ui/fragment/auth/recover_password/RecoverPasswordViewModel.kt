package com.bliitz.app.main_ui.fragment.auth.recover_password

import android.app.Application
import androidx.lifecycle.*
import com.bliitz.app.ApplicationConstants
import com.bliitz.app.controller.user.UserControl
import com.bliitz.app.controller.user.UserServiceInterface
import com.bliitz.app.controller.webservice.config.ServiceResponse
import com.bliitz.app.global_model.User
import com.bliitz.app.global_ui.config_fragment.BaseAndroidViewModel
import com.bliitz.app.util.Preferences
import com.bliitz.app.util.SingleLiveEvent
import com.bliitz.app.util.extension.setValueAndNotify
import com.bliitz.app.util.validation.LoginValidator
import com.bliitz.app.util.validation.LoginValidatorInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecoverPasswordViewModel(
    application: Application,
    private val loginValidator: LoginValidatorInterface = LoginValidator(),
    private val userControl: UserServiceInterface = UserControl(),
    private val preferences: Preferences
) : BaseAndroidViewModel<RecoverPasswordViewModel.ViewState>(application, ViewState()) {

    val recoverResponseLiveData: LiveData<ServiceResponse<List<User>>> = SingleLiveEvent()

    constructor(application: Application) : this(
        application,
        LoginValidator(),
        UserControl(),
        Preferences(application)

    )

    data class ViewState(
        var isLoading: Boolean = false
    )

    fun recoverPassword(email: String) {

        if (!validateEmail(email))
            return

        val user = User()

        user.email = email
        user.token = ApplicationConstants.TOKEN

        viewModelScope.launch(Dispatchers.IO) {
            _viewState.setValueAndNotify { isLoading = true }
            val result = userControl.recoverPassword(user)
            (recoverResponseLiveData as SingleLiveEvent).postValue(result)
            _viewState.setValueAndNotify { isLoading = false }
        }
    }

    fun verifyTokenPassword(tokenPass: String) {

        val user = User()

        user.tokenPassword = tokenPass
        user.token = ApplicationConstants.TOKEN

        viewModelScope.launch(Dispatchers.IO) {
            _viewState.setValueAndNotify { isLoading = true }
            val result = userControl.verifyTokenPassword(user)
            (recoverResponseLiveData as SingleLiveEvent).postValue(result)
            _viewState.setValueAndNotify { isLoading = false }
        }
    }

    fun updatePasswordByToken(
        idUser: String,
        password: String,
        coPassword: String
    ) {

        if (!validatePassword(password))
            return

        if (!validatePasswordMatch(password, coPassword))
            return

        val user = User()
        val id = idUser
        user.id = preferences?.getUserData()!!.id
        user.password = password
        user.token = ApplicationConstants.TOKEN

        viewModelScope.launch(Dispatchers.IO) {
            _viewState.setValueAndNotify { isLoading = true }
            val result = userControl.updatePassword(user)
            (recoverResponseLiveData as SingleLiveEvent).postValue(result)
            _viewState.setValueAndNotify { isLoading = false }
        }
    }

    fun validateEmail(email: String?): Boolean {
        return if (loginValidator.isEmailValid(email)) {
            true
        } else {
            setErrorMessage("Atenção", "E-mail inválido.")
            false
        }
    }

    fun validatePassword(password: String?): Boolean {
        return if (!password.isNullOrBlank()) {
            true
        } else {
            setErrorMessage("Atenção", "Senha inválida.")
            false
        }
    }

    fun validatePasswordMatch(password1: String?, password2: String?): Boolean {
        return if (password1 == password2) {
            true
        } else {
            setErrorMessage("Atenção", "As senhas não são iguais.")
            false
        }
    }
}