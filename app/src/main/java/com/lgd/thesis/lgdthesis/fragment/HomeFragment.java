package com.lgd.thesis.lgdthesis.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lgd.thesis.lgdthesis.R;
import com.lgd.thesis.lgdthesis.bean.ThesisMessage;
import com.lgd.thesis.lgdthesis.databinding.FragmentHomeBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    FragmentHomeBinding mBinding;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }
}
