package com.example.database

import com.example.database.db.Employee
import com.example.database.db.EmployeeDatabase
import java.util.concurrent.Executors

class EmployeeRepository(private val database: EmployeeDatabase) {
    private val executor = Executors.newSingleThreadExecutor()
    fun getAll() = database.employeeDao().getAll()
    fun add(employee: Employee) {
        executor.execute { database.employeeDao().add(employee) }
    }
    fun remove(employee: Employee){
        executor.execute { database.employeeDao().delete(employee) }
    }
}