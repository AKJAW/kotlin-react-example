package feature.todolist

import redux.RAction

object TodoListSlice {
    data class State(
        val todos: Array<Task> = emptyArray()
    )

    fun fetchTodos(): Nothing = TODO()

    fun reducer(state: State = State(), action: RAction): State {
        return when (action) {
            else -> state
        }
    }
}