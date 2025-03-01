package com.example.util.simpletimetracker.data_local.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.util.simpletimetracker.core.extension.allowDiskWrite
import com.example.util.simpletimetracker.data_local.database.AppDatabase
import com.example.util.simpletimetracker.data_local.database.AppDatabaseMigrations
import com.example.util.simpletimetracker.data_local.database.CategoryDao
import com.example.util.simpletimetracker.data_local.database.RecordDao
import com.example.util.simpletimetracker.data_local.database.RecordTagDao
import com.example.util.simpletimetracker.data_local.database.RecordToRecordTagDao
import com.example.util.simpletimetracker.data_local.database.RecordTypeCategoryDao
import com.example.util.simpletimetracker.data_local.database.RecordTypeDao
import com.example.util.simpletimetracker.data_local.database.RunningRecordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataLocalModule {

    companion object {
        private const val PREFS_NAME = "prefs_simple_time_tracker"
    }

    @Provides
    @Singleton
    fun getAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(
                context,
                AppDatabase::class.java, AppDatabase.DATABASE_NAME
            )
            .addMigrations(
                AppDatabaseMigrations.migration_1_2,
                AppDatabaseMigrations.migration_2_3,
                AppDatabaseMigrations.migration_3_4,
                AppDatabaseMigrations.migration_4_5,
                AppDatabaseMigrations.migration_5_6,
                AppDatabaseMigrations.migration_6_7,
            )
            .build()
    }

    @Provides
    @Singleton
    fun getSharedPrefs(@ApplicationContext context: Context): SharedPreferences {
        allowDiskWrite {
            return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        }
    }

    @Provides
    @Singleton
    fun getRecordDao(database: AppDatabase): RecordDao {
        return database.recordDao()
    }

    @Provides
    @Singleton
    fun getRecordTypeDao(database: AppDatabase): RecordTypeDao {
        return database.recordTypeDao()
    }

    @Provides
    @Singleton
    fun getRunningRecordDao(database: AppDatabase): RunningRecordDao {
        return database.runningRecordDao()
    }

    @Provides
    @Singleton
    fun getCategoryDao(database: AppDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    @Singleton
    fun getRecordTypeCategoryDao(database: AppDatabase): RecordTypeCategoryDao {
        return database.recordTypeCategoryDao()
    }

    @Provides
    @Singleton
    fun getRecordTagDao(database: AppDatabase): RecordTagDao {
        return database.recordTagDao()
    }

    @Provides
    @Singleton
    fun getRecordToRecordTagDap(database: AppDatabase): RecordToRecordTagDao {
        return database.recordToRecordTagDao()
    }
}