package io.github.jerrymatera.spacex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.jerrymatera.spacex.R
import io.github.jerrymatera.spacex.databinding.FragmentSpaceShipModalBinding

class SpaceShipModalFragment : Fragment() {
    private var _binding: FragmentSpaceShipModalBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpaceShipModalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}