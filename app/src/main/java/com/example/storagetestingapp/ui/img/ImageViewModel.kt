package com.example.storagetestingapp.ui.img


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.storagetestingapp.repo.FileRepository

class ImageViewModel : ViewModel() {

    val toastViewModel = MutableLiveData<String>()

    fun onSaveImageFile(source: Int, filename: String) = viewModelScope.launch {
        val isFileSaved = withContext(Dispatchers.IO) {
            FileRepository.saveImageFile(source, filename)
        }
        toastViewModel.postValue(if (isFileSaved) "Image file saved!" else "Failed to save image file!")

    }

}