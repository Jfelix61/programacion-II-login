package com.programacion_ii_login.ui.listView;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.programacion_ii_login.data.model.Agent;
import com.programacion_ii_login.R;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    Agent agents[] = {new Agent("Mayor Monograma", "Monograma"),
            new Agent("Carl", "Asistente"),
            new Agent("Perry the Platypus", "Agente"),
            new Agent("Pinky the Chihuahua", "Agente"),
            new Agent("Peter the Panda", "Agente")};

    String sTitle[] = {"Monograma", "Asistente", "Agente"};

    int images[] = {R.drawable.mm, R.drawable.Carl, R.drawable.perry, R.drawable.pinky, R.drawable.peter};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        String[] agentsNames = new String[agents.length];

        for (int i = 0; i < agents.length; i++)
            agentsNames[i] = agents[i].getName();

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, agentsNames, sTitle, images);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(ListViewActivity.this, "Monograma", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(ListViewActivity.this, "Asistente", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(ListViewActivity.this, "Agente", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(ListViewActivity.this, "Agente", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(ListViewActivity.this, "Agente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImages[];

        MyAdapter (Context c, String title[], String sTitle[], int images[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = sTitle;
            this.rImages = images;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImages[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }

}
