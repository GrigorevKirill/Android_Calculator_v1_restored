package com.griga.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Vibrator vibrator;
    ListView listview;
    TextView text_input, text_input2;
    Button button_1, button_2, button_3, button_4,
            button_5, button_6, button_7, button_8,
            button_9, button_0, button_plus, button_minus,
            button_multiple, button_C, button_divide, button_point,
            button_equals, button_results, button_AC, button_left_bracket, button_right_bracket;

    String num;
    double sum;
    ArrayList<String> res_array = new ArrayList<>();
    ArrayList<String> num_array = new ArrayList<>();
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> result;
    NumberFormat nf = new DecimalFormat("#.######");




    private void result() {
       num = (String) text_input.getText();

       List<Lexeme> lexemes = lexAnalyze(num);
       LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);

       sum = expr(lexemeBuffer);
       text_input.setText("" + nf.format(sum));
       text_input2.setText(num);
       result = new HashMap<>();
       result.put("num", num + "=");
       result.put("res", String.valueOf(nf.format(sum)));
       arrayList.add(result);
       System.out.println(arrayList);

    }





    private void startNewActivity() {
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("res_array", res_array);
        intent.putExtra("num_array", num_array);
        intent.putExtra("array_list", arrayList);
        intent.putExtra("result", result);
        startActivity(intent);
    }

    private void getOutputHistory() {
        String s;
        s = getIntent().getStringExtra("result");
        System.out.println(s);
        if(s == null)
            text_input.setText("");
        else
            text_input.setText(s);
    }

    private void ACbutton() {
        String str = (String) text_input.getText();
        if(str.length() <= 0)
            button_AC.setText("AC");
        else
            button_AC.setText("C");
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        text_input = findViewById(R.id.text_input);
        text_input2 = findViewById(R.id.text_input2);
        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_C = findViewById(R.id.button_C);
        button_plus = findViewById(R.id.button_plus);
        button_minus = findViewById(R.id.button_minus);
        button_multiple = findViewById(R.id.button_multiple);
        button_divide = findViewById(R.id.button_divide);
        button_point = findViewById(R.id.button_point);
        button_equals = findViewById(R.id.button_equals);
        button_results = findViewById(R.id.button_results);
        button_AC = findViewById(R.id.button_AC);
        button_left_bracket = findViewById(R.id.button_left_bracket);
        button_right_bracket = findViewById(R.id.button_right_bracket);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_input.setText(text_input.getText() + "0");
                vibrator.vibrate(50);
                ACbutton();

            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_input.setText(text_input.getText() + "1");
                vibrator.vibrate(50);
                ACbutton();
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_input.setText(text_input.getText() + "2");
                vibrator.vibrate(50);
                ACbutton();
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_input.setText(text_input.getText() + "3");
                vibrator.vibrate(50);
                ACbutton();
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_input.setText(text_input.getText() + "4");
                vibrator.vibrate(50);
                ACbutton();
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_input.setText(text_input.getText() + "5");
                vibrator.vibrate(50);
                ACbutton();
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_input.setText(text_input.getText() + "6");
                vibrator.vibrate(50);
                ACbutton();
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_input.setText(text_input.getText() + "7");
                vibrator.vibrate(50);
                ACbutton();
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_input.setText(text_input.getText() + "8");
                vibrator.vibrate(50);
                ACbutton();
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_input.setText(text_input.getText() + "9");
                vibrator.vibrate(50);
                ACbutton();
            }
        });

        button_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_input.setText(text_input.getText() + ".");
                vibrator.vibrate(50);
                ACbutton();
            }
        });

        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(50);
                String str = (String) text_input.getText();
                if(str.length() <= 0) {
                    text_input.setText("");
                }else {
                    str = str.substring(0, str.length() - 1);
                    text_input.setText(str);
                }
                ACbutton();

            }
        });

        button_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(50);
                text_input.setText("");
                text_input2.setText("");
                ACbutton();
            }
        });

        button_right_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(50);
                text_input.setText(text_input.getText() + ")");
                ACbutton();
            }
        });

        button_left_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(50);
                text_input.setText(text_input.getText() + "(");
                ACbutton();
            }
        });

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(50);
                text_input.setText(text_input.getText() + "+");
                ACbutton();

            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(50);
                text_input.setText(text_input.getText() + "-");
                ACbutton();
            }
        });

        button_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(50);
                text_input.setText(text_input.getText() + "x");
                ACbutton();
            }
        });

        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_input.setText(text_input.getText() + "÷");
                ACbutton();
            }
        });

        button_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(50);
                result();
            }
        });

        getOutputHistory();
        ACbutton();





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.history) {
            startNewActivity();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("input", (String) text_input.getText());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        num = savedInstanceState.getString("input");
        text_input.setText(num);
    }

    public enum lexemeType {
        LEFT_BRACKET, RIGHT_BRACKET,
        OP_PLUS, OP_MINUS, OP_DIV, OP_MUL,
        NUMBER,
        EOS,
    }

    public static class Lexeme {
        lexemeType type;
        String value;

        public Lexeme(lexemeType type, String value) {
            this.type = type;
            this.value = value;
        }

        public Lexeme(lexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }


        @Override
        public String toString() {
            return "Lexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static class LexemeBuffer {
        private int pos;

        public List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }

        public int getPos() {
            return pos;
        }

    }

    public static List<Lexeme> lexAnalyze(String expText) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        while (pos < expText.length()) {
            char c = expText.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(lexemeType.LEFT_BRACKET, c));
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(lexemeType.RIGHT_BRACKET, c));
                    pos++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(lexemeType.OP_PLUS, c));
                    pos++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(lexemeType.OP_MINUS, c));
                    pos++;
                    continue;
                case 'x':
                    lexemes.add(new Lexeme(lexemeType.OP_MUL, c));
                    pos++;
                    continue;
                case '÷':
                    lexemes.add(new Lexeme(lexemeType.OP_DIV, c));
                    pos++;
                    continue;
                default:
                    if(c <= '9' && c >= '0' || c == '.') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if(pos >= expText.length()) {
                                break;
                            }
                            c = expText.charAt(pos);
                        } while (c <= '9' && c >= '0' || c == '.');
                        lexemes.add(new Lexeme(lexemeType.NUMBER, sb.toString()));
                        System.out.println(sb);
                    } else {
                        if(c != ' ' && c != '.') {
                            throw new RuntimeException("Unexpected character: " + c);
                        }
                        pos++;
                    }
            }

        }
        System.out.println(pos);
        lexemes.add(new Lexeme(lexemeType.EOS, ""));
        return lexemes;



        /*------------------------------------------------------------------
         * PARSER RULES
         *------------------------------------------------------------------*/

//    expr : plusminus* EOF ;
//
//    plusminus: multdiv ( ( '+' | '-' ) multdiv )* ;
//
//    multdiv : factor ( ( '*' | '/' ) factor )* ;
//
//    factor : NUMBER | '(' expr ')' ;







    }

    public static double expr(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if(lexeme.type == lexemeType.EOS) {
            return 0;
        } else {
            lexemes.back();
            return plusminus(lexemes);
        }


    }

    public static double plusminus(LexemeBuffer lexemes) {
        double value = multdiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_PLUS:
                    value += multdiv(lexemes);
                    break;
                case OP_MINUS:
                    value -= multdiv(lexemes);
                    break;
                case EOS:
                case RIGHT_BRACKET:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getPos());
            }
        }
    }

    public static double multdiv(LexemeBuffer lexemes) {
        double value = factor(lexemes);

        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_MUL:
                    value *= factor(lexemes);
                    break;
                case OP_DIV:
                    value /= factor(lexemes);
                    break;
                case EOS:
                case RIGHT_BRACKET:
                case OP_PLUS:
                case OP_MINUS:
                    lexemes.back();
                    return value;
                default: {
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getPos());
                }
            }

        }

    }

    public static double factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case NUMBER:
                return Double.parseDouble(lexeme.value);
            case LEFT_BRACKET:
                double value = expr(lexemes);
                lexeme = lexemes.next();

                if(lexeme.type != lexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getPos());
                }
                return value;

            default:
                throw new RuntimeException("Unexpected token: " + lexeme.value
                        + " at position: " + lexemes.getPos());

        }

    }


//    public void onSaveInstanceState(Bundle outState) {
//        outState.putString("name", String.valueOf(text_input.getText()));
//        super.onSaveInstanceState(outState);
//    }
//
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        String name;
//
//        name = savedInstanceState.getString("name");
//        text_input.setText(name);
//    }
}