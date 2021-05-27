package com.example.myapplication;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {
//    private OnTimePickerFragmentListener tListener;
    private static final String ARG_PARAM1 = "param1";
    Calendar c;
    @Override
    public Dialog onCreateDialog(Bundle savedInstance) {
        c = Calendar.getInstance();
//        Bundle args = getArguments();
//        if (args !=null) {
//            c.setTimeInMillis(args.getLong(ARG_PARAM1));
//        }
        c.setTimeInMillis(getArguments().getLong(ARG_PARAM1));
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this, hour, minute, true);
    }
    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {
//        c.set(Calendar.HOUR_OF_DAY, hour);
//        c.set(Calendar.MONTH, minute);

//
//        if (tListener !=null) {
//            tListener.onTimeSet(c);
//        }
    }

    public static TimePickerFragment newInstance(Calendar c) {
        TimePickerFragment fragment = new TimePickerFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PARAM1, c.getTimeInMillis());
        fragment.setArguments(args);
        return fragment;
    }
    public static DatePickerFragment newInstance() {
        DatePickerFragment fragment = new DatePickerFragment();

        return fragment;
    }

//    public interface OnTimePickerFragmentListener {
//        //TODO: Update argument type and name
//        void onTimeSet(Calendar c);
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnTimePickerFragmentListener) {
//            tListener = (OnTimePickerFragmentListener) context;
//
//        }else {
//            throw new RuntimeException(context.toString()
//                    + "must implement OnTimePickerFragmentListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        tListener = null;
//    }

}
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link TimePickerFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class TimePickerFragment extends Fragment {
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public TimePickerFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment TimePickerFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static TimePickerFragment newInstance(String param1, String param2) {
//        TimePickerFragment fragment = new TimePickerFragment();
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
