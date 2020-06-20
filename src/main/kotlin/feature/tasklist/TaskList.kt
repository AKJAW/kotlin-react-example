package feature.tasklist

import com.ccfraser.muirwik.components.button.mButton
import com.ccfraser.muirwik.components.card.mCard
import com.ccfraser.muirwik.components.list.mList
import com.ccfraser.muirwik.components.list.mListItem
import com.ccfraser.muirwik.components.mCircularProgress
import kotlinx.css.margin
import react.RProps
import react.functionalComponent
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
    val task by css {
        margin = "10px 0"
    }
}

val taskList = functionalComponent<TaskListProps> { props ->
    styledDiv {
        if (props.isLoading) {
            mCircularProgress { }
        } else {
            mButton("Add", onClick = { props.addTask(Task("Task ${props.tasks.count()}")) })
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