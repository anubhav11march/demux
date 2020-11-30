package com.demux.task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {

    Fragment fragment;
    ArrayList<Question> questions;
    LinearLayout fabFilter;
    BottomSheetBehavior<LinearLayout> bottomSheetBehavior;
    BoomMenuButton boomMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        questions = new ArrayList<>();
        populateList(questions);

        viewDefaultFragment();
        fabFilter = findViewById(R.id.fab_filter);
        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet));
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });



        boomMenuButton = findViewById(R.id.boom);
        SimpleCircleButton.Builder builder = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.diff);
        SimpleCircleButton.Builder builder1 = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.company);
        SimpleCircleButton.Builder builder2 = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.topic);
        SimpleCircleButton.Builder builder3 = new SimpleCircleButton.Builder()
                .normalImageRes(R.drawable.type);
        boomMenuButton.addBuilder(builder);
        boomMenuButton.addBuilder(builder1);
        boomMenuButton.addBuilder(builder2);
        boomMenuButton.addBuilder(builder3);

        fabFilter.setOnClickListener(v -> {
//            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            boomMenuButton.boom();
        });
    }

    void viewDefaultFragment(){
        fragment = new QuestionsFragment(questions, new ArrayList<>(), this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_layout, fragment);
        ft.commit();
    }



    void populateList(ArrayList<Question> questions){
        questions.add(
                new Question("Two Sum",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Easy"),
                                new Tag("company", "Adobe"),
                                new Tag("type", "online-test"),
                                new Tag("topic", "Arrays")
                                )),
                                49,
                                "none"
                        )
        );

        questions.add(
                new Question("Add Two Numbers",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Medium"),
                                new Tag("company", "Microsoft"),
                                new Tag("type", "online-test"),
                                new Tag("topic", "Maths")
                        )),
                        26,
                        "none"
                )
        );

        questions.add(
                new Question("Median of Two Sorted Arrays",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Hard"),
                                new Tag("company", "Google"),
                                new Tag("type", "online-test"),
                                new Tag("topic", "Arrays")
                        )),
                        33,
                        "none"
                )
        );

        questions.add(
                new Question("ZigZag Conversion",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Medium"),
                                new Tag("company", "Paytm"),
                                new Tag("type", "personal-interview"),
                                new Tag("topic", "General")
                        )),
                        5,
                        "none"
                )
        );

        questions.add(
                new Question("Reverse Integer",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Easy"),
                                new Tag("company", "Adobe"),
                                new Tag("type", "personal-interview"),
                                new Tag("topic", "Maths")
                        )),
                        29,
                        "none"
                )
        );

        questions.add(
                new Question("Palindrome Number",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Easy"),
                                new Tag("company", "Swiggy"),
                                new Tag("type", "online-test"),
                                new Tag("topic", "Maths")
                        )),
                        9,
                        "none"
                )
        );

        questions.add(
                new Question("Integer to Roman",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Medium"),
                                new Tag("company", "Paytm"),
                                new Tag("type", "online-test"),
                                new Tag("topic", "Maths")
                        )),
                        45,
                        "none"
                )
        );

        questions.add(
                new Question("Valid Parentheses",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Hard"),
                                new Tag("company", "Asus"),
                                new Tag("type", "online-test"),
                                new Tag("topic", "Stacks")
                        )),
                        21,
                        "none"
                )
        );

        questions.add(
                new Question("Implement strStr()",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Easy"),
                                new Tag("company", "IBM"),
                                new Tag("type", "personal-interview"),
                                new Tag("topic", "Strings")
                        )),
                        12,
                        "none"
                )
        );

        questions.add(
                new Question("Two Sum",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Easy"),
                                new Tag("company", "Adobe"),
                                new Tag("type", "online-test"),
                                new Tag("topic", "Arrays")
                        )),
                        49,
                        "none"
                )
        );

        questions.add(
                new Question("Add Two Numbers",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Medium"),
                                new Tag("company", "Microsoft"),
                                new Tag("type", "online-test"),
                                new Tag("topic", "Maths")
                        )),
                        26,
                        "none"
                )
        );

        questions.add(
                new Question("Median of Two Sorted Arrays",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Hard"),
                                new Tag("company", "Google"),
                                new Tag("type", "online-test"),
                                new Tag("topic", "Arrays")
                        )),
                        33,
                        "none"
                )
        );

        questions.add(
                new Question("ZigZag Conversion",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Medium"),
                                new Tag("company", "Paytm"),
                                new Tag("type", "personal-interview"),
                                new Tag("topic", "General")
                        )),
                        5,
                        "none"
                )
        );

        questions.add(
                new Question("Reverse Integer",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Easy"),
                                new Tag("company", "Adobe"),
                                new Tag("type", "personal-interview"),
                                new Tag("topic", "Maths")
                        )),
                        29,
                        "none"
                )
        );

        questions.add(
                new Question("Palindrome Number",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Easy"),
                                new Tag("company", "Swiggy"),
                                new Tag("type", "online-test"),
                                new Tag("topic", "Maths")
                        )),
                        9,
                        "none"
                )
        );

        questions.add(
                new Question("Integer to Roman",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Medium"),
                                new Tag("company", "Paytm"),
                                new Tag("type", "online-test"),
                                new Tag("topic", "Maths")
                        )),
                        45,
                        "none"
                )
        );

        questions.add(
                new Question("Valid Parentheses",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Hard"),
                                new Tag("company", "Asus"),
                                new Tag("type", "online-test"),
                                new Tag("topic", "Stacks")
                        )),
                        21,
                        "none"
                )
        );

        questions.add(
                new Question("Implement strStr()",
                        new ArrayList<Tag>(Arrays.asList(
                                new Tag("difficulty", "Easy"),
                                new Tag("company", "IBM"),
                                new Tag("type", "personal-interview"),
                                new Tag("topic", "Strings")
                        )),
                        12,
                        "none"
                )
        );

    }
}