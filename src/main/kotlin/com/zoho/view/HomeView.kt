package com.zoho.view

import java.util.Scanner

class HomeView {

    private val userView = UserView()
    private val adminView = AdminView()

    fun initialChoices() {
        val scanner = Scanner(System.`in`)
        do {

            println("""
        *----------------*
        | Initial screen |
        |----------------|
        | 1. User        |
        | 2. Admin       |
        | 3. Exit        |
        *----------------*
            """.trimIndent())
            println("Enter choice: ")
            val choice = scanner.nextInt()
            homeNavigation(choice)
        } while (choice != 3)
    }

    private fun homeNavigation(paramChoice: Int) {
        when (paramChoice) {
            1 -> userChoices()
            2 -> adminChoices()
        }
    }

    private fun userChoices() {
        userView.userChoices()
//        UserView().userChoices()
    }

    private fun adminChoices()  {
        adminView.adminChoices()
//        AdminView().adminChoices()
    }
}