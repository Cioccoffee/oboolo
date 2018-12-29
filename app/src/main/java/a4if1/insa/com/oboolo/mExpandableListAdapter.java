package a4if1.insa.com.oboolo;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.support.v4.app.Fragment;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class mExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeader;
    private List<SubjectData> listSubjectData;
    private CoursesFragment2 fragment;

    public mExpandableListAdapter(Context context, CoursesFragment2 f, List<String> listDataHeader
           ){
        this.context = context;
        this.fragment = f;
        this.listDataHeader = listDataHeader;
        listSubjectData = new ArrayList<>(listDataHeader.size());
        for(int i=0; i<listDataHeader.size(); i++){
            listSubjectData.add(new SubjectData());
        }

    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean b, View view, ViewGroup viewGroup) {
        SubjectData data = (SubjectData)getChild(groupPosition, childPosition);
        if (view==null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.subject_view, null);
        }
        SeekBar affinitySeekBar = (SeekBar)view.findViewById(R.id.subject_affinity_seekbar);
        affinitySeekBar.setProgress(data.getAffinityLevel());
        affinitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                if (fromUser) {
                    listSubjectData.get(groupPosition).setAffinityLevel(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        SeekBar workSeekBar = (SeekBar)view.findViewById(R.id.subject_work_seekbar);
        workSeekBar.setProgress(data.getWorkLevel());
        workSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                if (fromUser) {
                    listSubjectData.get(groupPosition).setWorkLevel(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        CheckBox targetCheckBox = (CheckBox)view.findViewById(R.id.subject_target_checkbox);
        targetCheckBox.setChecked(data.hasTargetedScore());
        targetCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                listSubjectData.get(groupPosition).setTargetedScore(b);
            }
        });
        EditText desiredScoreEditText = (EditText)view.findViewById(R.id.subject_target_edittext);
        desiredScoreEditText.setText(""+data.getDesiredScore());
        desiredScoreEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_DONE ||
                        event != null &&
                                event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (event == null || !event.isShiftPressed()) {
                        // the user is done typing.
                        try{
                            int a = Integer.parseInt(textView.getText().toString());
                            listSubjectData.get(groupPosition).setDesiredScore(a);
                        } catch ( Exception e) {
                            return false;
                        }
                        return true; // consume.
                    }
                }
                return false;
            }
        });
        return view;
    }



    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
       String headerTitle = (String) getGroup(groupPosition);
       if (view==null){
           LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           view = inflater.inflate(R.layout.group_view, null);
       }
       TextView lblListHeader = (TextView)view.findViewById(R.id.lblListHeader);
       lblListHeader.setTypeface(null, Typeface.BOLD);
       lblListHeader.setText(headerTitle);

       return view;
    }

    @Override
    public boolean hasStableIds() { return false; }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition){
        return false;
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public long getGroupId(int groupPosition){
        return groupPosition;
    }

    @Override
    public int getGroupCount(){
        return this.listDataHeader.size();
    }

    @Override
    public Object getGroup(int groupPosition){
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition){
        return childPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition){
        return listSubjectData.get(groupPosition);
    }


}
