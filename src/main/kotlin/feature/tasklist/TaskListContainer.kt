package feature.tasklist

import react.*
import react.redux.rConnect
import redux.RAction
import redux.WrapperAction
import store.AppState

interface TaskListConnectedProps : RProps {
    var isLoading: Boolean
    var tasks: Array<Task>
    var fetchTasks: () -> Unit
    var addTask: (task: Task) -> Unit
    var removeTask: (task: Task) -> Unit
}

private interface StateProps : RProps {
    var isLoading: Boolean
    var tasks: Array<Task>
}

private interface DispatchProps : RProps {
    var fetchTasks: () -> Unit
    var addTask: (task: Task) -> Unit
    var removeTask: (task: Task) -> Unit
}

private class TaskListContainer(props: TaskListConnectedProps) : RComponent<TaskListConnectedProps, RState>(props) {

    override fun componentDidMount() {
        props.fetchTasks()
    }

    override fun RBuilder.render() {
        child(taskList) {
            attrs.isLoading = props.isLoading
            attrs.tasks = props.tasks
            attrs.addTask = props.addTask
            attrs.removeTask = props.removeTask
        }
    }
}

val taskListContainer: RClass<RProps> =
    rConnect<AppState, RAction, WrapperAction, RProps, StateProps, DispatchProps, TaskListConnectedProps>(
        { state, _ ->
            tasks = state.taskListState.tasks
            isLoading = state.taskListState.isLoading
        },
        { dispatch, _ ->
            fetchTasks = { dispatch(TaskListSlice.fetchTasks()) }
            addTask = { task -> dispatch(TaskListSlice.AddTask(task)) }
            removeTask = { task -> dispatch(TaskListSlice.RemoveTask(task)) }
        }
    )(TaskListContainer::class.js.unsafeCast<RClass<TaskListConnectedProps>>())