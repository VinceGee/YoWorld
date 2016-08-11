package com.empire.vince.vokers.yoworld.adapter;

import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.empire.vince.vokers.yoworld.YoWorldApplication;
import com.empire.vince.vokers.yoworld.R;
import com.empire.vince.vokers.yoworld.db.models.PoiModel;
import com.empire.vince.vokers.yoworld.listener.AnimateImageLoadingListener;
import com.empire.vince.vokers.yoworld.utilities.LocationUtility;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by VinceGee on 08/04/2016.
 */
public class PoiListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private static final int VIEW_TYPE_POI = 1;
    private static final int VIEW_TYPE_FOOTER = 2;

    private List<PoiModel> mPoiList;
    private List<Object> mFooterList;
    private PoiViewHolder.OnItemClickListener mListener;
    private int mGridSpanCount;
    private boolean mAnimationEnabled = true;
    private int mAnimationPosition = -1;
    private ImageLoader mImageLoader = ImageLoader.getInstance();
    private DisplayImageOptions mDisplayImageOptions;
    private ImageLoadingListener mImageLoadingListener;


    public PoiListAdapter(List<PoiModel> poiList, List<Object> footerList, PoiViewHolder.OnItemClickListener listener, int gridSpanCount)
    {
        mPoiList = poiList;
        mFooterList = footerList;
        mListener = listener;
        mGridSpanCount = gridSpanCount;

        // image caching options
        mDisplayImageOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(android.R.color.transparent)
                .showImageForEmptyUri(R.drawable.placeholder_photo)
                .showImageOnFail(R.drawable.placeholder_photo)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new SimpleBitmapDisplayer())
                .build();
        mImageLoadingListener = new AnimateImageLoadingListener();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // inflate view and create view holder
        if(viewType== VIEW_TYPE_POI)
        {
            View view = inflater.inflate(R.layout.fragment_poi_list_item, parent, false);
            return new PoiViewHolder(view, mListener, mImageLoader, mDisplayImageOptions, mImageLoadingListener);
        }
        else if(viewType==VIEW_TYPE_FOOTER)
        {
            View view = inflater.inflate(R.layout.fragment_poi_list_footer, parent, false);
            return new FooterViewHolder(view);
        }
        else
        {
            throw new RuntimeException("There is no view type that matches the type " + viewType);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position)
    {
        // bind data
        if(viewHolder instanceof PoiViewHolder)
        {
            // entity
            PoiModel poi = mPoiList.get(getPoiPosition(position));

            // render view
            if(poi != null)
            {
                ((PoiViewHolder) viewHolder).bindData(poi);
            }
        }
        else if(viewHolder instanceof FooterViewHolder)
        {
            // entity
            Object object = mFooterList.get(getFooterPosition(position));

            // render view
            if(object != null)
            {
                ((FooterViewHolder) viewHolder).bindData(object);
            }
        }

        // set item margins
        setItemMargins(viewHolder.itemView, position);

        // set animation
        setAnimation(viewHolder.itemView, position);
    }


    @Override
    public int getItemCount()
    {
        int size = 0;
        if(mPoiList !=null) size += mPoiList.size();
        if(mFooterList!=null) size += mFooterList.size();
        return size;
    }


    @Override
    public int getItemViewType(int position)
    {
        int pois = mPoiList.size();
        int footers = mFooterList.size();

        if(position < pois) return VIEW_TYPE_POI;
        else if(position < pois+footers) return VIEW_TYPE_FOOTER;
        else return -1;
    }


    public int getPoiCount()
    {
        if(mPoiList !=null) return mPoiList.size();
        return 0;
    }


    public int getFooterCount()
    {
        if(mFooterList!=null) return mFooterList.size();
        return 0;
    }


    public int getPoiPosition(int recyclerPosition)
    {
        return recyclerPosition;
    }


    public int getFooterPosition(int recyclerPosition)
    {
        return recyclerPosition - getPoiCount();
    }


    public int getRecyclerPositionByPoi(int poiPosition)
    {
        return poiPosition;
    }


    public int getRecyclerPositionByFooter(int footerPosition)
    {
        return footerPosition + getPoiCount();
    }


    public void refill(List<PoiModel> poiList, List<Object> footerList, PoiViewHolder.OnItemClickListener listener, int gridSpanCount)
    {
        mPoiList = poiList;
        mFooterList = footerList;
        mListener = listener;
        mGridSpanCount = gridSpanCount;
        notifyDataSetChanged();
    }


    public void stop()
    {

    }


    public void setAnimationEnabled(boolean animationEnabled)
    {
        mAnimationEnabled = animationEnabled;
    }


    private void setAnimation(final View view, int position)
    {
        if(mAnimationEnabled && position>mAnimationPosition)
        {
            view.setScaleX(0f);
            view.setScaleY(0f);
            view.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(300)
                    .setInterpolator(new DecelerateInterpolator());

            mAnimationPosition = position;
        }
    }


    private void setItemMargins(View view, int position)
    {
        int height = (int) YoWorldApplication.getContext().getResources().getDimension(R.dimen.fragment_poi_list_recycler_item_size);
        int marginTop = 0;

        if(position<mGridSpanCount)
        {
            TypedArray a = YoWorldApplication.getContext().obtainStyledAttributes(null, new int[]{android.R.attr.actionBarSize}, 0, 0);
            marginTop = (int) a.getDimension(0, 0);
            a.recycle();

            height += marginTop;
        }

        ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginParams.setMargins(0, marginTop, 0, 0);

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = height;
    }


    public static final class PoiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView nameTextView;
        private TextView distanceTextView;
        private ImageView imageView;
        private OnItemClickListener mListener;
        private ImageLoader mImageLoader;
        private DisplayImageOptions mDisplayImageOptions;
        private ImageLoadingListener mImageLoadingListener;


        public interface OnItemClickListener
        {
            public void onItemClick(View view, int position, long id, int viewType);
        }


        public PoiViewHolder(View itemView, OnItemClickListener listener, ImageLoader imageLoader, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener)
        {
            super(itemView);
            mListener = listener;
            mImageLoader = imageLoader;
            mDisplayImageOptions = displayImageOptions;
            mImageLoadingListener = imageLoadingListener;

            // set listener
            itemView.setOnClickListener(this);

            // find views
            nameTextView = (TextView) itemView.findViewById(R.id.fragment_poi_list_item_name);
            distanceTextView = (TextView) itemView.findViewById(R.id.fragment_poi_list_item_distance);
            imageView = (ImageView) itemView.findViewById(R.id.fragment_poi_list_item_image);
        }


        @Override
        public void onClick(View view)
        {
            mListener.onItemClick(view, getPosition(), getItemId(), getItemViewType());
        }


        public void bindData(PoiModel poi)
        {
            nameTextView.setText(poi.getName());
            mImageLoader.displayImage(poi.getImage(), imageView, mDisplayImageOptions, mImageLoadingListener);

            if(poi.getDistance()>0)
            {
                String distance = LocationUtility.getDistanceString(poi.getDistance(), LocationUtility.isMetricSystem());
                distanceTextView.setText(distance);
                distanceTextView.setVisibility(View.VISIBLE);
            }
            else
            {
                distanceTextView.setVisibility(View.GONE);
            }
        }
    }


    public static final class FooterViewHolder extends RecyclerView.ViewHolder
    {
        public FooterViewHolder(View itemView)
        {
            super(itemView);
        }


        public void bindData(Object object)
        {
            // do nothing
        }
    }
}
