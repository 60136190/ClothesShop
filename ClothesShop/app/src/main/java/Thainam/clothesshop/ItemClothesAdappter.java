package Thainam.clothesshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemClothesAdappter extends RecyclerView.Adapter<ItemClothesAdappter.ItemViewHolder>{

    private Context mContext;
    private List<Item> item1;

    public ItemClothesAdappter(Context mContext, List<Item> item) {
        this.mContext = mContext;
        this.item1 = item;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Item item = item1.get(position);
        if(item == null){
            return;
        }
        holder.itemImage.setImageResource(item.getImage());
        holder.itemtxt.setText(item.getName());
//        holder.itemtxt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               Intent intent1 = new Intent(mContext,DetailActivity.class);
//               mContext.startActivity(intent1);
//            }
//        });


//        holder.tvdetail.setText(itemScfi.getDetail());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickgotoDetail(item);
            }
        });
    }
    private void onClickgotoDetail(Item item) {
        Intent intent = new Intent(mContext,DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object",item);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }
    @Override
    public int getItemCount() {

        if(item1 != null){
            return item1.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemtxt;

        LinearLayout layoutItem;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);
            itemImage=itemView.findViewById(R.id.itemImage);
            itemtxt=itemView.findViewById(R.id.tv_price);
            itemtxt=itemView.findViewById(R.id.tv_name);

        }
    }

}
