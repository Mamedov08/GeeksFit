package com.example.geeksfit.ui.profile


import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.geeksfit.BuildConfig


import com.example.geeksfit.R
import com.example.geeksfit.data.local.Pref
import com.example.geeksfit.databinding.FragmentProfileBinding
import com.example.geeksfit.ui.showToast
import dagger.hilt.android.AndroidEntryPoint

import java.io.File
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    @Inject  lateinit var pref: Pref
    private val vm : ProfileViewModel by viewModels()
    lateinit var binding: FragmentProfileBinding

    private lateinit var takePicture: ActivityResultLauncher<Uri>
    private var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicker()
        registerPictures()
        getPersonData()

    }

    private fun getPersonData() {
        vm.getPersonalInform().observe(viewLifecycleOwner){
            binding.tvName.text = it.properties.name.toString()
            binding.phoneNumber.text = it.properties.phone.toString()
            binding.gender.text = it.properties.gender.type
        }
    }

    private fun registerPictures() {

        takePicture =
            registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
                if (isSuccess) {
                    imageUri.let { uri ->
                        pref.saveImage(uri.toString())
                        binding.myImage.load(uri.toString())

                    }
                }
            }

    }

    private fun takeImage() {
        lifecycleScope.launchWhenStarted {
            getTmpFileUri().let { uri ->
                imageUri = uri
                takePicture.launch(uri)
            }
        }
    }


    private fun getTmpFileUri(): Uri {
        val tmpFile = File.createTempFile("tmp_image_file", ".png", requireContext().cacheDir).apply {
            createNewFile()
            deleteOnExit()
        }

        return FileProvider.getUriForFile(
            requireContext(),
            "${BuildConfig.APPLICATION_ID}.provider",
            tmpFile
        )
    }


    private fun initClicker() {
        binding.tvMyCard.setOnClickListener {
            findNavController().navigate(R.id.myCards)
        }

        binding.tvChangeBmi.setOnClickListener {
            setupDialogBmi()
        }

        binding.btnEditProfile.setOnClickListener {

            setupProfileDialog()
        }

        binding.profileImage.setOnClickListener {
            pickImageDialog()
        }

        binding.btnExit.setOnClickListener {
            AlertDialog.Builder(context)
                .setTitle("Выйти из аккаунта")
                .setMessage("Вы уверены, что хотите выйти из аккаунта?")
                .setPositiveButton("Да") { _, _ ->
                    // Здесь нужно выполнить код, который выходит из аккаунта
                }
                .setNegativeButton("Отмена", null)
                .show()
        }

    }

    private fun pickImageDialog() {
        val dialogBinding = layoutInflater.inflate(R.layout.dialog_for_profile_image, null)
        val myDialog = Dialog(requireContext())
        myDialog.setContentView(dialogBinding)
        myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val image = dialogBinding.findViewById<LinearLayout>(R.id.gallery)
        val addPhoto = dialogBinding.findViewById<LinearLayout>(R.id.add_photo)
        val confirm = dialogBinding.findViewById<TextView>(R.id.dialog_confirm)
        val dismiss = dialogBinding.findViewById<TextView>(R.id.tv_dismiss)

        image.setOnClickListener {

            galleryActivityLauncher.launch(arrayOf("image/*"))
            myDialog.dismiss()
        }
        binding.myImage.load(pref.getImage())

        addPhoto.setOnClickListener {
            takeImage()
            myDialog.dismiss()
        }

        confirm.setOnClickListener {

            myDialog.dismiss()

        }
        dismiss.setOnClickListener {
            myDialog.dismiss()
        }
        myDialog.show()
    }

    private fun setupProfileDialog() {
        val dialogBinding = layoutInflater.inflate(R.layout.castom_dialog, null)
        val myDialog = Dialog(requireContext())
        myDialog.setContentView(dialogBinding)
        myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val confirm = dialogBinding.findViewById<TextView>(R.id.dialog_confirm)
        val dismiss = dialogBinding.findViewById<TextView>(R.id.tv_dismiss)
        val userName = dialogBinding.findViewById<EditText>(R.id.user_name)
        val userEmail = dialogBinding.findViewById<EditText>(R.id.user_email)
        val cm = dialogBinding.findViewById<TextView>(R.id.tv_cm)
        val kg = dialogBinding.findViewById<TextView>(R.id.tv_kg)
        cm.isVisible = false
        kg.isVisible = false
        userName.hint = "ФИО"
        userEmail.hint = "E-mail"
        userEmail.setText(binding.tvEmail.text.toString())
        userName.setText(binding.tvName.text.toString())

        confirm.setOnClickListener {

            if (userEmail.text.isEmpty() || userName.text.isEmpty()) {
                userEmail.error = "Укажите Email"
                userName.error = "Укажите Имя"

            } else {
                binding.tvName.text = userName.text
                binding.tvEmail.text = userEmail.text
                myDialog.dismiss()
            }
        }
        dismiss.setOnClickListener { myDialog.dismiss() }
        myDialog.show()
    }



    private fun setupDialogBmi() {
        val dialogBinding = layoutInflater.inflate(R.layout.castom_dialog, null)
        val myDialog = Dialog(requireContext())
        myDialog.setContentView(dialogBinding)
        myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val confirm = dialogBinding.findViewById<TextView>(R.id.dialog_confirm)
        val dismiss = dialogBinding.findViewById<TextView>(R.id.tv_dismiss)
        val userCm = dialogBinding.findViewById<EditText>(R.id.user_name)
        val userKg = dialogBinding.findViewById<EditText>(R.id.user_email)
        val cm = dialogBinding.findViewById<TextView>(R.id.tv_cm)
        val kg = dialogBinding.findViewById<TextView>(R.id.tv_kg)
        cm.isVisible = true
        kg.isVisible = true
        userKg.hint = "kg"
        userCm.hint = "cm"


        confirm.setOnClickListener {
            val weight = userKg.text.toString().toFloatOrNull()
            val height = userCm.text.toString().toFloatOrNull()
            if (weight != null && height != null && height > 0) {
                val bmi = weight / (height * height)
                val formattedNumber = String.format("%.2f", bmi)

                val animation = TranslateAnimation(
                    0f,
                    bmi,
                    0f,
                    0f
                )
                animation.duration = 1000
                animation.fillAfter = true
                binding.bmiValueText.startAnimation(animation)
                binding.bmiValueText.text = formattedNumber
                myDialog.dismiss()
            } else {
                requireActivity().showToast("Введите корректные данные")
            }
        }
        dismiss.setOnClickListener { myDialog.dismiss() }
        myDialog.show()
    }

    private var galleryActivityLauncher: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(
            ActivityResultContracts.OpenDocument()
        ) { result ->
            if (result != null) {
                binding.myImage.load(result.toString())
                pref.saveImage(result.toString())

            } else {
                Log.d("lol", "onActivityResult: the result is null for some reason")
            }

        }


}