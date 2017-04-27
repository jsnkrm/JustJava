/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

package com.example.jsnkrm.myapplication;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import static android.R.id.message;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int number=0;
    Boolean hasWhippedcream = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     *
     */

    public int calc_price(int number)
    {
        return number*5;
    }

    public void submitOrder(View view) {

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_wiped_cream);
        CheckBox choco = (CheckBox) findViewById(R.id.checkbox_chocolate);
        Boolean hasChoco = choco.isChecked();
        Boolean hasWhippedcream = checkBox.isChecked();
        String message = "Name:" + " Jayasankar\n";
        message = message + "Add Whipped cream? ";
        if(hasWhippedcream)
            message = message + "TRUE\n";
        else
            message = message + "FALSE\n";
        message = message + "Add chocolate? ";
        if(hasChoco)
            message = message + "TRUE\n";
        else
            message = message + "FALSE\n";
        message = message + "quantity: " + number;
        int price = calc_price(number);
        message = message + "\nPrice: $" + price + "\nThank You!!";
        printMessage(message);
    }

    public void reset(View view) {
        number = 0;
        String message = "$0";
        display(number);
        printMessage(message);
    }

    public void incQuantity(View view) {
        number++;
        display(number);
    }

    public void decQuantity(View view) {
        number--;
        display(number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    private void printMessage(String  message) {
        TextView submitOrderTextView = (TextView) findViewById(R.id.submit_order_text_view);
        submitOrderTextView.setText("" + message);
    }
}
