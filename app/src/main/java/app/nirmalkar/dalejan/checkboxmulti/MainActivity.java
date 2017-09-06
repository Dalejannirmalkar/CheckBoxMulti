package app.nirmalkar.dalejan.checkboxmulti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<String> arrayList=new ArrayList<String>();
    ListView listView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listitem);
        button= (Button) findViewById(R.id.selcteditem);
        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
        String[] items={"English","Hindi","Telgu","French","Itelian"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.rowlayout,R.id.textcheck,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item=((TextView)view).getText().toString();
                if (arrayList.contains(item)){
                    arrayList.remove(item);
                }
                else{
                    arrayList.add(item);
                }
            }
        });
    }
    public void showselecteditem(View view){
        String item1="";
        for (String item2:arrayList){
            item1+=": :"+item2;
        }
        Toast.makeText(this, "Show Selected Items"+"-"+item1, Toast.LENGTH_SHORT).show();

    }
}
