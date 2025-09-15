package com.example.careeradvisorjk.ui.main.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
// Make sure 'com.example.careeradvisorjk' is your actual application ID / base package
import com.example.careeradvisorjk.databinding.FragmentCollegeListBinding
import com.example.careeradvisorjk.entities.College


class CollegeListFragment : Fragment() {

    private var _binding: FragmentCollegeListBinding? = null
    private val binding get() = _binding!!
    private lateinit var vm: CollegeViewModel
    private val adapter = CollegeAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ):View{
        _binding = FragmentCollegeListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        // Option A: simple AndroidViewModel usage (no factory)
        vm = ViewModelProvider(this).get(CollegeViewModel::class.java)

        // Option B: repository + factory (uncomment if using factory)
        /*
        val db = AppDatabase.getDatabase(requireContext())
        val repo = CollegeRepository(db.collegeDao())
        val factory = CollegeViewModelFactory(repo)
        vm = ViewModelProvider(this, factory).get(CollegeViewModel::class.java)
        */

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@CollegeListFragment.adapter
        }

        vm.colleges.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }

        // Example: populate with sample data when FAB pressed
        binding.fab.setOnClickListener {
            val sample = listOf(
                College(1, "National Institute of Technology (NIT)", "Srinagar", "B.Tech, M.Tech, PhD", "Advanced Labs, Hostel, Sports Complex, Wi-Fi"),
                College(2, "University of Jammu", "Jammu", "BA, BSc, BCom, MA, MSc, MBA", "Central Library, Health Center, Hostels, Auditorium"),
                College(3, "Shri Mata Vaishno Devi University (SMVDU)", "Katra", "B.Tech, B.Arch, MBA, MSc", "Modern Campus, Digital Library, Sports Facilities, Bank"),
                College(4, "Government College for Women, Parade Ground", "Jammu", "BA, BSc, BCom, BCA", "Computer Labs, Canteen, Auditorium, Library"),
                College(5, "Islamia College of Science and Commerce", "Srinagar", "BSc IT, BBA, BCA, BCom (Hons)", "Smart Classrooms, E-Library, Gymnasium"),
                College(6, "Government Degree College for Boys, Anantnag", "Anantnag", "BSc (Medical), BA, BCom", "Science Labs, Reading Room, NSS/NCC Units"),
                College(7, "SPMR College of Commerce", "Jammu", "BCom, BBA (Computer Applications)", "E-Classrooms, Career Counseling Cell, Sports"),
                College(8, "Government Degree College, Baramulla", "Baramulla", "BA (History), BSc (Botany), BCom", "Botanical Garden, Library, Computer Lab"),
                College(9, "Model Institute of Engineering and Technology (MIET)", "Jammu", "B.E. (CSE), B.E. (Civil), MBA", "Industry Tie-ups, Innovation Lab, Hostel"),
                College(10, "Government Degree College, Leh", "Leh", "BA, BSc, B.Ed", "High-Altitude Sports Facilities, Library, Canteen")
            )
            vm.insertAll(sample)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}