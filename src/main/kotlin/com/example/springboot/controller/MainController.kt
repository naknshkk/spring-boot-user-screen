package com.example.springboot.controller

import com.example.springboot.entity.User
import com.example.springboot.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController{
    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/")
    fun shouUsers(model: Model): String{
        val users = userRepository.findAll()
        model.addAttribute("users", users)
        return "index"
    }

    @GetMapping("/add")
    fun showAddPage(): String {
        return "add"
    }

    @PostMapping("/add")
    fun addNerUser(@RequestParam name: String): String{
        userRepository.save(User(0, name))
        return "redirect:/"
    }
}