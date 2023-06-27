package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Model.ProductModel;

public class ListDetailAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ProductModel> productListDetail;

    public ListDetailAdapter(Context context, int layout, List<ProductModel> productListDetail) {
        this.context = context;
        this.layout = layout;
        this.productListDetail = productListDetail;
    }

    @Override
    public int getCount() {
        return productListDetail.size();
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
       ListDetailAdapter.ViewHolder holder;
        if(view==null){
            holder=new ListDetailAdapter.ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.txtName=(TextView) view.findViewById(R.id.txtNameRowDe);
            holder.txtDes=(TextView) view.findViewById(R.id.txtDesRowDe);
            //holder.txtPrice=(TextView) view.findViewById(R.id.txtPriceRow);
            holder.imgHinhAnh=(ImageView)  view.findViewById(R.id.imgProductRowDe);
            view.setTag(holder);

        }else{
            holder=(ListDetailAdapter.ViewHolder) view.getTag();

        }
        ProductModel product=productListDetail.get(i);
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
}
