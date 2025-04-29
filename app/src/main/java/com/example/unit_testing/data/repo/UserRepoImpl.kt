package com.example.unit_testing.data.repo

class UserRepoImpl : UserRepo {
    override fun getUser(): String {
        return "Real User"
    }
}