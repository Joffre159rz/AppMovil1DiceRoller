package com.example.diceroller
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button2)
        /*rollButton.setOnClickListener {
            val resultTextView: TextView = findViewById(R.id.textView2)
            resultTextView.text = "6"
        }*/
        rollButton.setOnClickListener { rollDice() }
    }
    /**
     * Lanzar el dado y actualizar los resultados.
     */
    private fun rollDice() {
        // Crear un nuevo objeto dado con 6 caras y lanzar el dado
        val dice = Dice(6)
        val diceRoll = dice.roll()
       /* val resultTextView: TextView = findViewById(R.id.textView2)
        resultTextView.text = diceRoll.toString()*/
        // Buscar la imagen en el layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        // Determinar dependiendo de la id la imagen
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Actualizar la  ImageView con lo determinado anteriormente
        diceImage.setImageResource(drawableResource)
        // Actualizar el contenido de la descripcion
        diceImage.contentDescription = diceRoll.toString()
    }

}
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}