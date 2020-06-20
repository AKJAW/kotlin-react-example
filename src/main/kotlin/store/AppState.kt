package store

import feature.todolist.TodoListSlice

data class AppState(
    val todoListState: TodoListSlice.State = TodoListSlice.State()
)