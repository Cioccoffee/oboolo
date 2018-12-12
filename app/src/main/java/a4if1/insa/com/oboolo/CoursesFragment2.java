package a4if1.insa.com.oboolo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import android.widget.ExpandableListView;
import android.widget.ExpandableListAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CoursesFragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CoursesFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoursesFragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    mExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public CoursesFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CoursesFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static CoursesFragment2 newInstance(String param1, String param2) {
        CoursesFragment2 fragment = new CoursesFragment2();
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

        expListView = (ExpandableListView) getView().findViewById(R.id.lv_courses);

        // preparing list data
        //prepareListData();

        //listAdapter = new mExpandableListAdapter((CoursesFragment2)this, listDataHeader, listDataChild);
        listAdapter = new mExpandableListAdapter();
        listAdapter.setFragment(this);
        listAdapter.setListDataHeader(listDataHeader);
        listAdapter.setListDataChild(listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                //selected item
                if(listDataHeader.get(groupPosition).equalsIgnoreCase("Catalog")){
                    /*Intent i = new Intent(MainActivity.this, Departments.class);
                    // sending data to new activity
                    startActivity(i);*/
                }

                if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Check Holds")){

                    /*Intent i1 = new Intent(MainActivity.this,CheckHolds.class);
                    startActivity(i1);*/
                }
                if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Unreserve Books")){

                    /*Intent i2 = new Intent(MainActivity.this,UnreserveBooks.class);
                    startActivity(i2);*/
                }
                if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Library Hours")){

                    /*Intent i3 = new Intent(MainActivity.this,LibraryHours.class);
                    startActivity(i3);*/
                }
                if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equalsIgnoreCase("Contact Library")){

                    /*Intent i4 = new Intent(MainActivity.this,ContactLibrary.class);
                    startActivity(i4);*/
                }
                if(listDataHeader.get(groupPosition).equalsIgnoreCase("Logout")){
                    /*Intent i5 = new Intent(MainActivity.this, Departments.class);
                    startActivity(i5);*/
                }
                return false;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_courses_fragment2, container, false);
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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

    public void prepareListData(){

    }
}