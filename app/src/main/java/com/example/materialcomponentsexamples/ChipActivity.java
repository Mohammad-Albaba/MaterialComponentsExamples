package com.example.materialcomponentsexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class ChipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chip);

        Chip chip = findViewById(R.id.chip);
        chip.setLayoutDirection(View.LAYOUT_DIRECTION_LOCALE);
        chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChipActivity.this, "Chip Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        chip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChipActivity.this, "Close Icon Clicked!", Toast.LENGTH_SHORT).show();

            }
        });
        Chip chip2 = findViewById(R.id.chip2);
        chip2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ChipActivity.this, "is Checked " + isChecked, Toast.LENGTH_SHORT).show();

            }
        });
        ChipGroup chipGroup = findViewById(R.id.chip_group);
        // لو في زر سبمينت بنستعمل هاد الجملة اللي تحت عشان احصل على الايدي
//        chipGroup.getCheckedChipIds();
        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                System.out.println("checkedId" + checkedId);
//                switch (checkedId){
//                    case R.id.filter1 :
//                        System.out.println("filter1");
//                        break;
//                }
            }
        });

        ImageView imageView = findViewById(R.id.image_view);
        ChipDrawable chipDrawable = ChipDrawable.createFromResource(this , R.xml.contact_chip);
        imageView.setImageDrawable(chipDrawable);



        TextView textView = findViewById(R.id.text_view);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("Mohammad Ayman Aneas");
        ChipDrawable chipDrawable1 = ChipDrawable.createFromResource(this , R.xml.contact_chip);
        chipDrawable1.setText("Mohammad");
        chipDrawable1.setCloseIconEndPadding(20);
        chipDrawable1.setCloseIconStartPadding(20);
        chipDrawable1.setBounds(0,0, chipDrawable1.getIntrinsicWidth() , chipDrawable1.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(chipDrawable1);
        spannableStringBuilder.setSpan(imageSpan , 0 , 6 ,Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        textView.setText(spannableStringBuilder);


        // MultiAutoCompleteTextView :
        List<Contacts> contacts = new ArrayList<>();
        contacts.add(new Contacts(1 ,"Kareem", "kareem@gmail.com"));
        contacts.add(new Contacts(2 ,"Mohammad", "Mohammad@gmail.com"));
        contacts.add(new Contacts(3 ,"Nour", "nour@gmail.com"));
        contacts.add(new Contacts(4 ,"Tamer", "tamer@gmail.com"));
        contacts.add(new Contacts(5 ,"Ayman", "ayman@gmail.com"));

        MultiAutoCompleteTextView multiAutoCompleteTextView = findViewById(R.id.multitext);
        ArrayAdapter<Contacts> arrayAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , contacts);
        multiAutoCompleteTextView.setAdapter(arrayAdapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiAutoCompleteTextView.setThreshold(1);
        multiAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contacts contacts = arrayAdapter.getItem(position);
                multiAutoCompleteTextView.getText().replace(
                        multiAutoCompleteTextView.getSelectionEnd() - contacts.getEmail().length() - 2,
                        multiAutoCompleteTextView.getSelectionEnd() ,
                        createEntry(contacts.getName())
                );
            }
        });

    }
    private Spannable createEntry(String name){
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
        ChipDrawable chipDrawable = ChipDrawable.createFromResource(this , R.xml.contact_chip);
        chipDrawable.setText(name);
        chipDrawable.setBounds(0 , 0 , chipDrawable.getIntrinsicWidth() , chipDrawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(chipDrawable);
        spannableStringBuilder.setSpan(imageSpan , 0 ,name.length() , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        return  spannableStringBuilder.append(", ");
    }
}