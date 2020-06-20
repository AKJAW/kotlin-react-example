package store

import feature.tasklist.TaskListSlice

data class AppState(
    val taskListState: TaskListSlice.State = TaskListSlice.State()
)