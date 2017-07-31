package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/7/25.
 */

public class VideoPlayerModel implements BasicModel {
    private VideoVoModel vo;
    private VideoAuthModel vod_auth;

    public VideoVoModel getVo() {
        return vo;
    }

    public void setVo(VideoVoModel vo) {
        this.vo = vo;
    }

    public VideoAuthModel getVod_auth() {
        return vod_auth;
    }

    public void setVod_auth(VideoAuthModel vod_auth) {
        this.vod_auth = vod_auth;
    }
}
