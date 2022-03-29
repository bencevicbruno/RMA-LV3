package ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rma_lv2.databinding.FragmentBirdsListBinding
import di.BirdsRepoFactory
import model.Bird

class BirdsListFragment: Fragment(), BirdSelectListener {

    private lateinit var binding: FragmentBirdsListBinding
    private lateinit var adapter: BirdAdapter
    private val repository = BirdsRepoFactory.repository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBirdsListBinding.inflate(layoutInflater)
        setupRecyclerView()
        binding.fabAddBird.setOnClickListener { showAddNewPerson() }
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.listBirds.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = BirdAdapter()
        adapter.onBirdSelected = this
        binding.listBirds.adapter = adapter
    }

    override fun onBirdSelected(id: Long?) {
       println("birb")
    }

    override fun onBirdLongPress(bird: Bird?): Boolean {
        bird?.let { it ->
            repository.delete(it)
            adapter.setBirds(repository.getAllBirds())
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        updateData()
    }

    private fun updateData() {
        adapter.setBirds(repository.getAllBirds())
    }

    companion object {
        val Tag = "BirdsList"

        fun create(): Fragment {
            return BirdsListFragment()
        }
    }

    private fun showAddNewPerson() {
        val action = BirdsListFragmentDirections.actionBirdsListFragmentToNewBirdFragment()
        findNavController().navigate(action)
    }
}