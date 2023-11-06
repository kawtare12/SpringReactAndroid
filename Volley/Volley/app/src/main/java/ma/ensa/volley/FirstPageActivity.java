package ma.ensa.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        Button btnGestionFiliere = findViewById(R.id.btnGestionFiliere);
        Button btnGestionEtudiant = findViewById(R.id.btnGestionEtudiant);
        Button btnGestionRole = findViewById(R.id.btnGestionRole);

        btnGestionFiliere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPageActivity.this, ListFiliereActivity.class);
                startActivity(intent);
            }
        });

        btnGestionEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPageActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });

        btnGestionRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPageActivity.this, ListRoleActivity.class);
                startActivity(intent);
            }
        });
    }

}