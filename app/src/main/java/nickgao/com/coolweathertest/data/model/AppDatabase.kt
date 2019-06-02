package nickgao.com.coolweathertest.data.model

import androidx.room.RoomDatabase
import androidx.room.Database


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    //RoomDatabase提供直接访问底层数据库实现，我们通过定义抽象方法返回具体Dao
    //然后进行数据库增删该查的实现。
    abstract fun userDao(): UserDao
}