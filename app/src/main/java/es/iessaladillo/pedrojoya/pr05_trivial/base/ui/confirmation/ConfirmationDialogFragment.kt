import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.myapplication.es.iessaladillo.pedrojoya.pr05_trivial.base.ui.main.MainActivity
import es.iessaladillo.pedrojoya.pr05_trivial.R

class ConfirmationDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        isCancelable = false

    }




    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =

        AlertDialog.Builder(requireContext())

            .setTitle(getString(R.string.confirmation_title))

            .setMessage(getString(R.string.confirmation_message))

            .setPositiveButton(getString(R.string.confirmation_yes), {_, _ ->

                activity?.onBackPressed()

            }

            )
                .setNegativeButton(getString(R.string.confirmation_no), { _, _ ->



                })

                    .create()




}