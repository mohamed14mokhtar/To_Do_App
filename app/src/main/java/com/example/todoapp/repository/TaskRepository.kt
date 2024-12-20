package com.example.todoapp.repository

import androidx.lifecycle.LiveData
import com.example.todoapp.alarm_manager.AlarmItem
import com.example.todoapp.dao.TaskDao
import com.example.todoapp.models.TaskModel

class TaskRepository(private val taskDao: TaskDao) {

    val readAllData: LiveData<List<TaskModel>> = taskDao.getAllTasks()

    suspend fun addUser(task: TaskModel): Long {
        return taskDao.insertTask(task)
    }

    suspend fun updateUser(task: TaskModel) {
        taskDao.updateTask(task)
    }

    suspend fun deleteUser(task: TaskModel) {
        taskDao.deleteTask(task)
    }

    suspend fun deleteAllUsers() {
        taskDao.deleteAllTasks()
    }

    suspend fun updateTaskStatus(taskId: Int, isDone: Boolean) {
        taskDao.updateTaskStatus(taskId, isDone)
    }

    suspend fun updateAlarmTime(taskId: Int, alarmItem: AlarmItem) {
        taskDao.updateAlarmTime(taskId, alarmItem)
    }

    fun getTasksByDay(day: String): LiveData<List<TaskModel>> {
        return taskDao.getTasksByDay(day)
    }
}