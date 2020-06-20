package store

import feature.todolist.TodoListSlice
import redux.Reducer
import redux.combineReducers
import kotlin.reflect.KProperty1

fun combinedReducers() = combineReducersInferred(
    mapOf(
        AppState::todoListState to TodoListSlice::reducer
    )
)

// Credit https://github.com/JetBrains/kotlin-wrappers/blob/master/kotlin-redux/README.md
fun <S, A, R> combineReducersInferred(reducers: Map<KProperty1<S, R>, Reducer<*, A>>): Reducer<S, A> {
    return combineReducers(reducers.mapKeys { it.key.name })
}
