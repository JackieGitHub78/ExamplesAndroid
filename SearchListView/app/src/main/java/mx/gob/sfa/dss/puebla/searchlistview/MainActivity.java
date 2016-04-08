package mx.gob.sfa.dss.puebla.searchlistview;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // List view
    private ListView lv;
    // Listview Adapter
    private ArrayAdapter<String> adapter;

    // Search EditText
    private EditText inputSearch;
    // ArrayList for Listview
    private ArrayList<HashMap<String, String>> productList;
    //dialogo
    private Dialog h;

    private Button boton;

    private List<Entidad> hola;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hola = new ArrayList<Entidad>();
        hola.add(new Entidad("jackie", "33345333333"));
        hola.add(new Entidad("david","34545345345"));
        hola.add(new Entidad("jackie","3335633333"));
        hola.add(new Entidad("david","345345345"));
        hola.add(new Entidad("jartckie","3333453433333"));
        hola.add(new Entidad("dartvid","345344565345"));
        hola.add(new Entidad("jackie","33333333"));
        hola.add(new Entidad("davrtid","345343455345"));
        hola.add(new Entidad("jackie","33334533333"));
        hola.add(new Entidad("davidrt","345343455345"));
        hola.add(new Entidad("davirtd","345343455345"));



        // Listview Data
        String products[] = {"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE",
                "iPhone 4S", "Samsung Galaxy Note 800",
                "Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro"};



        String p[] = new String[hola.size()];

        for(int i = 0 ; i<p.length; i++)
        {
            p[i] = hola.get(i).getNombre() +" " + "\n" + " "+ hola .get(i).getTelefono();
        }

        for (int i = 0; i<p.length; i++)
        {
            Log.e("es"," " + p[i].toString());
        }

//codigo dialogo
        h = new Dialog(MainActivity.this);
        h.setContentView(R.layout.searh_listview);

        lv = (ListView) h.findViewById(R.id.list_view);
        inputSearch = (EditText) h.findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name,p);
        lv.setAdapter(adapter);
        //lv.setAdapter(adapter2);
//****

        //mtodo para que al dar click en la lista haga una accion;
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("clic en la posicion", ": " + position + "el id es:" + id);
            }
        });


        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                MainActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });




       /* boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h.setCancelable(false);
                h.show();

            }
        });*/
    }


    public void activa(View v)
    {
        h.setCancelable(false);
        h.show();
    }

}
