package com.zoho.view

import java.util.Scanner

class HomeView {
    private val userView = UserView()
    private val adminView = AdminView()

    private enum class HomeChoices(val text: String) {
        USER("User"),
        ADMIN("Admin"),
        EXIT("Exit")
    }

    fun homeChoices() {
        val scanner = Scanner(System.`in`)
        do {
            HomeChoices.values().forEach {
                println("${it.ordinal + 1}. ${it.text}")
            }
            println("Enter choice: ")
            val choice = scanner.nextInt()
            homeNavigation(choice - 1)
        } while (choice != HomeChoices.values().size)
    }

    private fun homeNavigation(choice: Int) {
        when (HomeChoices.values()[choice]) {
            HomeChoices.USER -> userChoices()
            HomeChoices.ADMIN -> adminChoices()
            HomeChoices.EXIT -> return
        }
    }

    private fun userChoices() {
        userView.userChoices()
    }

    private fun adminChoices() {
        adminView.adminChoices()
    }
}