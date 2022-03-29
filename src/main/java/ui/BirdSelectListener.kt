package ui

import model.Bird

interface BirdSelectListener {
    fun onBirdSelected(id: Long?)
    fun onBirdLongPress(bird: Bird?): Boolean
}