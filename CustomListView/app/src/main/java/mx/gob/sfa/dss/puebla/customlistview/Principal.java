package mx.gob.sfa.dss.puebla.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Properties;

public class Principal extends AppCompatActivity {

    public TextView inputsearch;
    ListViewAdapter ola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //* lo llamamos cuando la actividad este creada**/

        //llenamos los vectores

        final ArrayList<SearchResults> searchResults = GetSearchResults();

        inputsearch = (TextView) findViewById(R.id.inputSearch);
        final ListView lv = (ListView) findViewById(R.id.srListView);
        ola = new ListViewAdapter(this,searchResults);
        //lv.setAdapter(new ListViewAdapter(this, searchResults));
        lv.setAdapter(ola);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv.getItemAtPosition(position);
                SearchResults fullObject = (SearchResults) o;
                Toast.makeText(Principal.this, "You have chosen: " + " " + fullObject.getName() + " la posicion es " + fullObject.getPosicion(), Toast.LENGTH_LONG).show();
            }
        });

        inputsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //Principal.this.ola.getFilter.filter(s);
               //Principal.this.ola.getFilter().filter(s.toString());
               //ola.setSearchArrayList(searchResults);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int textlength = s.length();
                ArrayList<SearchResults> tempArrayList = new ArrayList<SearchResults>();
                for(SearchResults c: searchResults){
                    if (textlength <= c.getName().length()) {
                        if (c.getName().toLowerCase().contains(s.toString().toLowerCase())) {
                            tempArrayList.add(c);
                        }
                    }
                }
                ola = new ListViewAdapter(Principal.this, tempArrayList);
                lv.setAdapter(ola);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private ArrayList<SearchResults> GetSearchResults(){
        ArrayList<SearchResults> results = new ArrayList<SearchResults>();

        SearchResults sr = new SearchResults();
        sr.setName("Justin Schultz");
        sr.setCityState("San Francisco, CA");
        sr.setPhone("415-555-1234");
        sr.setPosicion("34");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("Jane Doe");
        sr.setCityState("Las Vegas, NV");
        sr.setPhone("702-555-1234");
        sr.setPosicion("34");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("Lauren Sherman");
        sr.setCityState("San Francisco, CA");
        sr.setPhone("415-555-1234");
        sr.setPosicion("34");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("Fred Jones");
        sr.setCityState("Minneapolis, MN");
        sr.setPhone("612-555-8214");
        sr.setPosicion("34");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("Bill Withers");
        sr.setCityState("Los Angeles, CA");
        sr.setPhone("424-555-8214");
        sr.setPosicion("34");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("Donald Fagen");
        sr.setCityState("Los Angeles, CA");
        sr.setPhone("424-555-1234");
        sr.setPosicion("34");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("Steve Rude");
        sr.setCityState("Oakland, CA");
        sr.setPhone("515-555-2222");
        sr.setPosicion("34");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("Roland Bloom");
        sr.setCityState("Chelmsford, MA");
        sr.setPhone("978-555-1111");
        sr.setPosicion("34");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("Sandy Baguskas");
        sr.setCityState("Chelmsford, MA");
        sr.setPhone("978-555-2222");
        sr.setPosicion("34");
        results.add(sr);

        sr = new SearchResults();
        sr.setName("Scott Taylor");
        sr.setCityState("Austin, TX");
        sr.setPhone("512-555-2222");
        sr.setPosicion("34");
        results.add(sr);

        return results;
    }
}
