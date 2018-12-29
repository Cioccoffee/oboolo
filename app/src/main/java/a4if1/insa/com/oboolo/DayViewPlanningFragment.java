package a4if1.insa.com.oboolo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.LinkedList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DayViewPlanningFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DayViewPlanningFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DayViewPlanningFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private WeekView mWeekView;
    private com.alamkanak.weekview.WeekView.EventClickListener mEventClickListener;
    //private com.alamkanak.weekview.MonthLoader.MonthChangeListener mMonthChangeListener;
    private com.alamkanak.weekview.WeekView.EventLongPressListener mEventLongPressListener;

    private DayViewPlanningFragment.OnFragmentInteractionListener mListener;

    public DayViewPlanningFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DayViewPlanningFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DayViewPlanningFragment newInstance(String param1, String param2) {
        DayViewPlanningFragment fragment = new DayViewPlanningFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        /*int newYear = 2018;
        int newMonth = 12;*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_day_view_planning, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MonthLoader.MonthChangeListener mMonthChangeListener = new MonthLoader.MonthChangeListener() {
            @Override
            public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                // Populate the week view with some events.
                List<WeekViewEvent> events = getEvents(newYear, newMonth);
                return events;
            }
        };
        // Get a reference for the week view in the layout.
        mWeekView = (WeekView) getView().findViewById(R.id.weekViewDay);

        // Set an action when any event is clicked.
        mWeekView.setOnEventClickListener(mEventClickListener);

        // The week view has infinite scrolling horizontally. We have to provide the events of a
        // month every time the month changes on the week view.
        mWeekView.setMonthChangeListener(mMonthChangeListener);

        // Set long press listener for events.
        mWeekView.setEventLongPressListener(mEventLongPressListener);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public List<WeekViewEvent> getEvents(int newYear, int newMonth){
        LinkedList<WeekViewEvent> weekViewEventLinkedList = new LinkedList<>();
        Log.v("EVENTS","newMonth : "+newMonth+" | newYear : "+newYear);
        if(newYear == 2018 && newMonth == 12) {
            WeekViewEvent weekViewEvent1 =
                    new WeekViewEvent(1, "event1",
                            2018, 12, 28, 10, 32,
                            2018, 12, 28, 11, 0);
//WeekViewEvent(long id, String name, int startYear, int startMonth, int startDay, int startHour, int startMinute, int endYear, int endMonth, int endDay, int endHour, int endMinute) {
//
//
            WeekViewEvent weekViewEvent2 =
                    new WeekViewEvent(2, "event2",
                            2018, 12, 28, 16, 0,
                            2018, 12, 28, 18, 0);
            WeekViewEvent weekViewEvent3 =
                    new WeekViewEvent(3, "event3",
                            2018, 12, 30, 10, 32,
                            2018, 12, 30, 11, 0);


            weekViewEventLinkedList.add(weekViewEvent1);
            weekViewEventLinkedList.add(weekViewEvent2);
            weekViewEventLinkedList.add(weekViewEvent3);
        }
        return weekViewEventLinkedList;
    }
}
