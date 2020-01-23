package es.iessaladillo.pedrojoya.pr05_trivial.base.ui.title


import ConfirmationDialogFragment
import android.app.Dialog
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.base.ui.game.GameFragment
import es.iessaladillo.pedrojoya.pr05_trivial.base.ui.rules.AboutFragment
import es.iessaladillo.pedrojoya.pr05_trivial.base.ui.rules.RulesFragment
import es.iessaladillo.pedrojoya.pr05_trivial.base.ui.settings.SettingsFragment
import kotlinx.android.synthetic.main.title_fragment.*


class TitleFragment : Fragment(R.layout.title_fragment) {

    companion object {

        fun newInstance() =
            TitleFragment()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {

        activity?.setTitle(R.string.app_name)

        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowHomeEnabled(false)

        btnStart.setOnClickListener {navigateToGame()}

    }

    private fun navigateToGame() {
        requireActivity().supportFragmentManager.commit {

            remove(this@TitleFragment)

            replace(R.id.fcContent, GameFragment.newInstance())
            addToBackStack(null)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.title_fragment, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {

            R.id.mnuRules -> navigateToRules()
            R.id.mnuAbout -> navigateToAbout()
            R.id.mnuSettings -> navigateToSettings()
            else -> return super.onOptionsItemSelected(item)

        }
        return true
    }

    private fun navigateToSettings() {

        requireActivity().supportFragmentManager.commit {

            remove(this@TitleFragment)

            replace(R.id.fcContent, SettingsFragment())
            addToBackStack(null)

        }


    }

    private fun navigateToAbout() {

        requireActivity().supportFragmentManager.commit {

            remove(this@TitleFragment)

            replace(R.id.fcContent, AboutFragment.newInstance())
            addToBackStack(null)

        }


    }

    private fun navigateToRules() {

        requireActivity().supportFragmentManager.commit {

            remove(this@TitleFragment)

            replace(R.id.fcContent, RulesFragment.newInstance())
            addToBackStack(null)

        }

    }





}
