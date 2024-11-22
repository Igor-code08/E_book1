package com.example.e_book1
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ссылки на элементы интерфейса
        val loadButton: Button = findViewById(R.id.loadButton)
        val bookTextView: TextView = findViewById(R.id.bookTextView)

        // Обработка нажатия кнопки "Загрузить"
        loadButton.setOnClickListener {
            // Получение текста из базы данных
            val database = Database()
            val bookText = database.text

            // Загрузка текста книги и отображение на экране
            val wordsList = loadBook(bookText)
            bookTextView.text = wordsList.joinToString(" ") // Преобразуем список слов обратно в строку
        }
    }

    // Функция для разделения текста на список слов
    private fun loadBook(text: String): List<String> {
        return text.split("\n+".toRegex()) // Разделяем текст по пробелам и другим разделителям
    }
}