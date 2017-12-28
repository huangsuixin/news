package com.app.huangsuixin1506101066;

import android.app.Application;

import com.app.huangsuixin1506101066.bean.NewsInfo;

/**
 * @author Silence
 */

public class App extends Application {
    private NewsInfo newsInfo;

    public NewsInfo getNewsInfo() {
        return newsInfo;
    }

    public void setNewsInfo(NewsInfo newsInfo) {
        this.newsInfo = newsInfo;
    }
}
