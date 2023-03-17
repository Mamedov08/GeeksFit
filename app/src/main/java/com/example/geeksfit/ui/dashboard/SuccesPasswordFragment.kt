import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.geeksfit.R
import com.example.geeksfit.databinding.FragmentSuccesPasswordBinding
import com.example.geeksfit.ui.gim.ui.GimFragment
import com.google.android.material.button.MaterialButton

class SuccessPasswordFragment : Fragment() {

    private var _binding: FragmentSuccesPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuccesPasswordBinding.inflate(inflater, container, false)
        val view = binding.root

        val changePasswordTextView: TextView = binding.scTextView
        val successTextView: TextView = binding.scTextView2
        val enterPasswordButton: MaterialButton = binding.scButton

        enterPasswordButton.setOnClickListener {
            val gimFragment : GimFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.GimFragment, gimFragment)
                .commit()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
