package ma.ensa.volley.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

import ma.ensa.volley.R;
import ma.ensa.volley.Role;

public class RoleAdapter extends ArrayAdapter<Role> {

    private ArrayList<Role> RoleList;
    private Context context;

    public RoleAdapter(Context context, ArrayList<Role> etudiantList) {
        super(context, 0, etudiantList);
        this.context = context;
        this.RoleList = etudiantList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Role role = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_role, parent, false);
        }

        TextView nameTextView = convertView.findViewById(R.id.name);



        if (role != null) {
            nameTextView.setText(role.getName());


        }

        return convertView;
    }
}
