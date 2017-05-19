package com.example.yls.test.javaBean;

import java.util.List;

/**
 * Created by yls on 2017/5/16.
 */

public class javaBean_fragment1 {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-05-16 09:05","title":"动物园狗熊跨栏失败遭脚踢裆部 观众愤怒喊停","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170516/Img493167756_ss.jpeg","url":"http://news.sohu.com/20170516/n493171459.shtml"},{"ctime":"2017-05-16 09:08","title":"男子手指被列车门夹住 随列车狂奔","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170516/Img493171460_ss.png","url":"http://news.sohu.com/20170516/n493171668.shtml"},{"ctime":"2017-05-16 09:15","title":"乡村女教师被奸杀后沉尸机井 25年后开棺验凶","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170516/Img493172250_ss.jpeg","url":"http://news.sohu.com/20170516/n493172249.shtml"},{"ctime":"2017-05-16 09:54","title":"男子喊阻幼儿入险境 被疑劫持小孩遭家长暴打","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170516/Img493177153_ss.jpeg","url":"http://news.sohu.com/20170516/n493177151.shtml"},{"ctime":"2017-05-16 09:55","title":"上海初中生每日手撕地铁小广告：三个字 不顺眼","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170516/Img493177330_ss.jpeg","url":"http://news.sohu.com/20170516/n493177329.shtml"},{"ctime":"2017-05-16 08:04","title":"北方多地提前入夏 南方迎降雨暂歇期","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170516/Img493165930_ss.jpeg","url":"http://news.sohu.com/20170516/n493166547.shtml"},{"ctime":"2017-05-16 08:22","title":"谷歌研究员质疑\u201c看脸识罪犯\u201d 交大教授回应","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170516/Img493166548_ss.jpg","url":"http://news.sohu.com/20170516/n493167519.shtml"},{"ctime":"2017-05-16 08:25","title":"男童被遗忘在校车内死亡 临死前或用头撞车窗","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170516/Img493167756_ss.jpeg","url":"http://news.sohu.com/20170516/n493167754.shtml"},{"ctime":"2017-05-16 07:13","title":"江西鹰潭货车与公交车相撞已致12死 3人病危","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170516/Img493160119_ss.jpg","url":"http://news.sohu.com/20170516/n493163804.shtml"},{"ctime":"2017-05-16 07:14","title":"医生为患者垫费被妻暴打被指医院软广 院方回应","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170516/Img493160431_ss.jpeg","url":"http://news.sohu.com/20170516/n493163772.shtml"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2017-05-16 09:05
     * title : 动物园狗熊跨栏失败遭脚踢裆部 观众愤怒喊停
     * description : 搜狐社会
     * picUrl : http://photocdn.sohu.com/20170516/Img493167756_ss.jpeg
     * url : http://news.sohu.com/20170516/n493171459.shtml
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
