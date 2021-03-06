package com.sufalam.actionbar;

import java.net.URLDecoder;
import java.net.URLEncoder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.owncloud.R;

public class NewQAAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private String[] data;

	String mFrom = "";

	public NewQAAdapter(Context context) {
		mInflater = LayoutInflater.from(context);
	}

	public NewQAAdapter(Context context, String mFrom) {
		this.mFrom = mFrom;
		mInflater = LayoutInflater.from(context);
	}

	public void setData(String[] data) {
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.length;
	}

	@Override
	public Object getItem(int item) {
		return data[item];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list, null);

			holder = new ViewHolder();

			holder.mTitleText = (TextView) convertView
					.findViewById(R.id.t_name);
			holder.mImageView = (ImageView) convertView
					.findViewById(R.id.i_more);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (data[position] != null) {
			

			if (data[position].contains(".jpg") ||data[position].contains(".JPG")){
				holder.mImageView.setImageResource(R.drawable.icon_jpg);
			}else if(data[position].contains(".jpeg")){
				holder.mImageView.setImageResource(R.drawable.icon_jpeg);
			}else if( data[position].contains(".png")){
				holder.mImageView.setImageResource(R.drawable.icon_png);
			}else if(data[position].contains(".tiff")){
				holder.mImageView.setImageResource(R.drawable.icon_tiff);
			}else if(data[position].contains(".gif")) {
				holder.mImageView.setImageResource(R.drawable.icon_gif);
			} else if (data[position].contains(".pdf")) {
				holder.mImageView.setImageResource(R.drawable.icon_pdf);
			} else if (data[position].contains(".txt")
					|| data[position].contains(".rtf")
					|| data[position].contains(".doc")
					|| data[position].contains(".docx")
					|| data[position].contains(".ppt")
					|| data[position].contains(".pptx")
					|| data[position].contains(".xls")
					|| data[position].contains(".xlsx")) {
				holder.mImageView.setImageResource(R.drawable.icon_text);
			} else if (data[position].contains(".mp3")) {
				holder.mImageView.setImageResource(R.drawable.icon_mp3);
			} else if(data[position].contains(".wav")){
				holder.mImageView.setImageResource(R.drawable.icon_wav);
			}else if( data[position].contains(".mp4")){
				holder.mImageView.setImageResource(R.drawable.icon_mp4);
			}else if (data[position].contains(".html")) {
				holder.mImageView.setImageResource(R.drawable.icon_html);
			} else if (data[position].contains(".zip")) {
				holder.mImageView.setImageResource(R.drawable.icon_zip);
			} else if (data[position].contains(".rar")) {
				holder.mImageView.setImageResource(R.drawable.icon_rar);
			} else if ((data[position].startsWith("/"))) {
				holder.mImageView.setImageResource(R.drawable.icon_folder);
			} else {
				holder.mImageView.setImageResource(R.drawable.icon_file);
			}
			
			holder.mTitleText.setText(URLDecoder.decode(data[position]).replace("/", ""));
		}
		

		return convertView;
	}

	static class ViewHolder {
		TextView mTitleText;
		ImageView mImageView;
	}
}