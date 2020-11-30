package com.demux.task;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionsFragment extends Fragment {

    ArrayList<Question> questions;
    RecyclerView rv;
    Context context;
    boolean isScrolling  = false;
    int currentItems, totalitems, scrollOutItems;
    RecyclerViewAdapter rva;
    ProgressBar progressBar;

    QuestionsFragment(ArrayList<Question> questions, ArrayList<String> filters, Context context){
        this.questions = questions;
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questions, container, false);
        progressBar = view.findViewById(R.id.pbar);
        rv = view.findViewById(R.id.all_questions);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        inflateRecyclerView(llm);
        return view;
    }

    void inflateRecyclerView(LinearLayoutManager llm){
        rva = new RecyclerViewAdapter(questions, new ArrayList<>(), context);
        rv.setAdapter(rva);
        rv.setLayoutManager(llm);
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = llm.getChildCount();
                totalitems = llm.getItemCount();
                scrollOutItems = llm.findFirstVisibleItemPosition();

                if(isScrolling && (currentItems + scrollOutItems == totalitems)){
                    isScrolling = false;
                    fetchData();

                }
            }
        });
    }

    private void fetchData(){
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<Question> questions1 = new ArrayList<>();
                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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

                questions1.add(
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
                for(int i=0; i<8; i++){
                    questions.add(questions1.get(i));
                }
                rva.notifyDataSetChanged();
//                ((filter)context).filter();
                progressBar.setVisibility(View.GONE);
            }
        }, 3000);
    }



}
