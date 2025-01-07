package pl.meksu.reactiontimetest

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock


class MainViewModel(
    private val prefs: DataStore<Preferences>
) : ViewModel() {

    private val _screenState = MutableStateFlow(1)
    val screenState: StateFlow<Int> = _screenState.asStateFlow()

    private val _startTime = MutableStateFlow(0L)
    private val _stopTime = MutableStateFlow(0L)
    private val _result = MutableStateFlow(0L)
    val result: StateFlow<Long> = _result.asStateFlow()

    private val _bestScore = MutableStateFlow(Long.MAX_VALUE)
    val bestScore: StateFlow<Long> = _bestScore.asStateFlow()

    init {
        viewModelScope.launch {
            prefs.data.collect { preferences ->
                val key = longPreferencesKey("best_score")
                val score = preferences[key] ?: Long.MAX_VALUE
                _bestScore.value = score
            }
        }
    }

    fun onStartClicked() {
        _screenState.value = 2
    }

    fun onWaitScreenTimeout() {
        _screenState.value = 3
        _startTime.value = Clock.System.now().toEpochMilliseconds()
    }

    fun navigateToResultScreen() {
        _stopTime.value = Clock.System.now().toEpochMilliseconds()
        _result.value = _stopTime.value - _startTime.value

        viewModelScope.launch {
            if (_result.value < _bestScore.value) {
                _bestScore.value = _result.value
                prefs.edit { preferences ->
                    val key = longPreferencesKey("best_score")
                    preferences[key] = _result.value
                }
            }
        }

        _screenState.value = 4
    }

    fun navigateToTooSoonScreen() {
        _screenState.value = 5
    }

    fun navigateToWaitScreen() {
        _screenState.value = 2
    }
}
