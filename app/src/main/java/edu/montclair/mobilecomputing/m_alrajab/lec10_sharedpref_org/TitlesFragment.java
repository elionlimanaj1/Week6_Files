package edu.montclair.mobilecomputing.m_alrajab.lec10_sharedpref_org;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static edu.montclair.mobilecomputing.m_alrajab.lec10_sharedpref_org.utils.Utils.getListOfFiles;
import static edu.montclair.mobilecomputing.m_alrajab.lec10_sharedpref_org.utils.Utils.getContentOfFile;

public class TitlesFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    public TitlesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_titles, container, false);
        ListView ls = (ListView) view.findViewById(R.id.list_frg);
        ls.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, getListOfFiles(getContext())));
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mListener.onFragmentInteraction(getContentOfFile(getContext(), ((AppCompatTextView) view).getText().toString()));
            }
        });
        return view;
    }

    public void onButtonPressed(String uri) {
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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String uri);
    }
}