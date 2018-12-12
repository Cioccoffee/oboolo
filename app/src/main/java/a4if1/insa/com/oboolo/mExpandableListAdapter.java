package a4if1.insa.com.oboolo;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;

import java.util.HashMap;
import java.util.List;
import android.support.v4.app.Fragment;

public class mExpandableListAdapter implements ExpandableListAdapter {

    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    CoursesFragment2 fragment;

    public void mExpendableListAdapter(CoursesFragment2 f, List<String> listDataHeader ,
           HashMap<String, List<String>> listDataChild){
        this.fragment = f;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
    }

    public void mExpendableListAdapter(){
        //mExpendableListAdapter(null,null);
    }

    public void setFragment(CoursesFragment2 f){
        this.fragment = f;
    }

    public void setListDataHeader(List<String> listDataHeader){
        this.listDataHeader = listDataHeader;
    }

    public void setListDataChild( HashMap<String, List<String>> listDataChild){
        this.listDataChild = listDataChild;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public long getCombinedChildId(long l, long l1) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long l) {
        return 0;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public int getChildrenCount(int i) {
        return 0;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void onGroupExpanded(int i) {

    }

    @Override
    public void onGroupCollapsed(int i) {

    }

    @Override
    public Object getGroup(int i) {
        return null;
    }
}
