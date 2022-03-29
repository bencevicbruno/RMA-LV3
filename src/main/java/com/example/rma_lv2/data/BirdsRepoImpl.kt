package com.example.rma_lv2.data

import model.Bird

class BirdsRepoImpl(val dao: BirdsDAO): BirdsRepository {

    override fun save(bird: Bird) = dao.save(bird)

    override fun delete(bird: Bird) = dao.delete(bird)

    override fun getBirdById(id: Long): Bird? = dao.getBirdById(id)

    override fun getAllBirds(): List<Bird> = dao.getAllBirds()


}