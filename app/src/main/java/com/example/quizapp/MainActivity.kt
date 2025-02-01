package com.example.quizapp

import android.content.DialogInterface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var listOfQuetions = arrayListOf<QuestionsModel>()
    private var currentIndex = 0
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        ininting the app code block
        loadUI()
//        load data
        loadData()
        binding.next.setOnClickListener() {
            currentIndex++
            binding.answersGroup.clearCheck()
            setTestData(currentIndex)
            if (listOfQuetions.size - 1 <= currentIndex) {
                var dialog = android.app.AlertDialog.Builder(this)
                dialog.setTitle("Javoblar")
                dialog.setMessage("Javoblar togri $score")
                dialog.create()
                dialog.show()
            } else {
                var radioText = binding.answer1.text
                if (radioText == listOfQuetions[currentIndex].realAnswer) {
                    score++
                }
            }
        }
    }

    private fun setTestData(currentIndex: Int) {
        binding.questionTitle.text = listOfQuetions[currentIndex].question
        binding.answer1.text = listOfQuetions[currentIndex].answer1
        binding.answer2.text = listOfQuetions[currentIndex].answer2
        binding.answer3.text = listOfQuetions[currentIndex].answer3
        binding.answer4.text = listOfQuetions[currentIndex].answer4
    }


    private fun loadData() {
        listOfQuetions = arrayListOf()
        listOfQuetions.add(
            QuestionsModel(
                "Amir Temur Qachon Tugilgan",
                "1445",
                "1345",
                "1345",
                "2445",
                "1445",
            )
        )
        listOfQuetions.add(
            QuestionsModel(
                "Alisger Navoi Qachon Tugilgan",
                "1445",
                "1345",
                "1345",
                "2445",
                "1445",
            )
        )
        listOfQuetions.add(
            QuestionsModel(
                "Hamza Qachon Tugilgan",
                "1445",
                "1345",
                "1345",
                "2445",
                "1445",
            )
        )
        listOfQuetions.add(
            QuestionsModel(
                "Chingizxon Qachon Tugilgan",
                "1445",
                "1345",
                "1345",
                "2445",
                "1445",
            )
        )
        listOfQuetions.add(
            QuestionsModel(
                "Ali Qushchi Qachon Tugilgan",
                "1445",
                "1345",
                "1345",
                "2445",
                "1445",
            )
        )
    }

    private fun loadUI() {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> Toast.makeText(this, "Home is selected", Toast.LENGTH_SHORT).show()
            R.id.about -> Toast.makeText(this, "About is selected", Toast.LENGTH_SHORT).show()
            R.id.info -> Toast.makeText(this, "Info is selected", Toast.LENGTH_SHORT).show()
            R.id.blog -> Toast.makeText(this, "Blog is selected", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}