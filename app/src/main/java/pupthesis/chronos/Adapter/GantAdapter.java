package pupthesis.chronos.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import pupthesis.chronos.R;

public class GantAdapter   extends ArrayAdapter<String> {
    private String[] _nameofprojectTV;
    private String[] _descriptionTV;
    private String[] _statusTV;
    private Integer[] imageid;
    private Activity context;

    public GantAdapter(Activity context, String[] __nameofprojectTV,  String[] __statusTV,String[] __descriptionTV ,Integer[] imageid) {
        super(context, R.layout.activity_gant_adapter, __nameofprojectTV);
        this.context = context;
        this._nameofprojectTV = __nameofprojectTV;
        this._statusTV = __statusTV;
        this.imageid = imageid;
        this._descriptionTV=__descriptionTV;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_gant_adapter, null, true);
        TextView nameofprojectTV = (TextView) listViewItem.findViewById(R.id.nameoftaskTV);
        TextView statusTV = (TextView) listViewItem.findViewById(R.id.dateTV);
        ImageView taskimage = (ImageView) listViewItem.findViewById(R.id.taskimage);
        TextView DescriptionTV=(TextView) listViewItem.findViewById(R.id.DescriptionTV);
        nameofprojectTV.setText(_nameofprojectTV[position]);
        DescriptionTV.setText(_descriptionTV[position]);
        statusTV.setText(_statusTV[position]);
        CardView card=(CardView)listViewItem.findViewById(R.id.card);
        try{   switch (_statusTV[position]){
            case "Not yet Started":
                taskimage.setImageResource(R.drawable.undone);
                taskimage.setBackgroundResource(R.color.undone);
                break;
            case "In progress":
                taskimage.setImageResource(R.drawable.progress);
                taskimage.setBackgroundResource(R.color.progress);
                break;
            case "Complete":
                taskimage.setImageResource(R.drawable.complete);
                taskimage.setBackgroundResource(R.color.complete);
                break;


        }}catch (Exception xx){}

        return  listViewItem;
    }
}

