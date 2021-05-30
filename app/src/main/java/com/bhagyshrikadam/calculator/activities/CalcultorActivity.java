package com.bhagyshrikadam.calculator.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bhagyshrikadam.calculator.MainActivity;
import com.bhagyshrikadam.calculator.R;
import com.bhagyshrikadam.calculator.adapters.ListViewAdapter;
import com.bhagyshrikadam.calculator.classes.MySharedPreference;
import com.bhagyshrikadam.calculator.models.History;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CalcultorActivity extends AppCompatActivity {
     Button b1, b2, b3, bmul, b5,btn_history;

     Button b6, b7, bsub, b9, b4, b8, badd, bdiv, bdec, b0, beql;
     TextView edt1,edt2,txt_backtocalculator;

     ViewGroup listViewLayout,input_calculator;
    private ListView listHistory;
    private ArrayList<History> history;
    private MySharedPreference sharedPreference;
    private Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcultor);

        gson = new Gson();
        sharedPreference = new MySharedPreference(getApplicationContext());
        getHistoryListFromSharedPreference();

        listViewLayout = findViewById(R.id.layout_listview);
        input_calculator = findViewById(R.id.ll_calculator);
        listHistory = findViewById(R.id.list);
        btn_history = findViewById(R.id.btn_history);
        txt_backtocalculator = findViewById(R.id.txt_backtocal);

        edt1 = findViewById(R.id.ed1);
        edt2 = findViewById(R.id.ed2);
        b7 = findViewById(R.id.but1);
        b8 = findViewById(R.id.but2);
        b9 = findViewById(R.id.but3);
        bmul = findViewById(R.id.but4);
        b4 = findViewById(R.id.but5);
        b5 = findViewById(R.id.but6);
        b6 = findViewById(R.id.but7);
        bsub = findViewById(R.id.but8);
        b1 = findViewById(R.id.but9);
        b2 = findViewById(R.id.but10);
        b3 = findViewById(R.id.but11);
        badd = findViewById(R.id.but12);
        bdiv = findViewById(R.id.but13);
        b0 = findViewById(R.id.but14);
        bdec = findViewById(R.id.but15);
        beql = findViewById(R.id.but_equal);


        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt2.setText(edt2.getText() + "1");
                                  }
                              }
        );
        b2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt2.setText(edt2.getText() + "2");
                                  }
                              }
        );
        b3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt2.setText(edt2.getText() + "3");
                                  }
                              }
        );
        b4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt2.setText(edt2.getText() + "4");
                                  }
                              }
        );
        b5.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt2.setText(edt2.getText() + "5");
                                  }
                              }
        );
        b6.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt2.setText(edt2.getText() + "6");
                                  }
                              }
        );
        b7.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt2.setText(edt2.getText() + "7");
                                  }
                              }
        );
        b8.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt2.setText(edt2.getText() + "8");
                                  }
                              }
        );
        b9.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt2.setText(edt2.getText() + "9");
                                  }
                              }
        );
        bmul.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        edt2.setText(edt2.getText() + "X");
                                    }
                                }
        );
        badd.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s1 = edt2.getText().toString();

                                        edt2.setText(edt2.getText() + "+");
                                    }
                                }

        );
        bsub.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        edt2.setText(edt2.getText() + "-");
                                    }
                                }
        );
        bdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String display = edt2.getText().toString();
                String displayy = edt1.getText().toString();

                if (!TextUtils.isEmpty(display) ) {
                    display = display.substring(0, display.length() - 1);

                    edt2.setText(display);
                }
                if(!TextUtils.isEmpty(displayy))
                {
                    displayy = displayy.substring(0, displayy.length() - 1);
                    edt1.setText(displayy);


                }

            }


        });
        b0.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt2.setText(edt2.getText() + "0");
                                  }
                              }
        );
        bdiv.setOnClickListener(new View.OnClickListener() {


                                    public void onClick(View view) {

                                        edt2.setText(edt2.getText() + "/");
                                    }
                                }
        );

        beql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                listViewLayout.setVisibility(View.GONE);
//                input_calculator.setVisibility(View.VISIBLE);
                int b;
                //boolean b;
                String str = edt2.getText().toString();
                if (str.contains("..") || str.contains("++") || str.contains("--") || str.contains("**") || str.contains("//") || str.contains("+-") || str.contains("*-") || str.contains("/-") || str.contains("/+") || str.contains("/*") || str.contains("+++")) {
                    Toast.makeText(getApplicationContext(), "Invalid Expression", Toast.LENGTH_LONG).show();
                } else  {

                    double p1 = bodmas(str);
                    String p = Double.toString(p1);
                    edt1.setText(p);

                    //not null input
                    History hi_story = new History();
                    hi_story.setResult(edt2.getText().toString());
                    hi_story.setCalculation(edt1.getText().toString());
                    history.add(hi_story); //add to scores list
                    saveHistoryListToSharedpreference(history); //save to share pref

                }



            }


        });
        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_history.setVisibility(View.GONE);
                txt_backtocalculator.setVisibility(View.VISIBLE);
                if (history.size() == 0) {
                    btn_history.setVisibility(View.VISIBLE);
                    txt_backtocalculator.setVisibility(View.GONE);

                    Toast.makeText(CalcultorActivity.this, "History not available", Toast.LENGTH_SHORT).show();
                } else {
                    getHistoryListFromSharedPreference(); //get data
                    //set adapter for listview and visible it
                    ListViewAdapter adapter = new ListViewAdapter(CalcultorActivity.this, R.layout.item_listview, history);
                    listHistory.setAdapter(adapter);
                    Collections.reverse(history); // ADD THIS LINE TO REVERSE ORDER!

                    listViewLayout.setVisibility(View.VISIBLE);
                    input_calculator.setVisibility(View.GONE);

                }
                txt_backtocalculator.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        input_calculator.setVisibility(View.VISIBLE);
                        listViewLayout.setVisibility(View.GONE);
                        btn_history.setVisibility(View.VISIBLE);
                        txt_backtocalculator.setVisibility(View.GONE);
                    }
                });
            }
        });
    }

    //bodmas
    static double bodmas(String equation) {
        double result = 0.0;
        String noMinus = equation.replace("-", "+-");
        String[] byPluses = noMinus.split("\\+");//split by addition

        for (String multipl : byPluses) {
            String[] byMultipl = multipl.split("X");//split by multiplication
            double multiplResult = 1.0;
            for (String operand : byMultipl) {
                if (operand.contains("/")) {
                    String[] division = operand.split("\\/");//split by division
                    double divident = Double.parseDouble(division[0]);//division
                    for (int i = 1; i < division.length; i++) {
                        divident /= Double.parseDouble(division[i]);
                    }
                    multiplResult *= divident;//multiplication ke result me 1 1 karke multiply hoga
                } else {
                    multiplResult *= Double.parseDouble(operand);
                }
            }
            result += multiplResult;
        }

        return result;
    }

    /**
     * Save list of history to own sharedpref
     */
    private void saveHistoryListToSharedpreference(ArrayList<History> historyList) {
        //convert ArrayList object to String by Gson
        String jsonScore = gson.toJson(historyList);

        //save to shared preference
        sharedPreference.saveHighScoreList(jsonScore);
    }
    /**
     * Retrieving data from sharepref
     */
    private void getHistoryListFromSharedPreference() {
        //retrieve data from shared preference
        String jsonScore = sharedPreference.getHighScoreList();
        Type type = new TypeToken<List<History>>(){}.getType();
        history = gson.fromJson(jsonScore, type);

        if (history == null) {
            history = new ArrayList<>( );
        }
    }

    @Override
    public void onBackPressed() {


        androidx.appcompat.app.AlertDialog.Builder alertDialog = new androidx.appcompat.app.AlertDialog.Builder(CalcultorActivity.this);
        alertDialog.setTitle("Exit");
        alertDialog.setMessage("You want to exit ?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
                finish();
            }
        });
        alertDialog.setNegativeButton(android.R.string.no, null);


        androidx.appcompat.app.AlertDialog dialog = alertDialog.create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
    }
}