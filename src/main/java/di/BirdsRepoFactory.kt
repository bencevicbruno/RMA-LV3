package di

import com.example.rma_lv2.data.*
import com.example.rma_lv2.data.memory_db.InMemoryDatabase
import com.example.rma_lv2.data.room.BirdsDatabase

object BirdsRepoFactory {

    //private val birdsDAO: BirdsDAO = InMemoryDatabase()
    //val peopleRepository: BirdsRepository = BirdsRepoImpl(birdsDAO)

    //private val birdsDB = BirdsDatabase.getDatabase(Birdz.application)
    private val birdsDB = BirdsDatabase.getDatabase(Birdz.application)
    val repository: BirdsRepository = BirdsRepoImpl(birdsDB.getBirdsDao())
}