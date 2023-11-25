//package com.example.myapplication;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentTransaction;
//
//public class test extends Fragment {
//    MainActivity mainActivity;
//        public test(){
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        View root = inflater.inflate(R.layout.fragment_search,container,false);
//
//        Button btn = root.findViewById(R.id.cardView);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent("com.iphonik.chameleon.SearchActivity");
//                startActivity(intent);
//            }
//        });
//        return root;
//    }
//    public void onStart(){
//        super.onStart();
//
//    }
//}


