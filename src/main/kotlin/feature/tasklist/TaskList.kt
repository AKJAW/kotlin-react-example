package feature.tasklist

import com.ccfraser.muirwik.components.button.MButtonVariant
import com.ccfraser.muirwik.components.button.mButton
import com.ccfraser.muirwik.components.card.mCard
import com.ccfraser.muirwik.components.form.MFormControlVariant
import com.ccfraser.muirwik.components.list.mList
import com.ccfraser.muirwik.components.list.mListItem
import com.ccfraser.muirwik.components.mCircularProgress
import com.ccfraser.muirwik.components.mTextField
import com.ccfraser.muirwik.components.targetInputValue
import feature.tasklist.TaskListClasses.loading
import kotlinx.css.*
import react.RProps
import react.functionalComponent
import react.useState
import styled.StyleSheet
import styled.css
import styled.styledDiv

interface TaskListProps : RProps {
    var isLoading: Boolean
    var tasks: Array<Task>
    var addTask: (task: Task) -> Unit
    var removeTask: (task: Task) -> Unit
}

private object TaskListClasses : StyleSheet("TaskList", isStatic = true) {
    val loading by css {
        minHeight = LinearDimension("200px")
        display = Display.flex
        justifyContent = JustifyContent.spaceAround
        alignItems = Align.center
    }
    val actions by css {
        display = Display.flex
        justifyContent = JustifyContent.spaceAround
        alignItems = Align.center

        children {
            firstChild {
                margin = "5px 10px 0 0"
            }
        }
    }
    val task by css {
        margin = "10px 0"
    }
}

val taskList = functionalComponent<TaskListProps> { props ->
    val (taskName, setTaskName) = useState("")
    val (isTaskNameInvalid, setIsTaskNameInvalid) = useState(false)

    styledDiv {
        if (props.isLoading) {
            css(loading)
            mCircularProgress { }
        } else {
            styledDiv {
                css(TaskListClasses.actions)
                mTextField(
                    label = "Task",
                    variant = MFormControlVariant.outlined,
                    value = taskName,
                    error = isTaskNameInvalid,
                    fullWidth = true,
                    onChange = {
                        setIsTaskNameInvalid(false)
                        setTaskName(it.targetInputValue)
                    }
                )
                mButton(
                    caption = "Add",
                    variant = MButtonVariant.outlined,
                    onClick = {
                        if(taskName.isBlank()){
                            setIsTaskNameInvalid(true)
                        } else {
                            props.addTask(Task(taskName))
                            setTaskName("")
                        }
                    }
                )
            }
            mList {
                props.tasks.forEach { task ->
                    mCard {
                        css(TaskListClasses.task)
                        mListItem(button = true, onClick = { props.removeTask(task) }) {
                            + task.name
                        }
                    }
                }
            }
        }
    }
}