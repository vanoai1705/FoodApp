package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.R;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.TopOrderItem;

public class TopOrderAdapter extends BaseAdapter {

    private List<TopOrderItem> topOrderItemList;
    private int myLayout;
    private Context context;


    public TopOrderAdapter(List<TopOrderItem> topOrderItemList, int myLayout, Context context) {
        this.topOrderItemList = topOrderItemList;
        this.myLayout = myLayout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return topOrderItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    static class ViewHolder {
        ImageView foodView;
        TextView titleView;
        TextView subTitleView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view=inflater.inflate(myLayout,null);

        //Anh xa va gan gia tri
        TextView txtTen=(TextView) view.findViewById(R.id.textView_titleTopDetail);
        txtTen.setText(topOrderItemList.get(i).getTitle());

        TextView txtGia=(TextView) view.findViewById(R.id.textView_subtitle);
        txtGia.setText(topOrderItemList.get(i).getSubtitle()+"");

        ImageView imgHinh=(ImageView) view.findViewById(R.id.imageView_foodTopDetailOrder);
        imgHinh.setImageResource(topOrderItemList.get(i).getImgFood());

        return view;
    }
    // Find Image ID corresponding to the name of the image (in the directory mipmap).
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
}
