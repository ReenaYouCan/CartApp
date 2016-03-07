package com.cuelogic.cartapp.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cuelogic.cartapp.R;
import com.cuelogic.cartapp.model.CAGetProductDetailsModel;
import com.cuelogic.cartapp.views.adapters.CAGetFragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Reena on 07-03-2016.
 */
public class CAAddToCartFragment extends Fragment implements CAGetFragmentPagerAdapter.OnAddRemoveClickListener{
    private View mView;
    public static final String ARG_PAGE = "ARG_PRODUCT";
    ArrayList<CAGetProductDetailsModel> productList;
    RecyclerView mProductGrid;


//    public static CAAddToCartFragment newInstance(ArrayList<CAGetProductDetailsModel> product) {
//        Bundle args = new Bundle();
//        args.putParcelableArray(ARG_PAGE, product);
//        CAAddToCartFragment fragment = new CAAddToCartFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productList = getArguments().getParcelable(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_aadremov_cart, container, false);
        return mView;
    }

    public void initViews() {
        mProductGrid = (RecyclerView) mView.findViewById(R.id.recycler_view);
        mProductGrid.setAdapter(new CAGetFragmentPagerAdapter(getActivity(),productList,R.layout.card_view_grid,this));
    }

    @Override
    public void onAddToCart(int pos, boolean isAdded) {
//        productList.set(pos,productList.get(pos).setmIsAddedToCart(true);
    }
}
