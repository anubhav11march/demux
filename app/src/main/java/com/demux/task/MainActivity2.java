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
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity implements updateTag, filter{

    Fragment fragment;
    ArrayList<Question> questions, allQuestions;
    LinearLayout fabFilter, sheetFragment;
    BottomSheetBehavior<LinearLayout> bottomSheetBehavior;
    BoomMenuButton boomMenuButton;
    ArrayList<String> selections = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        questions = new ArrayList<>();
        allQuestions = new ArrayList<>();
        populateList(questions);
        allQuestions = new ArrayList<>(questions);
        viewDefaultFragment(questions);
        fabFilter = findViewById(R.id.fab_filter);
        sheetFragment = findViewById(R.id.sheet_fragment);
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
                .normalImageRes(R.drawable.diff)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        Fragment fragment1 = new DifficultyChoices(selections, MainActivity2.this);
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.sheet_fragment, fragment1);
                        ft.commit();
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    }
                });
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

    void viewDefaultFragment(ArrayList<Question> qq){
        fragment = new QuestionsFragment(qq, new ArrayList<>(), this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_layout, fragment);
        ft.commit();
    }

    void startFiltering(){
        for(int i=0; i<questions.size() && selections.size()>0; i++){
            int f=0;
            for(int j=0; j<questions.get(i).tags.size(); j++){
                if(selections.contains(new String(questions.get(i).tags.get(j).getText()))){
                    f=1;
                    break;
                }
            }
            if(f==0) {
                questions.remove(i);
                i--;
            }
        }
        viewDefaultFragment(questions);
        questions = new ArrayList<>(allQuestions);
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

    @Override
    public void modifyFilter(ArrayList<String> tags, ArrayList<String> removals) {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        for(int i=0; i<tags.size(); i++){
            if(!selections.contains(tags.get(i)))
                selections.add(tags.get(i));
        }
        for(int i=0; i<removals.size(); i++)
            if(selections.contains(removals.get(i)))
                selections.remove(removals.get(i));

        startFiltering();
    }

    @Override
    public void filter() {
        startFiltering();
    }
}