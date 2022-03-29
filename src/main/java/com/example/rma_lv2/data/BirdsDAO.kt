package com.example.rma_lv2.data

import model.Bird

interface BirdsDAO {

    fun save(bird: Bird)
    fun delete(bird: Bird)
    fun getBirdById(id: Long): Bird?
    fun getAllBirds(): List<Bird>
}