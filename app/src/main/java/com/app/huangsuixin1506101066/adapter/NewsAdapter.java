package com.app.huangsuixin1506101066.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.huangsuixin1506101066.R;
import com.app.huangsuixin1506101066.bean.NewsInfo;
import com.app.huangsuixin1506101066.listener.OnItemClickListener;
import com.bumptech.glide.Glide;

import java.util.List;


/**
 * @author Silence
 * 新闻item适配器
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsItemHolder>{

	private Context mContext;
	private List<NewsInfo> data;
	private OnItemClickListener mOnItemClickListener;//声明接口


	public NewsAdapter(Context context, List<NewsInfo> data) {
		mContext = context;
		this.data = data;
	}


	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		mOnItemClickListener = onItemClickListener;
	}
	//创建新View，被LayoutManager所调用
	@Override
	public NewsItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
		NewsItemHolder mvh = new NewsItemHolder(itemView);
		return mvh;
	}

	//将数据与界面进行绑定的操作
	@Override
	public void onBindViewHolder(final NewsItemHolder holder, int position) {

		View itemView = ((RelativeLayout) holder.itemView).getChildAt(0);
		if (mOnItemClickListener != null){
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					int position = holder.getLayoutPosition();
					mOnItemClickListener.onItemClick(holder.itemView, position);
				}
			});
		}

		// TODO: 2017/12/27 绑定数据这个是找到集合里面的对象，我要用他的属性，
		NewsInfo news = data.get(position);
		if (news == null) {
			return;
		}
		holder.title.setText(news.getTitle());
		holder.from.setText(news.getSource());
		holder.time.setText(news.getPubDate());

		//用glide  读取url地址的图片
		if (data.get(position).isHavePic()) {
			Glide.with(mContext)
					.load(data.get(position).getImageurls().get(0).getUrl())
					.placeholder(R.drawable.load) //加载时的图片
					.into(holder.img);
		}


	}
	//获取数据的数量
	@Override
	public int getItemCount() {
		if (data != null) {
			return data.size();
		}
		return 0;
	}

	//自定义的ViewHolder，持有每个Item的的所有界面元素
	public class NewsItemHolder extends RecyclerView.ViewHolder {

		private TextView title,comment,time,from;
		private ImageView img;

		public NewsItemHolder(View itemView) {
			super(itemView);
			//// TODO: 2017/11/21 初始化item的控件
			title = (TextView) itemView.findViewById(R.id.title);
			comment = (TextView) itemView.findViewById(R.id.comment);
			time = (TextView) itemView.findViewById(R.id.time);
			from = (TextView) itemView.findViewById(R.id.from);
			img = (ImageView) itemView.findViewById(R.id.img);

		}

	}
}
