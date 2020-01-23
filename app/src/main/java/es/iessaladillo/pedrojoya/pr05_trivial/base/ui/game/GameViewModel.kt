package es.iessaladillo.pedrojoya.pr05_trivial.base.ui.game
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.pr05_trivial.base.Question

class GameViewModel : ViewModel() {

    var questions: List<Question>? = null

    var currentIndex: Int = 0

    var currentQuestion: Question? = null

}
