package android.video.online.core;

/**
 * Created by Jay on 2017/7/21.
 */

public interface BasicView<P extends BasicPresenter> {

    BasicPresenter getPresenter();
}
