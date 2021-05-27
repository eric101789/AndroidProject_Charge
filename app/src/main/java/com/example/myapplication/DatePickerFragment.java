/*實作DatePickerDialog用來讓使用者設定日期
* @author AJ, Yang 2020/05/25
* @exception RuntimeException()
*
* 呼叫方式
* 1. 可以輸入預設日期:
* DialogFragment dateFragment = DatePickerFragment.newInstance(Calendar c);
* dateFragment.show(getSupportFragmentManager(), "datePicker");
* 2. 以目前時間為預設日期:
* DialogFragment dateFragment = DatePickerFragment.newInstance();
* dateFragment.show(getSupportFragmentManager(), "datePicker");
*
* 回傳方式:
* 實作 OnDatePickerFragmentListener 介面，實作 OnDateSet(Calendar c)
*/

package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {
        private OnDatePickerFragmentListener mListener;
        private static final String ARG_PARAM1 = "param1";
        Calendar c;
    @Override
    public Dialog onCreateDialog(Bundle savedInstance) {
        c = Calendar.getInstance();
        Bundle args = getArguments();
        if (args !=null) {
            c.setTimeInMillis(args.getLong(ARG_PARAM1));
        }

        c.setTimeInMillis(getArguments().getLong(ARG_PARAM1));
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);

        if (mListener !=null) {
            mListener.onDateSet(c);
        }
    }
    public static DatePickerFragment newInstance(Calendar c) {
        DatePickerFragment fragment = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PARAM1, c.getTimeInMillis());
        fragment.setArguments(args);
        return fragment;
    }

    public static DatePickerFragment newInstance() {
        DatePickerFragment fragment = new DatePickerFragment();

        return fragment;
    }

    public interface OnDatePickerFragmentListener {
        //TODO: Update argument type and name
        void onDateSet(Calendar c);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDatePickerFragmentListener) {
            mListener = (OnDatePickerFragmentListener) context;

            }else {
            throw new RuntimeException(context.toString()
                    + "must implement OnDatePickerFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link DatePickerFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class DatePickerFragment extends Fragment {
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public DatePickerFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment DatePickerFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static DatePickerFragment newInstance(String param1, String param2) {
//        DatePickerFragment fragment = new DatePickerFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        TextView textView = new TextView(getActivity());
//        textView.setText(R.string.hello_blank_fragment);
//        return textView;
//    }
//}
