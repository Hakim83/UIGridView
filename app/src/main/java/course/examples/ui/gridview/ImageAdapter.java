package course.examples.ui.gridview;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private static final int PADDING = 8;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	private Context mContext;
	private List<Integer> mThumbIds;

	// Store the list of image IDs
	public ImageAdapter(Context c, List<Integer> ids) {
		mContext = c;
		this.mThumbIds = ids;
	}

	// Return the number of items in the Adapter
	@Override
	public int getCount() {
		return mThumbIds.size();
	}

	// Return the data item at position
	@Override
	public Object getItem(int position) {
		return mThumbIds.get(position);
	}

	// Will get called to provide the ID that
	// is passed to OnItemClickListener.onItemClick()
	@Override
	public long getItemId(int position) {
		return mThumbIds.get(position);
	}

	// Return an ImageView for each item referenced by the Adapter
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ImageView imageView = (ImageView) convertView;

		// if convertView's not recycled, initialize some attributes
		if (imageView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(WIDTH, HEIGHT));
		}

		imageView.setImageResource(mThumbIds.get(position));
		return imageView;
	}
}
