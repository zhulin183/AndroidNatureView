package personal.buqx.andoridnatureview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Function:
 */

public class TabFragment extends Fragment {

    private static final String ARG_STRING_CONTENT = "ARG_STRING_CONTENT";

    public static TabFragment createTabFragment(String content) {
        Bundle arguments = new Bundle();
        arguments.putString(ARG_STRING_CONTENT, content);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(arguments);
        return tabFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frame_pager, container, false);

        TextView textView = (TextView) root.findViewById(R.id.frame_page_text);
        textView.setText(getArguments().getString(ARG_STRING_CONTENT));

        return root;
    }
}
