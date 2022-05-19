package com.example.memorina

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.memorina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var tileCount = 12
    private var clicked = ArrayList<Tile>()
    private var count = 0
    private lateinit var binding: ActivityMainBinding
    private var colors = ArrayList<Int>()
    private var tiles = ArrayList<Tile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initArray()
        setListeners()
    }
    private fun setListeners() {
        for (index in tiles.indices) {
            tiles[index].imageView.setOnClickListener {
                listener(tiles[index])
            }
        }
    }
    private fun listener(tile: Tile) {
        if (count < 2) {
            if (tile !in clicked) {
                count++
                Handler(Looper.getMainLooper()).postDelayed({
                    tile.imageView.setImageResource(tile.color)
                }, 350)
                clicked.add(tile)
                check()
            }
        }
    }
    private fun check() {
        if (count == 2) {
            if (clicked[0].color == clicked[1].color) {
                Handler(Looper.getMainLooper()).postDelayed({
                    clicked[0].imageView.visibility = View.GONE
                    clicked[1].imageView.visibility = View.GONE
                    clicked.clear()
                    count = 0
                    tileCount -= 2
                    if (tileCount == 0){
                        Toast.makeText(this, "Вы победили!😎", Toast.LENGTH_SHORT).show()
                    }
                }, 700)
            } else
                hideTrueColor(clicked[0].imageView, clicked[1].imageView)
        }
    }

    private fun hideTrueColor(imageView1: ImageView, imageView2: ImageView) {
        Handler(Looper.getMainLooper()).postDelayed({
            imageView1.setImageResource(shirtColor)
            imageView2.setImageResource(shirtColor)
            clicked.clear()
            count = 0
        }, 1000)
    }
    private fun initArray() {
        for (i in 1..2) {
            with(colors) {
                add(R.drawable.one)
                add(R.drawable.two)
                add(R.drawable.three)
                add(R.drawable.four)
                add(R.drawable.five)
                add(R.drawable.six)
            }
        }
        colors.shuffle()
        tiles.add(Tile(binding.tileFirstOne, colors[0]))
        tiles.add(Tile(binding.tileFirstTwo, colors[1]))
        tiles.add(Tile(binding.tileFirstThree, colors[2]))
        tiles.add(Tile(binding.tileSecondOne, colors[3]))
        tiles.add(Tile(binding.tileSecondTwo, colors[4]))
        tiles.add(Tile(binding.tileSecondThree, colors[5]))
        tiles.add(Tile(binding.tileThirdOne, colors[6]))
        tiles.add(Tile(binding.tileThirdTwo, colors[7]))
        tiles.add(Tile(binding.tilethirdThree, colors[8]))
        tiles.add(Tile(binding.tileFourthOne, colors[9]))
        tiles.add(Tile(binding.tileFourthTwo, colors[10]))
        tiles.add(Tile(binding.tileFourthThree, colors[11]))
    }
}