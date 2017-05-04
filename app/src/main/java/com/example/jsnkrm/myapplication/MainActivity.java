/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

package com.example.jsnkrm.myapplication;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int number=1;
    Boolean hasWhippedcream = false;
    Boolean hasChoco = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     *
     */
    public int calc_price(int number,View view)
    {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_wiped_cream);
        CheckBox choco = (CheckBox) findViewById(R.id.checkbox_chocolate);
        hasChoco = choco.isChecked();
        hasWhippedcream = checkBox.isChecked();
        if(hasChoco || hasWhippedcream)
            if(hasChoco && !(hasWhippedcream))
                return (2+number)*5;
            else if(!(hasChoco) && hasWhippedcream)
                return (1+number)*5;
            else
                return (3+number)*5;
        else
            return (number*5);

    }

    public String getname()
    {
        EditText text = (EditText) findViewById(R.id.name);
        String name = text.getText().toString();
        return name;
    }

    public void submitOrder(View view) {


        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_wiped_cream);
        CheckBox choco = (CheckBox) findViewById(R.id.checkbox_chocolate);
        Boolean hasChoco = choco.isChecked();
        Boolean hasWhippedcream = checkBox.isChecked();
        String message = "Name:" + getname() + "\n";
        message = message + "Add Whipped cream? ";
        if (hasWhippedcream)
            message = message + "TRUE\n";
        else
            message = message + "FALSE\n";
        message = message + "Add chocolate? ";
        if (hasChoco)
            message = message + "TRUE\n";
        else
            message = message + "FALSE\n";
        message = message + "quantity: " + number;
        int price = calc_price(number, view);
        message = message + "\nPrice: $" + price + "\nThank You!!";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "abc@xyz.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);


        }
    }

    public void reset(View view) {
        number = 1;
        display(number);
    }

    public void incQuantity(View view) {
        number++;
        if(number > 100)
            number = 100;
        display(number);
    }

    public void decQuantity(View view) {
        number--;
        if(number <1)
            number = 1;
        display(number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



}
