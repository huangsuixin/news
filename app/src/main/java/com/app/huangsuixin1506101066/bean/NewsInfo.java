package com.app.huangsuixin1506101066.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Silence
 */

public class NewsInfo implements Serializable {
    private static final long serialVersionUID = 1L;


    private String id;
    private boolean havePic;
    private String pubDate;
    private String title;
    private String channelName;
    private List<ImageInfo> imageurls;
    private String desc;
    private String source;
    private String channelId;;
    private String nid;
    private String link;
    private boolean hasAll;
    private String content;

    public NewsInfo() {
        imageurls = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "NewsInfo{" +
                "id='" + id + '\'' +
                ", havePic=" + havePic +
                ", pubDate='" + pubDate + '\'' +
                ", title='" + title + '\'' +
                ", channelName='" + channelName + '\'' +
                ", imageurls=" + imageurls +
                ", desc='" + desc + '\'' +
                ", source='" + source + '\'' +
                ", channelId='" + channelId + '\'' +
                ", nid='" + nid + '\'' +
                ", link='" + link + '\'' +
                ", hasAll=" + hasAll +
                ", content='" + content + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHavePic() {
        return havePic;
    }

    public void setHavePic(boolean havePic) {
        this.havePic = havePic;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public List<ImageInfo> getImageurls() {
        return imageurls;
    }

    public void setImageurls(List<ImageInfo> imageurls) {
        this.imageurls = imageurls;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isHasAll() {
        return hasAll;
    }

    public void setHasAll(boolean hasAll) {
        this.hasAll = hasAll;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public class ImageInfo{
        private Integer height;
        private Integer width;
        private String url;

        public ImageInfo() {
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "ImageInfo{" +
                    "height=" + height +
                    ", width=" + width +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
