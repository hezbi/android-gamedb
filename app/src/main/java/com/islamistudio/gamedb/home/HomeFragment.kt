package com.islamistudio.gamedb.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.islamistudio.gamedb.MainActivity
import com.islamistudio.gamedb.R
import com.islamistudio.gamedb.core.data.Resource
import com.islamistudio.gamedb.core.domain.model.Game
import com.islamistudio.gamedb.core.ui.GameAdapter
import com.islamistudio.gamedb.core.ui.RecyclerViewAdapterDelegate
import com.islamistudio.gamedb.databinding.FragmentHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding

    private val gameAdapter = GameAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            gameAdapter.delegate = object : RecyclerViewAdapterDelegate<Game> {
                override fun onClick(t: Game) {
                    val action = HomeFragmentDirections.actionHomeFragmentToDetailGameFragment(t)
                    findNavController().navigate(action)
                }

            }

            loadData(false)

            binding?.rvGames?.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = gameAdapter
            }

            binding?.swpRefresh?.setOnRefreshListener {
                loadData(true)
            }

        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun loadData(reload: Boolean) {
        viewModel.game(reload).observe(viewLifecycleOwner, {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {
                        binding?.progressBarView?.root?.visibility = View.VISIBLE
                        binding?.swpRefresh?.isRefreshing = false
                    }
                    is Resource.Success -> {
                        binding?.progressBarView?.root?.visibility = View.GONE
                        gameAdapter.list = it.data!!.toMutableList()
                        gameAdapter.notifyDataSetChanged()
                    }
                    is Resource.Error -> {
                        binding?.progressBarView?.root?.visibility = View.GONE
                        binding?.viewError?.root?.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}