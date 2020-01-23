package es.iessaladillo.pedrojoya.pr05_trivial.base.ui.game

import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.preference.PreferenceManager
import com.example.myapplication.es.iessaladillo.pedrojoya.pr05_trivial.base.ui.main.settings

import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.base.Question
import es.iessaladillo.pedrojoya.pr05_trivial.base.questionList
import es.iessaladillo.pedrojoya.pr05_trivial.base.ui.rules.AboutFragment
import es.iessaladillo.pedrojoya.pr05_trivial.base.ui.rules.LostFragment
import es.iessaladillo.pedrojoya.pr05_trivial.base.ui.rules.WinFragment
import kotlinx.android.synthetic.main.game_fragment.*
import kotlinx.coroutines.processNextEventInCurrentThread

class GameFragment : Fragment(R.layout.game_fragment) {

    companion object {
        fun newInstance() = GameFragment()
    }




    private val viewModel: GameViewModel by viewModels()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {

        if (viewModel.questions == null) {

            viewModel.questions = questionList.shuffled().subList(0, settings(requireContext()).getInt("1", 3))

        }

        activity?.setTitle(getString(R.string.game_question_title, viewModel.currentIndex+1, viewModel.questions!!.size))

        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowHomeEnabled(true)

        setupQuestion()

        btnSubmit.setOnClickListener { submitQuestion() }

    }

    private fun setupQuestion() {
        viewModel.currentQuestion = viewModel.questions!!.get(viewModel.currentIndex)

        lblQuestion.text = viewModel.currentQuestion!!.question

        rdA1.text = viewModel.currentQuestion!!.answers.get(0).res

        rdA2.text = viewModel.currentQuestion!!.answers.get(1).res

        rdA3.text = viewModel.currentQuestion!!.answers.get(2).res

        rdA4.text = viewModel.currentQuestion!!.answers.get(3).res
    }

    private fun submitQuestion() {

        if (rdA1.isChecked || rdA2.isChecked || rdA3.isChecked || rdA4.isChecked) {

            if ((rdA1.isChecked && viewModel.currentQuestion!!.answers.get(0).isCorrect) || (rdA2.isChecked && viewModel.currentQuestion!!.answers.get(
                    1
                ).isCorrect) || (rdA3.isChecked && viewModel.currentQuestion!!.answers.get(2).isCorrect) || (rdA4.isChecked && viewModel.currentQuestion!!.answers.get(
                    3
                ).isCorrect)
            ) {

                viewModel.currentIndex++

                if (viewModel.currentIndex >= viewModel.questions!!.size) {

                    navigateToWin()

                } else {

                    activity?.setTitle(
                        getString(
                            R.string.game_question_title,
                            viewModel.currentIndex + 1,
                            viewModel.questions!!.size
                        )
                    )

                    setupQuestion()

                }

            }

            else {

                navigateToLose()

            }

        }



    }

    private fun navigateToLose() {

        requireActivity().supportFragmentManager.commit {


                remove(this@GameFragment)


            replace(R.id.fcContent, LostFragment.newInstance())

        }

    }

    private fun navigateToWin() {

        requireActivity().supportFragmentManager.commit {

            remove(this@GameFragment)

            replace(R.id.fcContent, WinFragment.newInstance())
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_game, menu)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

}
