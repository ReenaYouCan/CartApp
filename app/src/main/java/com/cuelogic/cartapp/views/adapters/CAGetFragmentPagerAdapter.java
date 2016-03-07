package com.cuelogic.cartapp.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cuelogic.cartapp.R;
import com.cuelogic.cartapp.model.CAGetProductDetailsModel;

import java.util.ArrayList;

/**
 * Created by Reena on 07-03-2016.
 */

public class CAGetFragmentPagerAdapter extends RecyclerView.Adapter<CAGetFragmentPagerAdapter.RecyclerViewHolders> {
    private ArrayList<CAGetProductDetailsModel> mArrProductList;
    private Context mContext;
    private int mCardViewLayout;
    private OnAddRemoveClickListener mAddToCartListener;
    private int mFlag;

    /**
     * Constructor
     *
     * @param context
     * @param itemlist
     * @param layout
     */
    public CAGetFragmentPagerAdapter(Context context, ArrayList<CAGetProductDetailsModel> itemlist, int layout, OnAddRemoveClickListener listener) {
        this.mArrProductList = itemlist;
        this.mContext = context;
        this.mCardViewLayout = layout;
        this.mAddToCartListener = listener;

    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(mCardViewLayout, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public int getItemCount() {
        return mArrProductList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, final int position) {
        CAGetProductDetailsModel productModel = mArrProductList.get(position);
        holder.productName.setText(productModel.getmPName());
        holder.productPrice.setText(productModel.getmPPRice());
        holder.vendorName.setText(productModel.getmPVendorName());
        holder.vendorAddress.setText(productModel.getmPVendorAddress());

        //TODO add image loader
        String productImageUrl = productModel.getmPImgUrl();

        // Listeners
        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddToCartListener.onAddToCart(position, true);
            }
        });

        holder.removeFromCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddToCartListener.onAddToCart(position, false);
            }
        });

    }

    /**
     * Holder Class
     */
    public class RecyclerViewHolders extends RecyclerView.ViewHolder {

        public TextView productName;
        public ImageView ivProduct;
        public TextView productPrice;
        public TextView vendorName;
        public TextView vendorAddress;
        public Button addToCart;
        public Button removeFromCart;

        /**
         * Provide view to holder
         *
         * @param itemView
         */
        public RecyclerViewHolders(View itemView) {
            super(itemView);

            productName = (TextView) itemView.findViewById(R.id.tvProductName);
            ivProduct = (ImageView) itemView.findViewById(R.id.ivProduct);
            productPrice = (TextView) itemView.findViewById(R.id.tvProductPrice);
            vendorName = (TextView) itemView.findViewById(R.id.tvVendorName);
            vendorAddress = (TextView) itemView.findViewById(R.id.tvVendorAddress);
            addToCart = (Button) itemView.findViewById(R.id.btnAddToCart);
            removeFromCart = (Button) itemView.findViewById(R.id.btnRemoveFromCart);
        }

    }

    /**
     * Add to cart click call back
     */
    public interface OnAddRemoveClickListener {
        void onAddToCart(int pos, boolean isAdded);
    }


}