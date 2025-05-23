package com.cericatto.scribbledash.ui.difficulty

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cericatto.scribbledash.ui.common.UiEvent
import com.cericatto.scribbledash.ui.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DifficultyScreenViewModel @Inject constructor(): ViewModel() {

	private val _events = Channel<UiEvent>()
	val events = _events.receiveAsFlow()

	private val _state = MutableStateFlow(DifficultyScreenState())
	val state: StateFlow<DifficultyScreenState> = _state.asStateFlow()

	fun onAction(action: DifficultyScreenAction) {
		when (action) {
			is DifficultyScreenAction.NavigateUp -> navigateUp()
			is DifficultyScreenAction.NavigateToDraw -> navigateToDraw()
		}
	}

	init {
		_state.update { it.copy(loading = false) }
	}

	private fun navigateUp() {
		viewModelScope.launch {
			_events.send(
				UiEvent.NavigateUp
			)
		}
	}

	private fun navigateToDraw() {
		viewModelScope.launch {
			_events.send(
				UiEvent.Navigate(
					Route.DrawScreen
				)
			)
		}
	}
}