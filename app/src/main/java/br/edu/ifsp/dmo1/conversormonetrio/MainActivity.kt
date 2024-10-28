package br.edu.ifsp.dmo1.conversormonetrio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException;

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private val DOLLAR_VALUE = 5.0;

    private lateinit var inputEditText: EditText;
    private lateinit var toDollarButton: Button;
    private lateinit var toRealButton: Button;
    private lateinit var outputTextView: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findById();
        configClikListener();
    }

    //onClik => Responsavel por identificar o elemento que foi clicado na interface.
    //A view clicada é passada como argumento do metodo

    override fun onClick(v: View) {
        if(v == toDollarButton){
            dollarConversion();
        } else if(v == toRealButton){
            realConversion();
        }
    }

    private fun findById(){
        inputEditText = findViewById(R.id.edittext_value);
        toDollarButton = findViewById(R.id.button_convert_to_dollar);
        toRealButton = findViewById(R.id.button_convert_to_real);
        outputTextView = findViewById(R.id.textview_output);
    }

    //Configura como será tratado o clique

    private fun configClikListener(){
        toRealButton.setOnClickListener(this);
        toDollarButton.setOnClickListener(this);
    }

    private fun getValue(): Double{
        return try {
            inputEditText.text.toString().toDouble();
        } catch (e: NumberFormatException){
            0.0;
        }
    }

    private fun dollarConversion(){
        var value = getValue();
        value = value / DOLLAR_VALUE;

        outputTextView.text = "U$ $value";
    }

    private fun realConversion(){
        var value = getValue();
        value = value * DOLLAR_VALUE;

        outputTextView.text = "R$ $value";
    }
}