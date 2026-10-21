package com.example.productdatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView idView;
    EditText productBox;
    EditText skuBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idView = findViewById(R.id.productID);
        productBox = findViewById(R.id.productName);
        skuBox = findViewById(R.id.productSku);
    }

    // Méthode appelée lors du clic sur le bouton "Ajouter"
    public void newProduct(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this);

        int sku = Integer.parseInt(skuBox.getText().toString());
        Product product = new Product(productBox.getText().toString(), sku);

        dbHandler.addProduct(product);
        productBox.setText("");
        skuBox.setText("");
        idView.setText("Produit ajouté avec succès !");
    }

    // Méthode appelée lors du clic sur le bouton "Rechercher"
    public void lookupProduct(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this);

        Product product = dbHandler.findProduct(productBox.getText().toString());

        if (product != null) {
            idView.setText(String.valueOf(product.getID()));
            skuBox.setText(String.valueOf(product.getSku()));
        } else {
            idView.setText("Aucun match trouvé");
        }
    }

    // Méthode appelée lors du clic sur le bouton "Supprimer"
    public void deleteProduct(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this);

        boolean result = dbHandler.deleteProduct(productBox.getText().toString());

        if (result) {
            idView.setText("Enregistrement supprimé");
            productBox.setText("");
            skuBox.setText("");
        } else {
            idView.setText("Aucune correspondance trouvée");
        }
    }
}