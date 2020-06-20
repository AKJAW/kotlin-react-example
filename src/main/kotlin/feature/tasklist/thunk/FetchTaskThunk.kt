package feature.tasklist.thunk

import feature.tasklist.Task
import feature.tasklist.TaskListSlice
import redux.RAction
import redux.WrapperAction
import store.AppState
import store.RThunk
import store.nullAction
import kotlin.browser.window

class FetchTaskThunk: RThunk {
    override fun invoke(dispatch: (RAction) -> WrapperAction, getState: () -> AppState): WrapperAction {
        dispatch(TaskListSlice.SetIsLoading(true))
        window.setTimeout({
            val tasks = listOf(
                Task("Kotlin"),
                Task("is"),
                Task("awesome")
            )
            dispatch(TaskListSlice.SetTasks(tasks.toTypedArray()))
            dispatch(TaskListSlice.SetIsLoading(false))
        }, 2000)

        return nullAction
    }
}