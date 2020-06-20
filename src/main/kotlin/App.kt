import com.ccfraser.muirwik.components.mContainer
import com.ccfraser.muirwik.components.styles.Breakpoint
import feature.tasklist.taskListContainer
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        mContainer(maxWidth = Breakpoint.xs) {
            taskListContainer {}
        }
    }
}