package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Model.ProductModel;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.R;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ProductModel> productList;

    public ProductAdapter(Context context, int layout, List<ProductModel> productList) {
        this.context = context;
        this.layout = layout;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtName,txtDes,txtPrice;
        ImageView imgHinhAnh;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view==null){
            holder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.txtName=(TextView) view.findViewById(R.id.txtNameRow);
            holder.txtDes=(TextView) view.findViewById(R.id.txtDesRow);
            //holder.txtPrice=(TextView) view.findViewById(R.id.txtPriceRow);
            holder.imgHinhAnh=(ImageView)  view.findViewById(R.id.imgProductRow);
            view.setTag(holder);

        }else{
            holder=(ViewHolder) view.getTag();

        }
        ProductModel product=productList.get(i);
        holder.txtName.setText(product.getTen());
        holder.txtDes.setText(product.getMoTa());
        //holder.txtPrice.setText(product.getGia());
        //chuyen byte--> bitmap
        byte[] Hinh=product.getHinh();
        Bitmap bitmap= BitmapFactory.decodeByteArray(Hinh,0,Hinh.length);
        // Bitmap bitmap= BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
        // holder.imgHinh.setImageBitmap(bitmap);
        holder.imgHinhAnh.setImageBitmap(bitmap);


        return view;

    }

    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("ProductAdapter", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }


}
