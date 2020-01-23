package es.iessaladillo.pedrojoya.pr05_trivial.base.ui.rules


import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.base.ui.game.GameFragment
import kotlinx.android.synthetic.main.fragment_win.*


class WinFragment : Fragment(R.layout.fragment_win) {

    companion object {

        fun newInstance() =
            WinFragment()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_win, menu)
    }

    private fun setupViews() {

        activity?.setTitle(R.string.game_won_imgYouWin)

        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowHomeEnabled(true)

        btnAgain.setOnClickListener { nextMatch() }



    }

    private fun nextMatch() {

            requireActivity().supportFragmentManager.commit {

                remove(this@WinFragment)

                replace(R.id.fcContent, GameFragment.newInstance())
            }

    }




}
