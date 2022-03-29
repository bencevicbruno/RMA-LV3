package com.example.rma_lv2.data.memory_db

import com.example.rma_lv2.data.BirdsDAO
import model.Bird
import java.util.*

class InMemoryDatabase: BirdsDAO {

    private val birds = mutableListOf<Bird>()

    init {
        birds.add(Bird(0, "Freddie", "Queens", "Rainbow", Date()))
        birds.add(Bird(1, "David", "Ground Control", "Orange", Date()))
        birds.add(Bird(2, "Michael Jackson", "Neverland", "Gray", Date()))
    }

    override fun save(bird: Bird) {
        birds.add(bird)
    }

    override fun delete(bird: Bird) {
        birds.remove(bird)
    }

    override fun getBirdById(id: Long): Bird? = birds.firstOrNull { it.id == id }

    override fun getAllBirds(): List<Bird> = birds
}