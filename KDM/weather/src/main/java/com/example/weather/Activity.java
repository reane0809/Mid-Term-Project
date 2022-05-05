package com.example.weather;

import android.os.Bundle;
import java.io.InputStreamReader;
import androidx.appcompat.app.AppCompatActivity;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class Activity extends AppCompatActivity {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtNcst"); /*URL*/
        urlBuilder.append("?" + "ServiceKey" + "=jTnzyCPieEVWSxqtlgHjvk37q3aHGkttzcMNDxADJCB7aLPPjhexcI0EIgl%2BMNU1PBFXdkrjpPh79VwopMs7EA%3D%3D&"); /*Service Key*/
        urlBuilder.append("&" + "ServiceKey" + "=" + "-"); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + "pageNo" + "=" + "1"); /*페이지번호*/
        urlBuilder.append("&" + "numOfRows" + "=" + "10"); /*한 페이지 결과 수*/
        urlBuilder.append("&" + "dataType" + "=" + "XML"); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + "base_date" + "=" + "20151201"); /*15년 12월 1일발표*/
        urlBuilder.append("&" + "base_time" + "=" + "0500"); /*05시 발표*/
        urlBuilder.append("&" + "nx" + "=" + "1"); /*예보지점 X 좌표값*/
        urlBuilder.append("&" + "ny" + "=" + "1"); /*예보지점의 Y 좌표값*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}

