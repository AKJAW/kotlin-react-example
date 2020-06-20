package feature.tasklist

import feature.tasklist.thunk.FetchTaskThunk
import redux.RAction
import store.RThunk

object TaskListSlice {
    data class State(
        val tasks: Array<Task> = emptyArray(),
        val isLoading: Boolean = true
    )

    private val fetchTaskThunk = FetchTaskThunk()

    fun fetchTasks(): RThunk = fetchTaskThunk

    data class SetIsLoading(val isLoading: Boolean): RAction

    data class SetTasks(val tasks: Array<Task>): RAction

    data class AddTask(val task: Task): RAction

    data class RemoveTask(val task: Task): RAction

    fun reducer(state: State = State(), action: RAction): State {
        return when (action) {
            is SetIsLoading -> state.copy(isLoading = action.isLoading)
            is SetTasks -> state.copy(tasks = action.tasks)
            is AddTask -> state.copy(tasks = state.tasks + action.task)
            is RemoveTask -> state.copy(tasks = state.tasks.filterNot { task -> task == action.task }.toTypedArray())
            else -> state
        }
    }
}