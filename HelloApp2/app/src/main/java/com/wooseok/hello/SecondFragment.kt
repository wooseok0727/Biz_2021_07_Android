package com.wooseok.hello

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.wooseok.hello.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }
    /**
     * fragment 화면에서는
     * onCreateView() 에서는 root 를 binding 하고
     * 기타 view Component 의 event 핸들러 설정은
     * onViewCreate() 에서 설정한다.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * 첫번째로 돌아가기 버튼을 클릭하면
         * nav_Graph.xml 에 설정된
         *      action_SecondFragment_to_firstFragment ID 찾아서
         *      destination 에 설정된 fragment 를 현재 화면에
         *      올려라
         */
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        /**
         * 세번째 화면보기 버튼을 클릭하면
         * nav_Graph.xml 에 설정된
         *      action_SecondFragment_to_ThirdFragment 로 설정된
         *      ID 를 찾아서
         *      destination 으로 설정된 화면으로 교체하라
         */
        binding.buttonThird.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_ThirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}