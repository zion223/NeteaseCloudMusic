package com.imooc.lib_pullalive.app;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

@TargetApi(value = Build.VERSION_CODES.LOLLIPOP)
public class AliveJobService extends JobService {

	private static final String TAG = AliveJobService.class.getName();
	private JobScheduler mJobScheduler;


	private Handler mHandler = new Handler(Looper.getMainLooper()){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what){
				case 1:
					jobFinished((JobParameters) msg.obj, true);
					break;
				case 2:
					Log.d(TAG, "AliveJobService finished");
					break;
				default:
					break;

			}
		}
	};

	@Override
	public void onCreate() {
		super.onCreate();
		mJobScheduler = (JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//提交job到System Process中
		if(mJobScheduler.schedule(initJobInfo(startId)) <= 0){
			Log.w(TAG, "AliveJobService failed");
		}else{
			Log.d(TAG, "AliveJobService success");
		}
		return START_STICKY;
	}

	//初始化JobInfo
	private JobInfo initJobInfo(int startId){
		JobInfo.Builder builder = new JobInfo.Builder(startId, new ComponentName(getPackageName(), AliveJobService.class.getName()));
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
			builder.setMinimumLatency(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS)
					.setOverrideDeadline(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS)
					.setBackoffCriteria(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS, JobInfo.BACKOFF_POLICY_LINEAR);
		}else{
			builder.setPeriodic(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS);
		}
		builder.setPersisted(false);
		builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
		builder.setRequiresCharging(false);
		return builder.build();
	}



	@Override
	public boolean onStartJob(JobParameters params) {
		mHandler.sendMessage(Message.obtain(mHandler,1, params));
		return true;
	}

	@Override
	public boolean onStopJob(JobParameters params) {
		mHandler.sendMessage(Message.obtain(mHandler,2));
		return false;
	}
}
