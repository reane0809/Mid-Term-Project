package com.example.k_dm;


import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.UUID;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.AlarmManager;

import android.app.AlertDialog;

import android.app.PendingIntent;

import android.content.Context;
import java.util.Calendar;

public class setting extends Activity {
    private static final String TAG = "bluetooth1";
    ArrayAdapter<CharSequence> adspin1, adspin2, adspin3, adspin4, adspin5, adspin6, adspin7; //어댑터를 선언했습니다. adspint1(서울,인천..) adspin2(강남구,강서구..)
    String choice_do = "";
    String choice_se = "";//
    String hosun = "";
    String yeok = "";
    String hang = "";
    ArrayAdapter<String> adapterZ;
    Calendar calendar;
    Context cont;
    public static Context Context1;

    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private OutputStream outStream = null;

    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    // MAC-address of Bluetooth module (you must edit this line)
    private static String address = "00:19:12:BC:65:41";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.settings_preference);
            Context1=this;
            final Spinner spin1 = (Spinner) findViewById(R.id.spinner);
            final Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
            final Spinner spin3 = (Spinner) findViewById(R.id.spinner1);
            final Spinner spin4 = (Spinner) findViewById(R.id.spinner21);
            final Spinner spin5 = (Spinner) findViewById(R.id.spinnerG);
            final Spinner spin6 = (Spinner) findViewById(R.id.spinnerG2);
            final Spinner spin7 = (Spinner) findViewById(R.id.spinnerG3);

            final TimePicker mTimePicker;

            btAdapter = BluetoothAdapter.getDefaultAdapter();
            checkBTState();
            mTimePicker = (TimePicker) findViewById(R.id.TimePicker);
            mTimePicker.setIs24HourView(false);

            Button btn_refresh = (Button) findViewById(R.id.btn_refresh);
            Button btn_refresh2 = (Button) findViewById(R.id.btn_refresh2);//xml과 class에 변수들을 연결해줍니다. final를 사용한 이유는 spin2가 함수안에서 사용되기 때문에 코딩전체로 선언한 것입니다.
            Button btn_refresh3 = (Button) findViewById(R.id.btn_refresh3);
            Button btn_refresh44 = (Button) findViewById(R.id.btn_refresh54);
            Button btn_refresh55 = (Button) findViewById(R.id.btn_refresh55);
            adspin1 = ArrayAdapter.createFromResource(this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item);
            adspin3 = ArrayAdapter.createFromResource(this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item);
            adspin5 = ArrayAdapter.createFromResource(this, R.array.train, android.R.layout.simple_spinner_dropdown_item);//처번째 어댑터에 값을 넣습니다. this=는 현재class를 의미합니다. R.array.spinner_do는 이곳에 도시를 다 쓸 경우 코딩이 길어지기 때문에 value->string.xml에 따로 String값들을 선언해두었습니다. //R.layout.simple_~~~는 안드로이드에서 기본제공하는 spinner 모양입니다. 다른것도 있는데 비슷합니다.
            adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//이부분이 정확히 말로 설명을 못하겠습니다. 아무튼 필요합니다. 헤헤 고수분들 도와주세요.
            spin1.setAdapter(adspin1);
            adspin3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//이부분이 정확히 말로 설명을 못하겠습니다. 아무튼 필요합니다. 헤헤 고수분들 도와주세요.
            spin3.setAdapter(adspin3);
            adspin5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//이부분이 정확히 말로 설명을 못하겠습니다. 아무튼 필요합니다. 헤헤 고수분들 도와주세요.
            spin5.setAdapter(adspin5);

//어댑터에 값들을 spinner에 넣습니다. 여기까지 하시면 첫번째 spinner에 값들이 들어갈 것입니다.
            spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//첫번째 spinner 클릭시 이벤트 발생입니다. setO 정도까지 치시면 자동완성됩니다. 뒤에도 마찬가지입니다.
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {//제대로 자동완성하셨다면 이부분이 자동으로 만들어 질 것입니다. int i는 포지션이라 하여 제가 spinner에 몇번째걸 선택했는지 값이 들어갑니다. 필요하겠죠? ㅎㅎ
                    if (adspin1.getItem(i).equals("서울특별시")) {//spinner에 값을 가져와서 i 보이시나요 제가 클릭 한것이 서울인지 확인합니다.
                        choice_do = "서울특별시";//버튼 클릭시 출력을 위해 값을 넣었습니다.
                        adspin2 = ArrayAdapter.createFromResource(setting.this, R.array.spinner_do_seoul, android.R.layout.simple_spinner_dropdown_item);//서울일 경우에 두번째 spinner에 값을 넣습니다. //그냥 this가 아닌 Main~~~인 이유는 그냥 this는 메인엑티비티인 경우만 가능합니다. //지금과 같이 다른 함수안이나 다른 클래스에서는 꼭 자신의 것을 넣어주어야 합니다.//혹시나 다른 class -> Public View밑에서 작업하시는 분은 view명.getContext()로 해주셔야 합니다.//예로 View rootView =~~ 선언하신 경우에는 rootView.getContext()써주셔야합니다. this가 아니라요.
                        adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin2.setAdapter(adspin2);//두번째 어댑터값을 두번째 spinner에 넣었습니다.
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//저희는 두번째 선택된 값도 필요하니 이안에 두번째 spinner 선택 이벤트를 정의합니다.
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                choice_se = adspin2.getItem(i).toString();//두번째 선택된 값을 choice_se에 넣습니다.
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {//아무것도 선택안될시 부분입니다. 자동완성됩니다.
                            }
                        });
                    } else if (adspin1.getItem(i).equals("인천광역시")) {//똑같은 소스에 반복입니다. 인천부분입니다.
                        choice_do = "인천광역시";
                        adspin2 = ArrayAdapter.createFromResource(setting.this, R.array.spinner_do_incheon, android.R.layout.simple_spinner_dropdown_item);
                        adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin2.setAdapter(adspin2);
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                choice_se = adspin2.getItem(i).toString();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {
                            }
                        });
                    } else if (adspin1.getItem(i).equals("경기도")) {//똑같은 소스에 반복입니다. 인천부분입니다.
                        choice_do = "경기도";
                        adspin2 = ArrayAdapter.createFromResource(setting.this, R.array.spinner_do_gg, android.R.layout.simple_spinner_dropdown_item);
                        adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin2.setAdapter(adspin2);
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                choice_se = adspin2.getItem(i).toString();
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
            btn_refresh.setOnClickListener(new View.OnClickListener() {//버튼 클릭시 이벤트입니다.
                @Override
                public void onClick(View view) {
                    Toast.makeText(setting.this, "저장되었습니다", Toast.LENGTH_SHORT).show();
                    ((MainActivity) MainActivity.Context).homesi = choice_do;
                    shared.setString(MainActivity.Context, "homesi", choice_do);
                    ((MainActivity) MainActivity.Context).homegun = choice_se;
                    shared.setString(MainActivity.Context, "homegun", choice_se);
                }
            });


            spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//첫번째 spinner 클릭시 이벤트 발생입니다. setO 정도까지 치시면 자동완성됩니다. 뒤에도 마찬가지입니다.
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {//제대로 자동완성하셨다면 이부분이 자동으로 만들어 질 것입니다. int i는 포지션이라 하여 제가 spinner에 몇번째걸 선택했는지 값이 들어갑니다. 필요하겠죠? ㅎㅎ
                    if (adspin3.getItem(i).equals("서울특별시")) {//spinner에 값을 가져와서 i 보이시나요 제가 클릭 한것이 서울인지 확인합니다.
                        choice_do = "서울특별시";//버튼 클릭시 출력을 위해 값을 넣었습니다.
                        adspin4 = ArrayAdapter.createFromResource(setting.this, R.array.spinner_do_seoul, android.R.layout.simple_spinner_dropdown_item);//서울일 경우에 두번째 spinner에 값을 넣습니다. //그냥 this가 아닌 Main~~~인 이유는 그냥 this는 메인엑티비티인 경우만 가능합니다. //지금과 같이 다른 함수안이나 다른 클래스에서는 꼭 자신의 것을 넣어주어야 합니다.//혹시나 다른 class -> Public View밑에서 작업하시는 분은 view명.getContext()로 해주셔야 합니다.//예로 View rootView =~~ 선언하신 경우에는 rootView.getContext()써주셔야합니다. this가 아니라요.
                        adspin4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin4.setAdapter(adspin4);//두번째 어댑터값을 두번째 spinner에 넣었습니다.
                        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//저희는 두번째 선택된 값도 필요하니 이안에 두번째 spinner 선택 이벤트를 정의합니다.
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                choice_se = adspin4.getItem(i).toString();//두번째 선택된 값을 choice_se에 넣습니다.
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {//아무것도 선택안될시 부분입니다. 자동완성됩니다.
                            }
                        });
                    } else if (adspin3.getItem(i).equals("인천광역시")) {//똑같은 소스에 반복입니다. 인천부분입니다.
                        choice_do = "인천광역시";
                        adspin4 = ArrayAdapter.createFromResource(setting.this, R.array.spinner_do_incheon, android.R.layout.simple_spinner_dropdown_item);
                        adspin4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin4.setAdapter(adspin4);
                        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                choice_se = adspin4.getItem(i).toString();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {
                            }
                        });
                    } else if (adspin3.getItem(i).equals("경기도")) {//똑같은 소스에 반복입니다. 인천부분입니다.
                        choice_do = "경기도";
                        adspin4 = ArrayAdapter.createFromResource(setting.this, R.array.spinner_do_gg, android.R.layout.simple_spinner_dropdown_item);
                        adspin4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin4.setAdapter(adspin4);
                        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                choice_se = adspin4.getItem(i).toString();
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
            btn_refresh2.setOnClickListener(new View.OnClickListener() {//버튼 클릭시 이벤트입니다.
                @Override
                public void onClick(View view) {

                    Toast.makeText(setting.this, "저장되었습니다", Toast.LENGTH_SHORT).show();
                    ((MainActivity) MainActivity.Context).compsi = choice_do;
                    System.out.println(choice_do + choice_se);
                    ((MainActivity) MainActivity.Context).compgun = choice_se;
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            long now = System.currentTimeMillis();
                            Date date = new Date(now);
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                            final String getTime = sdf.format(date);
                            ((MainActivity) MainActivity.Context).data = ((MainActivity) MainActivity.Context).getXmlData(((MainActivity) MainActivity.Context).compgun, getTime);//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기

                            //UI Thread(Main Thread)를 제외한 어떤 Thread도 화면을 변경할 수 없기때문에
                            //runOnUiThread()를 이용하여 UI Thread가 TextView 글씨 변경하도록 함
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                }
                            });
                        }

                    }).start();

                }

            });

            /////////////////////////////
            ////////////////////////////
            ////////////////////////////
            ////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////
            ////////////////////////////
            ////////////////////////////
            ////////////////////////////
            ////////////////////////////


            spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if (adspin5.getItem(i).equals("1호선")) {
                        hosun = "1호선";
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_1, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_2, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_3, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_4, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_5, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_6, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_7, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_8, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_9, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_b, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_sb, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_g, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                        adspin6 = ArrayAdapter.createFromResource(setting.this, R.array.train_j, android.R.layout.simple_spinner_dropdown_item);
                        adspin6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin6.setAdapter(adspin6);
                        spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                yeok = adspin6.getItem(i).toString();
                                adspin7 = ArrayAdapter.createFromResource(setting.this, R.array.sh, android.R.layout.simple_spinner_dropdown_item);
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
                    Toast.makeText(setting.this, "저장되었습니다", Toast.LENGTH_SHORT).show();
                    ((MainActivity) MainActivity.Context).textS.setText(yeok);
                    shared.setString(((MainActivity) MainActivity.Context).Context, "yeok", ((MainActivity) MainActivity.Context).yeok);
                    shared.setString(((MainActivity) MainActivity.Context).Context, "hang", ((MainActivity) MainActivity.Context).hang);
                    ((MainActivity) MainActivity.Context).yeok = yeok;
                    ((MainActivity) MainActivity.Context).hang = hang;
                    ((MainActivity) MainActivity.Context).textS.setText(((MainActivity) MainActivity.Context).yeok + "역 ");

                }
            });


            ////////////알람@@@@@@@@@@@@@@@@@@@@@@@@@@@////////////////////////////////
        btn_refresh44.setOnClickListener(new View.OnClickListener() {//버튼 클릭시 이벤트입니다.
            int h;
            int m;
            @Override
            public void onClick(View view) {
                h=mTimePicker.getCurrentHour();
                m=mTimePicker.getCurrentMinute();
                String to = Integer.toString(h);
                String tom = Integer.toString(m);




                mTimePicker.getCurrentMinute();
                shared.setString( ((MainActivity) MainActivity.Context).Context, "hour", to);
                ((MainActivity) MainActivity.Context).hou=to;
                shared.setString( ((MainActivity) MainActivity.Context).Context, "min", tom);
                ((MainActivity) MainActivity.Context).minu=tom;

            }
        });

        btn_refresh55.setOnClickListener(new View.OnClickListener() {//버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                sendData("8");
                Toast.makeText(getBaseContext(), "알람ON", Toast.LENGTH_SHORT).show();

            }
        });



    }

    public void onBackPressed() {
        super.onBackPressed();
        //((MainActivity) MainActivity.Context).textW.setText(((MainActivity) MainActivity.Context).compsi + ((MainActivity) MainActivity.Context).compgun);
        ((MainActivity) MainActivity.Context).textH.setText(((MainActivity) MainActivity.Context).compsi + " " + ((MainActivity) MainActivity.Context).compgun);
        shared.setString(((MainActivity) MainActivity.Context).Context, "compsi", ((MainActivity) MainActivity.Context).compsi);
        shared.setString(((MainActivity) MainActivity.Context).Context, "compgun", ((MainActivity) MainActivity.Context).compgun);
        shared.setString(((MainActivity) MainActivity.Context).Context, "yeok", ((MainActivity) MainActivity.Context).yeok);
        char[] picdata = ((MainActivity) MainActivity.Context).wp(((MainActivity) MainActivity.Context).data);
        System.out.println(((MainActivity) MainActivity.Context).data);
        if (picdata[0] == 's') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.sunny);
        } else if (picdata[0] == 'r') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.rain);
        } else if (picdata[0] == 'd') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.cloud);
        } else if (picdata[0] == 'n') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.snow);
        } else if (picdata[0] == 'c') {
            ((MainActivity) MainActivity.Context).am9.setImageResource(R.drawable.littlecloud);
        } else ;

        if (picdata[1] == 's') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.sunny);
        } else if (picdata[1] == 'r') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.rain);
        } else if (picdata[1] == 'd') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.cloud);
        } else if (picdata[1] == 'n') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.snow);
        } else if (picdata[1] == 'c') {
            ((MainActivity) MainActivity.Context).pm12.setImageResource(R.drawable.littlecloud);
        } else ;

        if (picdata[2] == 's') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.sunny);
        } else if (picdata[2] == 'r') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.rain);
        } else if (picdata[2] == 'd') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.cloud);
        } else if (picdata[2] == 'n') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.snow);
        } else if (picdata[2] == 'c') {
            ((MainActivity) MainActivity.Context).pm18.setImageResource(R.drawable.littlecloud);
        } else ;


    }

    private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {
        if(Build.VERSION.SDK_INT >= 10){
            try {
                final Method  m = device.getClass().getMethod("createInsecureRfcommSocketToServiceRecord", new Class[] { UUID.class });
                return (BluetoothSocket) m.invoke(device, MY_UUID);
            } catch (Exception e) {
                Log.e(TAG, "Could not create Insecure RFComm Connection",e);
            }
        }
        return  device.createRfcommSocketToServiceRecord(MY_UUID);
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(TAG, "...onResume - try connect...");

        // Set up a pointer to the remote node using it's address.
        BluetoothDevice device = btAdapter.getRemoteDevice(address);

        // Two things are needed to make a connection:
        //   A MAC address, which we got above.
        //   A Service ID or UUID.  In this case we are using the
        //     UUID for SPP.

        try {
            btSocket = createBluetoothSocket(device);
        } catch (IOException e1) {
            errorExit("Fatal Error", "In onResume() and socket create failed: " + e1.getMessage() + ".");
        }

        // Discovery is resource intensive.  Make sure it isn't going on
        // when you attempt to connect and pass your message.
        btAdapter.cancelDiscovery();

        // Establish the connection.  This will block until it connects.
        Log.d(TAG, "...Connecting...");
        try {
            btSocket.connect();
            Log.d(TAG, "...Connection ok...");
        } catch (IOException e) {
            try {
                btSocket.close();
            } catch (IOException e2) {
                errorExit("Fatal Error", "In onResume() and unable to close socket during connection failure" + e2.getMessage() + ".");
            }
        }

        // Create a data stream so we can talk to server.
        Log.d(TAG, "...Create Socket...");

        try {
            outStream = btSocket.getOutputStream();
        } catch (IOException e) {
            errorExit("Fatal Error", "In onResume() and output stream creation failed:" + e.getMessage() + ".");
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(TAG, "...In onPause()...");

        if (outStream != null) {
            try {
                outStream.flush();
            } catch (IOException e) {
                errorExit("Fatal Error", "In onPause() and failed to flush output stream: " + e.getMessage() + ".");
            }
        }

        try     {
            btSocket.close();
        } catch (IOException e2) {
            errorExit("Fatal Error", "In onPause() and failed to close socket." + e2.getMessage() + ".");
        }
    }

    private void checkBTState() {
        // Check for Bluetooth support and then check to make sure it is turned on
        // Emulator doesn't support Bluetooth and will return null
        if(btAdapter==null) {
            errorExit("Fatal Error", "Bluetooth not support");
        } else {
            if (btAdapter.isEnabled()) {
                Log.d(TAG, "...Bluetooth ON...");
            } else {
                //Prompt user to turn on Bluetooth
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        }
    }

    private void errorExit(String title, String message){
        Toast.makeText(getBaseContext(), title + " - " + message, Toast.LENGTH_LONG).show();
        finish();
    }

    void sendData(String message) {
        System.out.println("받았다!!!!!!!!!!!!!!!");
        byte[] msgBuffer = message.getBytes();

        Log.d(TAG, "...Send data: " + message + "...");

        try {
            outStream.write(msgBuffer);
        } catch (IOException e) {
            String msg = "In onResume() and an exception occurred during write: " + e.getMessage();
            if (address.equals("00:00:00:00:00:00"));
                msg = msg + ".\n\nUpdate your server address from 00:00:00:00:00:00 to the correct address on line 35 in the java code";
            msg = msg +  ".\n\nCheck that the SPP UUID: " + MY_UUID.toString() + " exists on server.\n\n";

            errorExit("Fatal Error", msg);
        }
    }

    public class AlarmReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intentAlarm){
            sendData("8");
        }
    }


}

