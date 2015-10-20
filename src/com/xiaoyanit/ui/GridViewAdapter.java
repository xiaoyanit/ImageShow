package com.xiaoyanit.ui;

import java.util.List;

import com.xiaoyanit.R;
import com.xiaoyanit.Constant;
import com.xiaoyanit.model.Images;
import com.xiaoyanit.util.CallbackImpl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * ͼƬչʾAdapter
 * @author xiaoyanit
 *
 */
public class GridViewAdapter extends BaseAdapter{

	private Context context;
	private List<Images> imagesList;
	
	public GridViewAdapter(Context context,List<Images> imagesList){
		this.context = context;
		this.imagesList = imagesList;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imagesList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Images image = imagesList.get(position);
		if(convertView == null)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.imageitem, null);
		}		
		ImageView photo = (ImageView) convertView.findViewById(R.id.photo);
		if(image!=null && image.getThumbnails()!=null)
		{
			CallbackImpl callbackImpl = new CallbackImpl(photo);
			Bitmap cacheImage = Constant.loader.loadDrawable(image.getThumbnails().get_data(), callbackImpl);
			if (cacheImage != null) {
					photo.setImageBitmap(cacheImage);
			}	
		}
		return convertView;
	}

}
