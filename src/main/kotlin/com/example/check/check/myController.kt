package com.example.check.check


import io.reactivex.Flowable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id



@RestController
class myController(val hungamaRepository: HungamaRepository){
    @GetMapping("/abcde")
    fun abcdef():String{
        Flowable.just(Hungama(12,"shubham")).subscribe(){
            hungamaRepository.save(it)
            print("list: ${hungamaRepository.findAll()}")
        }
        return "hello"
    }

}


@Entity
data class Hungama(@Id @GeneratedValue(strategy = GenerationType.AUTO)val Id : Long = 0, var name:String="abcde")

@Repository
interface  HungamaRepository:JpaRepository<Hungama,Long>