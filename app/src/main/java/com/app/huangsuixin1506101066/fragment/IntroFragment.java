package com.app.huangsuixin1506101066.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.huangsuixin1506101066.App;
import com.app.huangsuixin1506101066.R;
import com.app.huangsuixin1506101066.activity.NewsContentView;
import com.app.huangsuixin1506101066.adapter.NewsAdapter;
import com.app.huangsuixin1506101066.bean.NewsInfo;
import com.app.huangsuixin1506101066.bean.ResponseBean;
import com.app.huangsuixin1506101066.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.show.api.ShowApiRequest;


import java.util.List;

import okhttp3.Call;
import okhttp3.Response;



/**
 * @author Silence
 */
public class IntroFragment extends Fragment {

    private ResponseBean bean;
    private RecyclerView rv;

    private String newsType;

    private Intent intent;
    App app;

    protected Handler mHandler =  new Handler();

    public IntroFragment(String newsType) {
        this.newsType = newsType;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_intro, container, false);
        rv = v.findViewById(R.id.rv);
        app = (App) getActivity().getApplication();
        intent = new Intent(getContext(), NewsContentView.class);
        initRV(null);
//        getData();
        int page = (int) (Math.random()*20 + 1);
        getData("1", "20");
        return v;

    }

    /**
     * 从网络获取数据
     */
    private void getData() {

        String url = "http://www.mfcsjk.com/post?id=504";


        OkGo.get(url)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //s代表的是我返回的json数据

                        try {
                            bean = new Gson().fromJson(s, ResponseBean.class);
                        } catch (Exception e) {

                        } finally {

                        }

                        // 拿到数据成功过后对recycleview的初始化
                        if (bean != null && bean.getShowapi_res_body() != null && bean.getShowapi_res_body().getPagebean() != null
                                && bean.getShowapi_res_body().getPagebean().getContentlist() != null
                                ) {
                            initRV(bean.getShowapi_res_body().getPagebean().getContentlist());
                        } else {
                            Toast.makeText(getContext(), "请求数据失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    private void getData(final String page, final String size){
        String url = "http://route.showapi.com/109-35";
        final String appid="52941";//要替换成自己的
        final String secret="b2f4d7f126af4882a1d3f812efaa7e63";//要替换成自己的

        new Thread(){
            //在新线程中发送网络请求
            @Override
            public void run() {
                final String res=new ShowApiRequest( "http://route.showapi.com/109-35", appid, secret)
                        .addTextPara("channelId", "")
                        .addTextPara("channelName", newsType)
                        .addTextPara("title", "")
                        .addTextPara("page", page)
                        .addTextPara("needContent", "1")
                        .addTextPara("needHtml", "")
                        .addTextPara("needAllList", "")
                        .addTextPara("maxResult", size)
                        .addTextPara("id", "")
                        .post();

                bean = new Gson().fromJson(res, ResponseBean.class);


                //把返回内容通过handler对象更新到界面
                mHandler.post(new Thread(){
                    @Override
                    public void run() {
                        if (bean != null) {
                            initRV(bean.getShowapi_res_body().getPagebean().getContentlist());
                        }
                    }
                });
            }
        }.start();

    }
    /**
     * 对rv进行配置
     */
    private void initRV(final List<NewsInfo> newsInfos) {
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        NewsAdapter newsAdapter = new NewsAdapter(getContext(), newsInfos);

        // 绑定点击事件
        newsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // TODO: 2017/12/28 点击每个新闻item需要做的事情

                    NewsInfo newsInfo = newsInfos.get(position);

                    if (newsInfo != null){
                        app.setNewsInfo(newsInfo);
                    }

                    getContext().startActivity(intent);
            }
        });

        rv.setAdapter(newsAdapter);
    }


}
