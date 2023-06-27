package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Model.ProductModel;

public class Database extends SQLiteOpenHelper {


    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //TRUY VẤN KHÔNG KẾT QUẢ:CREATE,INSERT,UPDATE,DELETE

    public void QueryData(String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }

    public void INSERT_PRODUCT(String ten, String mota , String gia,byte[] hinh){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO Product VALUES(null, ?, ?, ?,?)";
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,ten);
        statement.bindString(2,mota);
        statement.bindString(3,gia);
        statement.bindBlob(4, hinh);

        statement.executeInsert();

    }

    public ProductModel getProduct(int pid){
        ProductModel product=new ProductModel();
        SQLiteDatabase database=getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * from Product where Id = ?",
                new String[]{pid + ""});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            product = new ProductModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getBlob(4));

        }
        cursor.close();
        return product;

    }

    public ProductModel getProductToCart(int pid){
        ProductModel product=new ProductModel();
        SQLiteDatabase database=getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * from Product where Id = ?",
                new String[]{pid + ""});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            product = new ProductModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getBlob(4));

        }
        cursor.close();
        return product;

    }


    //TRUY VẤN CÓ KẾT QUẢ: SELECT
    public Cursor GetData(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    //check username
    public Boolean checkUsername(String username){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select * From User Where Username=?", new String[]{username});
        if(cursor.getCount()>0){
            return true;
        } else{
            return false;
        }
    }
    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select * From User Where Username=? And Password=?", new String[]{username, password});
        if(cursor.getCount()>0){
            return true;
        } else{
            return false;
        }
    }





    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
