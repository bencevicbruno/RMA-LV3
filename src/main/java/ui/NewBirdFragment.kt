package ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rma_lv2.databinding.FragmentNewPersonBinding
import di.BirdsRepoFactory
import model.Bird
import java.util.*

class NewBirdFragment : Fragment() {

    private val repository = BirdsRepoFactory.repository
    lateinit var binding: FragmentNewPersonBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewPersonBinding.inflate(layoutInflater)
        binding.bSavePerson.setOnClickListener{savePerson()}
        return binding.root
    }

    private fun savePerson() {

        val name = binding.birdEtName.text.toString()
        val location = binding.birdEtLocation.text.toString()
        var color = binding.birdEtColor.text.toString()

        // TODO: ACTUALLY SAVE
        repository.save(Bird(0, name, location, color, Date()))

        Toast.makeText(context, "Saving person.", Toast.LENGTH_SHORT).show()

        val action = NewBirdFragmentDirections.actionNewBirdFragmentToBirdsListFragment()
        findNavController().navigate(action)
    }

    companion object {
        val Tag = "NewBird"

        fun create(): Fragment {
            return NewBirdFragment()
        }
    }
}