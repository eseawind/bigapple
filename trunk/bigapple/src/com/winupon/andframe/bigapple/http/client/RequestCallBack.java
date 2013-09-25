package com.winupon.andframe.bigapple.http.client;

/**
 * 请求回调
 * 
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2013-8-7 下午2:12:28 $
 */
public abstract class RequestCallBack<T> {
    private boolean progress = true;
    private int rate = 1000 * 1;// 间隔时间通知，默认是1秒

    public boolean isProgress() {
        return progress;
    }

    public int getRate() {
        return rate;
    }

    /**
     * 设置是否加载中回调onLoading方法和回调的频率
     * 
     * @param progress
     *            是否启用进度显示
     * @param rate
     *            进度更新频率
     */
    public RequestCallBack<T> progress(boolean progress, int rate) {
        this.progress = progress;
        this.rate = rate;
        return this;
    }

    /**
     * 访问开始前回调
     */
    public void onStart() {
    };

    /**
     * 正在加载中的回调，只有设置了progress=true，这个方法才会被调用，默认开启每隔1秒回调
     * 
     * @param count
     * @param current
     */
    public void onLoading(long count, long current) {
    };

    /**
     * 成功后回调
     * 
     * @param t
     */
    public void onSuccess(T t) {
    };

    /**
     * 访问异常时回调
     * 
     * @param t
     * @param errorNo
     * @param strMsg
     */
    public void onFailure(Throwable t, int errorNo, String strMsg) {
    };

}
