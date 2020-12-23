package com.iamspd.paintcanvas;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class CanvasActivity extends AppCompatActivity {

    // widgets
    private RadioGroup rgColor;
    private Spinner spinThickness;
    private RadioButton rbColor;
    private CanvasView myCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findAllViews();
    }

    private void findAllViews() {
        myCanvas = findViewById(R.id.myCanvas);
        rgColor = findViewById(R.id.rgColor);

        spinThickness = findViewById(R.id.spinThickness);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.pointer_stroke, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinThickness.setAdapter(arrayAdapter);
    }

    public void onSetPropertyClick(View view) {
        float lineWidth = Integer.parseInt(spinThickness.getSelectedItem().toString());

        int selectedId = rgColor.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        rbColor = findViewById(selectedId);

        String lineColor = rbColor.getText().toString();
        int color;

        if (lineColor.equals("Blue")) {
            color = Color.BLUE;
        } else if (lineColor.equals("Red")) {
            color = Color.RED;
        } else {
            color = Color.YELLOW;
        }

        myCanvas.setProperties(lineWidth, color);
    }

    public void onClearCanvasClick(View view) {
        myCanvas.clearPath();
    }
}