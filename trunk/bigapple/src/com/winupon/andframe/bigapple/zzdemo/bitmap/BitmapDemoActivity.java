/* 
 * @(#)BitmapDemoActivity.java    Created on 2014-3-31
 * Copyright (c) 2014 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.winupon.andframe.bigapple.zzdemo.bitmap;

<<<<<<< HEAD
import com.winupon.andframe.bigapple.ioc.AnActivity;

/**
=======
import java.util.concurrent.atomic.AtomicInteger;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.winupon.andframe.bigapple.R;
import com.winupon.andframe.bigapple.bitmap.BitmapDisplayConfig;
import com.winupon.andframe.bigapple.bitmap.callback.DownloaderCallBack;
import com.winupon.andframe.bigapple.bitmap.callback.ImageLoadCallBack;
import com.winupon.andframe.bigapple.ioc.AnActivity;
import com.winupon.andframe.bigapple.ioc.InjectView;
import com.winupon.andframe.bigapple.utils.ContextUtils;

/**
 * 网络图片加载测试
 * 
>>>>>>> 61bb41709ae045e5229902c7dbe803ce270be42b
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2014-3-31 下午12:05:35 $
 */
public class BitmapDemoActivity extends AnActivity {

<<<<<<< HEAD
=======
	@InjectView(R.id.button)
	private Button button;

	@InjectView(R.id.imageView)
	private ImageView imageView;

	@InjectView(R.id.textView)
	private TextView textView;

	@InjectView(R.id.textView2)
	private TextView textView2;

	private AtomicInteger count;

	@InjectView(R.id.gridView)
	private GridView gridView;

	private final Handler handler = new Handler();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_bitmap_main);
		button.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				AnBitmapUtilsFace.getInstance().clearCache();
			}
		});

		// 2M
		String url1 = "http://img.wallba.com/data/Image/2013pq/3yue/26hao/6/8/2013326105911734.jpg";

		// 100K
		String url2 = "http://s1.cubexp.com/image/ec8/617a397032c8dfc5ec8054e638ed15cc.jpg";

		// 27K
		String url3 = "http://imgsrc.baidu.com/forum/w%3D580%3B/sign=aa9dd16572cf3bc7e800cde4e13bbba1/7a899e510fb30f248f33c16bca95d143ad4b0328.jpg";

		String url4 = ContextUtils.getSdCardPath() + "/xuan/222.jpg";

		final String[] urls = new String[20];
		for (int i = 0; i < urls.length; i++) {
			urls[i] = url4;
		}

		count = new AtomicInteger(urls.length);

		final long start = System.currentTimeMillis();
		final BitmapDisplayConfig displayConfig = new BitmapDisplayConfig();
		displayConfig.setShowOriginal(false);
		displayConfig.setBitmapMaxHeight(100);
		displayConfig.setBitmapMaxWidth(100);
		displayConfig.setDownloaderCallBack(new DownloaderCallBack() {
			@Override
			public void onStartLoading(String url) {
				handler.post(new Runnable() {
					@Override
					public void run() {
						textView.setText("开始下载\n");
					}
				});
			}

			@Override
			public void onLoading(final int total, final int current) {
				handler.post(new Runnable() {
					@Override
					public void run() {
						textView2.setText("下载进度：" + current + "/" + total);
					}
				});
			}

			@Override
			public void onEndLoading() {
				handler.post(new Runnable() {
					@Override
					public void run() {
						textView.setText(textView.getText() + "下载结束");
					}
				});
			}
		});

		displayConfig.setDownloaderCallBack(null);

		displayConfig.setImageLoadCallBack(new ImageLoadCallBack() {
			@Override
			public void loadFailed(ImageView imageView, Bitmap bitmap) {
			}

			@Override
			public void loadCompleted(ImageView imageView, final Bitmap bitmap,
					BitmapDisplayConfig config) {
				imageView.setImageBitmap(bitmap);
				count.decrementAndGet();
				if (count.get() == 0) {
					textView.setText("一共耗时："
							+ ((System.currentTimeMillis() - start) / 1000)
							+ "秒");
				}
			}
		});

		AnBitmapUtilsFace.getInstance().display(imageView, url3, displayConfig);

		gridView.setAdapter(new BaseAdapter() {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ImageView imageView = new ImageView(BitmapDemoActivity.this);
				imageView.setLayoutParams(new GridView.LayoutParams(60, 60));

				imageView.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.ic_launcher));
				AnBitmapUtilsFace.getInstance().display(imageView,
						urls[position], displayConfig);

				return imageView;
			}

			@Override
			public long getItemId(int position) {
				return 0;
			}

			@Override
			public Object getItem(int position) {
				return null;
			}

			@Override
			public int getCount() {
				return urls.length;
			}
		});
	}
>>>>>>> 61bb41709ae045e5229902c7dbe803ce270be42b
}
