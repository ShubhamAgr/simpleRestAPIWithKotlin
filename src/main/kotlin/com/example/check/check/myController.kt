package com.example.check.check


import io.reactivex.Flowable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@RestController
class myController(val hungamaRepository: HungamaRepository){
    @GetMapping("/all")
    fun all(): MutableList<Hungama> {

        return hungamaRepository.findAll()
    }

    @RequestMapping(value = "/add",method = arrayOf(RequestMethod.POST))
    fun addNewItem(@ModelAttribute("name") name : String):MutableList<Hungama>{
        hungamaRepository.save(Hungama(name=name))
        return  hungamaRepository.findAll()
    }

    @RequestMapping(value="/addjson",method = arrayOf(RequestMethod.POST))
     fun printJson(@RequestBody jsonstring: JsonString):ResponseEntity<Success>{
        println(jsonstring.toString())
        return  ResponseEntity(Success("hola"),HttpStatus.OK)

    }

}
data class JsonString(val name:String,val age:Int)
data class Success(val msg:String)
@Entity
data class Hungama(@Id @GeneratedValue(strategy = GenerationType.AUTO)val Id : Long = 0, var name:String="abcde")

@Repository
interface  HungamaRepository:JpaRepository<Hungama,Long>