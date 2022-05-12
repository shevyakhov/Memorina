package com.example.memorina

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.memorina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var clicked = ArrayList<ImageView>()
    private var count = 0
    private lateinit var binding: ActivityMainBinding
    var colors = ArrayList<Int>()
    var tiles = ArrayList<Tile>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initArray()
        setListeners()
    }


    fun setListeners() {

        with(binding) {
            tileFirstOne.setOnClickListener {
                listener(tiles[0].imageView, tiles[0].color)
            }
            tileFirstTwo.setOnClickListener {
                listener(tiles[1].imageView, tiles[1].color)
            }
            tileFirstThree.setOnClickListener {
                listener(tiles[2].imageView, tiles[2].color)
            }
            tileSecondOne.setOnClickListener {
                listener(tiles[3].imageView, tiles[3].color)
            }
            tileSecondTwo.setOnClickListener {
                listener(tiles[4].imageView, tiles[4].color)
            }
            tileSecondThree.setOnClickListener {
                listener(tiles[5].imageView, tiles[5].color)
            }
            tileThirdOne.setOnClickListener {
                listener(tiles[6].imageView, tiles[6].color)
            }
            tileThirdTwo.setOnClickListener {
                listener(tiles[7].imageView, tiles[7].color)
            }
            tilethirdThree.setOnClickListener {
                listener(tiles[8].imageView, tiles[8].color)
            }
            tileFourthOne.setOnClickListener {
                listener(tiles[9].imageView, tiles[9].color)
            }
            tileFourthTwo.setOnClickListener {
                listener(tiles[10].imageView, tiles[10].color)
            }
            tileFourthThree.setOnClickListener {
                listener(tiles[11].imageView, tiles[11].color)
            }
        }


    }

    // FIXME: криво работает, не в том порядке
    private fun listener(imageView: ImageView, color: Int) {
        Handler(Looper.getMainLooper()).postDelayed({
            imageView.setImageResource(color)
            clicked.add(imageView)
            count++
            check()
        }, 700)
    }

    private fun check() {
        if (count == 2){
            hideTrueColor(clicked[0],clicked[1])
        }
    }

    private fun hideTrueColor(imageView1: ImageView,imageView2: ImageView) {
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
                add(redColor)
                add(blueColor)
                add(yellowColor)
                add(purpleColor)
                add(greenColor)
                add(orangeColor)
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