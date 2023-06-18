import io.reactivex.Observable
import io.reactivex.exceptions.CompositeException
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith
import kotlin.test.fail

class AgentTest {

    @Test
    fun test() {
        assertFailsWith<CompositeException> {
            Observable.just("item").subscribe { fail("I did not expect this") }
        }
    }

}