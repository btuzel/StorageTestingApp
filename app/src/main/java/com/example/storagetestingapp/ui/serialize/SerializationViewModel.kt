package com.example.storagetestingapp.ui.serialize

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storagetestingapp.model.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.storagetestingapp.repo.FileRepository
import java.io.Serializable

class SerializationViewModel : ViewModel() {

    val toastViewModel = MutableLiveData<String>()
    val reviveViewModel = MutableLiveData<Person>()

    fun onSaveObject(objectToWrite: Serializable, filename: String) = viewModelScope.launch {
        val isFileSaved = withContext(Dispatchers.IO) {
            FileRepository.serializeObject(objectToWrite, filename)
        }
        toastViewModel.postValue(if (isFileSaved) "Object saved!" else "Failed to save object!")

    }

    fun onReviveObject(filename: String) = viewModelScope.launch {
        val person = withContext(Dispatchers.IO) {
            FileRepository.deserializeObject(filename) as? Person
        }
        toastViewModel.postValue(if (person != null) "Person revived!" else "We lost him :(")
        person?.let {
            reviveViewModel.postValue(person)
        }

    }

}