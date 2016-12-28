package njj.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jian on 2016/12/27.
 */
public class MyFragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("niejianjian","MyFragment3 -> onCreateView ->");
        View view = inflater.inflate(R.layout.fragment_my3, container, false);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("niejianjian","MyFragment3 -> onAttach ->");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("niejianjian","MyFragment3 -> onCreate ->");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("niejianjian","MyFragment3 -> onActivityCreated ->");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("niejianjian","MyFragment3 -> onStart ->");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("niejianjian","MyFragment3 -> onResume ->");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("niejianjian","MyFragment3 -> onPause ->");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("niejianjian","MyFragment3 -> onStop ->");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("niejianjian","MyFragment3 -> onDestroyView ->");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("niejianjian","MyFragment3 -> onDetach ->");
    }
}
