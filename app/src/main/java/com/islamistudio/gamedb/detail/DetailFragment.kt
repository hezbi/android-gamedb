package com.islamistudio.gamedb.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.islamistudio.gamedb.MainActivity
import com.islamistudio.gamedb.R
import com.islamistudio.gamedb.databinding.FragmentDetailGameBinding
import com.islamistudio.gamedb.databinding.FragmentHomeBinding

class DetailGameFragment : Fragment() {

    private val args by navArgs<DetailGameFragmentArgs>()

    private var _binding: FragmentDetailGameBinding? = null
    private val binding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailGameBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            (activity as MainActivity).hideNavBar(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        if (activity != null) {
            (activity as MainActivity).hideNavBar(false)
        }
    }
}