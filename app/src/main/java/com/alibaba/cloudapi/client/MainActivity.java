/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.alibaba.cloudapi.client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.alibaba.cloudapi.client.R;
import com.alibaba.cloudapi.client.constant.Constants;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "client.cloudapi.alibaba.com.androidsdk.MESSAGE";
    public final static Thread worker = new Thread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendHttpGet(View view) {

        final Intent intent = new Intent(this, DisplayMessageActivity.class);

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                String getPath = "/weather/query";
//                Map<String , String> getPathParams = new HashMap<>();
//                getPathParams.put("userId" , "10000003");

                Map<String , String> getQueryParams = new HashMap<>();
                getQueryParams.put("city" , "anshun");
                getQueryParams.put("citycode" , "101260301");
                getQueryParams.put("cityid" , "111");

//                Map<String , String> getHeaderParams = new HashMap<>();
//                getHeaderParams.put("age" , "18");

                HttpUtil.getInstance().httpGet(getPath , null , getQueryParams , null , new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        intent.putExtra(EXTRA_MESSAGE , e.getMessage());
                        startActivity(intent);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        intent.putExtra(EXTRA_MESSAGE , getResultString(response));
                        startActivity(intent);


                    }
                });

            }
        };
        new Thread(runnable).start();
    }

    public void sendHttpPostForm(View view) {

        final Intent intent = new Intent(this, DisplayMessageActivity.class);

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                String getPath = "/testhttp/postform";

                Map<String , String> postQueryParams = new HashMap<>();
                postQueryParams.put("sex" , "男");

                Map<String , String> postHeaderParams = new HashMap<>();
                postHeaderParams.put("TestPostHeader" , "HTTP头");

                Map<String , String> postFormParams = new HashMap<>();
                postFormParams.put("TestAccount" , "FORM表单");


                HttpUtil.getInstance().httpPostForm(getPath , null , postQueryParams , postFormParams,  postHeaderParams , new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        intent.putExtra(EXTRA_MESSAGE , e.getMessage());
                        startActivity(intent);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        intent.putExtra(EXTRA_MESSAGE , getResultString(response));
                        startActivity(intent);


                    }
                });

            }
        };
        new Thread(runnable).start();
    }

    public void sendHttpPostBytes(View view) {

        final Intent intent = new Intent(this, DisplayMessageActivity.class);

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                String getPath = "/testhttp/postbyte";

                Map<String , String> getQueryParams = new HashMap<>();
                getQueryParams.put("QueryName" , "TestQueryNameVlaue");

                Map<String , String> getHeaderParams = new HashMap<>();
                getHeaderParams.put("TestPostHeader" , "HTTP头");

                String content =  "Hi there ,this is 一个 string";

                HttpUtil.getInstance().httpPostBytes(getPath , null , getQueryParams , content.getBytes(Constants.CLOUDAPI_ENCODING) , getHeaderParams , new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        intent.putExtra(EXTRA_MESSAGE , e.getMessage());
                        startActivity(intent);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        intent.putExtra(EXTRA_MESSAGE , getResultString(response));
                        startActivity(intent);
                    }
                });

            }
        };
        new Thread(runnable).start();
    }

    public void sendHttpPutBytes(View view) {

        final Intent intent = new Intent(this, DisplayMessageActivity.class);

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                String getPath = "/testhttp/putform";


                Map<String , String> getQueryParams = new HashMap<>();
                getQueryParams.put("QueryName" , "TestQueryNameVlaue");

                Map<String , String> getHeaderParams = new HashMap<>();
                getHeaderParams.put("TestPostHeader" , "TestPostHeaderValue");

                String content =  "Hi there ,this is 一个 string";

                HttpUtil.getInstance().httpPutBytes(getPath , null , getQueryParams  , content.getBytes(Constants.CLOUDAPI_ENCODING) , getHeaderParams , new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        intent.putExtra(EXTRA_MESSAGE , e.getMessage());
                        startActivity(intent);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        intent.putExtra(EXTRA_MESSAGE , getResultString(response));
                        startActivity(intent);


                    }
                });

            }
        };
        new Thread(runnable).start();
    }

    public void sendHttpDelete(View view) {

        final Intent intent = new Intent(this, DisplayMessageActivity.class);

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                String deletePath = "/testhttp/delete";

                Map<String , String> deleteQueryParams = new HashMap<>();
                deleteQueryParams.put("QueryName" , "TestQueryNameVlaue");

                Map<String , String> deleteHeaderParams = new HashMap<>();
                deleteHeaderParams.put("TestDelete" , "TestDeleteValue");

                HttpUtil.getInstance().httpDelete(deletePath , null , deleteQueryParams , deleteHeaderParams , new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        intent.putExtra(EXTRA_MESSAGE , e.getMessage());
                        startActivity(intent);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        intent.putExtra(EXTRA_MESSAGE , getResultString(response));
                        startActivity(intent);


                    }
                });

            }
        };
        new Thread(runnable).start();
    }


    private static String getResultString(Response response) throws IOException {
        StringBuilder result = new StringBuilder();
        result.append("【服务器返回结果为】").append(Constants.CLOUDAPI_LF).append(Constants.CLOUDAPI_LF);
        result.append("ResultCode:").append(Constants.CLOUDAPI_LF).append(response.code()).append(Constants.CLOUDAPI_LF).append(Constants.CLOUDAPI_LF);
        if(response.code() != 200){
            result.append("错误原因：").append(response.header("X-Ca-Error-Message")).append(Constants.CLOUDAPI_LF).append(Constants.CLOUDAPI_LF);
        }

        result.append("ResultBody:").append(Constants.CLOUDAPI_LF).append(new String(response.body().bytes() , Constants.CLOUDAPI_ENCODING));

        return result.toString();
    }
}
