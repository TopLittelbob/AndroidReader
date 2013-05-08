package team.top.fragment;

import java.util.List;

import team.top.activity.MainActivity;
import team.top.activity.R;
import team.top.data.FileInfo;
import team.top.utils.FileListHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RightCategoryFragment extends Fragment {

	private LinearLayout officeCategory;
	private LinearLayout pictureCategory;
	private LinearLayout musicCategory;
	private LinearLayout videoCategory;
	private LinearLayout zipCategory;
	private LinearLayout apkCategory;
	private FileListHelper fileListHelper;
	//private List<FileInfo> officeList;
	private List<FileInfo> pictureList;
	private List<FileInfo> musicList;
	private List<FileInfo> videoList;
	//private List<FileInfo> zipList;
	//private List<FileInfo> apkList;
	//private TextView officeCount;
	private TextView musicCount;
	private TextView videoCount;
	private TextView pictureCount;
	//private TextView zipCount;
	//private TextView apkCount;
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_rightcategory, null);
		fileListHelper = new FileListHelper(view.getContext());
		officeCategory = (LinearLayout) view.findViewById(R.id.categoryOfficeBtn);
		pictureCategory = (LinearLayout) view.findViewById(R.id.categoryPictureBtn);
		musicCategory = (LinearLayout) view.findViewById(R.id.categoryMusicBtn);
		videoCategory = (LinearLayout) view.findViewById(R.id.categoryVideoBtn);
		zipCategory = (LinearLayout) view.findViewById(R.id.categoryZipBtn);
		apkCategory = (LinearLayout) view.findViewById(R.id.categoryApkBtn);
		officeCategory.setOnClickListener(new FileCategorySelectListener());
		pictureCategory.setOnClickListener(new FileCategorySelectListener());
		musicCategory.setOnClickListener(new FileCategorySelectListener());
		videoCategory.setOnClickListener(new FileCategorySelectListener());
		zipCategory.setOnClickListener(new FileCategorySelectListener());
		apkCategory.setOnClickListener(new FileCategorySelectListener());
		//officeList = fileListHelper.GetAllFiles(FileListHelper.FileCategory.DOC, true);
		pictureList = fileListHelper.GetAllFiles(FileListHelper.FileCategory.PICTURE, true);
		musicList = fileListHelper.GetAllFiles(FileListHelper.FileCategory.MUSIC, true);
		videoList = fileListHelper.GetAllFiles(FileListHelper.FileCategory.VIDEO, true);
		//zipList = fileListHelper.GetAllFiles(FileListHelper.FileCategory.ZIP, true);
		//apkList = fileListHelper.GetAllFiles(FileListHelper.FileCategory.APK, true);
		musicCount = (TextView)view.findViewById(R.id.categoryMusicCount);
		videoCount = (TextView)view.findViewById(R.id.categoryVideoCount);
		pictureCount = (TextView)view.findViewById(R.id.categoryPictureCount);
		//officeCount = (TextView)view.findViewById(R.id.categoryOfficeCount);
		//zipCount = (TextView)view.findViewById(R.id.categoryZipCount);
		//apkCount = (TextView)view.findViewById(R.id.categoryApkCount);
		musicCount.setText("(" + musicList.size() +")");
		videoCount.setText("(" + videoList.size() +")");
		pictureCount.setText("(" + pictureList.size() +")");
		//officeCount.setText("(" + musicList.size() +")");
		//zipCount.setText("(" + musicList.size() +")");
		//apkCount.setText("(" + musicList.size() +")");
		
		return view;
	}

	class FileCategorySelectListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			List<FileInfo> fileList = null;
			switch (id) {
			case R.id.categoryOfficeBtn:
			//	fileList = fileListHelper.GetAllFiles(FileListHelper.FileCategory.DOC, true);
				break;
			case R.id.categoryPictureBtn:
				fileList = pictureList;
				break;
			case R.id.categoryMusicBtn:
				fileList = musicList;
				break;
			case R.id.categoryVideoBtn:
				fileList = videoList;
				break;
			case R.id.categoryZipBtn:
				//fileList = fileListHelper.GetAllFiles(FileListHelper.FileCategory.ZIP, true);
				break;
			case R.id.categoryApkBtn:
				//fileList = fileListHelper.GetAllFiles(FileListHelper.FileCategory.APK, true);
				break;
			default:
				break;
			}
			if (fileList != null) {
				FileListFragment.setData(fileList);
			}
			MainActivity.mSlidingMenu.showRightView();
		}

	}

}
