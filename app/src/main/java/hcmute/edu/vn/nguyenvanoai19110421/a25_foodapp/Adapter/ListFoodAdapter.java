package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Model.ProductModel;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.R;


public class ListFoodAdapter extends  RecyclerView.Adapter<ListFoodAdapter.ListFoodViewHolder> {

    private List<ProductModel> mListProduct;

    public ListFoodAdapter(List<ProductModel> mListProduct) {
        this.mListProduct = mListProduct;
    }

    @NonNull
    @Override
    public ListFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_rows,parent,false);
        return new ListFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListFoodViewHolder holder, int position) {
        ProductModel product= mListProduct.get(position);
        if (product==null){
            return;
        }
        holder.txtListFoodname.setText(product.getTen());
        holder.txtListFoodSub.setText(product.getMoTa());
        byte[] Hinh=product.getHinh();
        Bitmap bitmap= BitmapFactory.decodeByteArray(Hinh,0,Hinh.length);
        holder.img.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        if(mListProduct !=null)
            return mListProduct.size();
        return 0;
    }


    public class ListFoodViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView txtListFoodname,txtListFoodSub;

        public ListFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imgProductRow);
            txtListFoodname=itemView.findViewById(R.id.txtNameRow);
            txtListFoodSub=itemView.findViewById(R.id.txtDesRow);


        }
    }
}
