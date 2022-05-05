package com.example.k_dm;


import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Context;

public class subwayA extends Activity {
    private static final String TAG = "bluetooth1";
    ArrayAdapter<CharSequence> adspin5, adspin6, adspin7; //어댑터를 선언했습니다. adspint1(서울,인천..) adspin2(강남구,강서구..)
    String hosun = "";
    String yeok = "";
    String hang = "";
    ArrayAdapter<String> adapterZ;
    Context cont;
    public static Context Context1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train);
        Context1 = this;
        final Spinner spin5 = (Spinner) findViewById(R.id.spinnerG);
        final Spinner spin6 = (Spinner) findViewById(R.id.spinnerG2);
        final Spinner spin7 = (Spinner) findViewById(R.id.spinnerG3);


        Button btn_refresh = (Button) findViewById(R.id.btn_refresh);
        Button btn_refresh2 = (Button) findViewById(R.id.btn_refresh2);//xml과 class에 변수들을 연결해줍니다. final를 사용한 이유는 spin2가 함수안에서 사용되기 때문에 코딩전체로 선언한 것입니다.
        Button btn_refresh3 = (Button) findViewById(R.id.btn_refresh3);
        Button btn_refresh44 = (Button) findViewById(R.id.btn_refresh54);
        Button btn_refresh55 = (Button) findViewById(R.id.btn_refresh55);

        adspin5 = ArrayAdapter.createFromResource(this, R.array.train, android.R.layout.simple_spinner_dropdown_item);//처번째 어댑터에 값을 넣습니다. this=는 현재class를 의미합니다. R.array.spinner_do는 이곳에 도시를 다 쓸 경우 코딩이 길어지기 때문에 value->string.xml에 따로 String값들을 선언해두었습니다. //R.layout.simple_~~~는 안드로이드에서 기본제공하는 spinner 모양입니다. 다른것도 있는데 비슷합니다.

        adspin5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//이부분이 정확히 말로 설명을 못하겠습니다. 아무튼 필요합니다. 헤헤 고수분들 도와주세요.
        spin5.setAdapter(adspin5);

//어댑터에 값들을 spinner에 넣습니다. 여기까지 하시면 첫번째 spinner에 값들이 들어갈 것입니다.

        spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adspin5.getItem(i).equals("1호선")) {
                    hosun = "1호선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_1, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("2호선")) {
                    hosun = "2호선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_2, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }

                ////////여기부터 3호선 쭈욱
                else if (adspin5.getItem(i).equals("3호선")) {
                    hosun = "3호선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_3, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("4호선")) {
                    hosun = "4호선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_4, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("5호선")) {
                    hosun = "5호선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_5, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("6호선")) {
                    hosun = "6호선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_6, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("7호선")) {
                    hosun = "7호선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_7, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("8호선")) {
                    hosun = "8호선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_8, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("9호선")) {
                    hosun = "9호선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_9, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("분당선")) {
                    hosun = "분당선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_b, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("신분당선")) {
                    hosun = "신분당선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_sb, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("경의선")) {
                    hosun = "경의선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_g, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin5.getItem(i).equals("중앙선")) {
                    hosun = "중앙선";
                    adspin6 = ArrayAdapter.createFromResource(subwayA.this, R.array.train_j, android.R.layout.simple_spinner_dropdown_item);
                    adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin6.setAdapter(adspin6);
                    spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            yeok = adspin6.getItem(i).toString();
                            adspin7 = ArrayAdapter.createFromResource(subwayA.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
                            adspin7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spin7.setAdapter(adspin7);
                            spin7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    hang = adspin7.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn_refresh3.setOnClickListener(new View.OnClickListener() {//버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                Toast.makeText(subwayA.this, "저장되었습니다", Toast.LENGTH_SHORT).show();
                ((MainActivity) MainActivity.Context).textS.setText(yeok);
                shared.setString(((MainActivity) MainActivity.Context).Context, "yeok", ((MainActivity) MainActivity.Context).yeok);
                shared.setString(((MainActivity) MainActivity.Context).Context, "hang", ((MainActivity) MainActivity.Context).hang);
                ((MainActivity) MainActivity.Context).yeok = yeok;
                ((MainActivity) MainActivity.Context).hang = hang;
                ((MainActivity) MainActivity.Context).textS.setText(((MainActivity) MainActivity.Context).yeok + "역 ");

            }
        });


    }
}
