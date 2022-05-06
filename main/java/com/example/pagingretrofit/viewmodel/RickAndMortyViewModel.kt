package com.example.pagingretrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pagingretrofit.api.ApiService
import com.example.pagingretrofit.paging.CharacterPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel()
class RickAndMortyViewModel
@Inject constructor(private val apiService: ApiService):ViewModel(){

    val listData = Pager(PagingConfig(pageSize = 1)){
        CharacterPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}