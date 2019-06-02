package nickgao.com.coolweathertest.data.model

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.Ignore
import androidx.room.PrimaryKey



@Entity(tableName = "user")
class User(){

    @PrimaryKey(autoGenerate = true)
    //字段映射具体的数据表字段名
    @ColumnInfo(name = "uid")
    private var uid: Int = 0
    //字段映射具体的数据表字段名
    @ColumnInfo(name = "first_name")
    private var firstName: String? = null
    //字段映射具体的数据表字段名
    @ColumnInfo(name = "last_name")
    private var lastName: String? = null



    @Ignore
    constructor(uid: Int,name:String) : this() {
        this.uid = uid
        this.firstName = name;
    }
}