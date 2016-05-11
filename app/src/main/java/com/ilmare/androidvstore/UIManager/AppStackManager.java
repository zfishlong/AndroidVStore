package com.ilmare.androidvstore.UIManager;

import android.view.View;

import java.util.LinkedList;

/**
 * 用来管理应用中MiddleView的生命周期
 */
public class AppStackManager {

	private LinkedList<View> appStack;

	private static AppStackManager appStackManager = new AppStackManager();

	private AppStackManager() {
		
	}

	public static AppStackManager getInstance() {
		return appStackManager;
	}


	/**
	 * 获取应用栈的内容的大小
	 * @return
	 */
	public int getAppStackSize(){
		if(appStack!=null){
			return appStack.size();
		}else{
			return 0;
		}
	}
	
	/**
	 * 添加view到堆栈中
	 * @param baseView 要加入到应用栈的view对象
	 */
	public void addStack(View baseView) {
		if (appStack == null) {
			appStack = new LinkedList<View>();
		}
		appStack.addFirst(baseView);
	}

	
	/**
	 * 获取当前正在显示的UI
	 * @return
	 */
	public View currentView() {

		if (appStack != null && appStack.size() > 0) {
			return appStack.getFirst();
		} else {
			return null;
		}

	}

	
	/**
	 * 删除当前的view
	 */
	public void removeCurrentView() {
		View baseView = appStack.getFirst();
		removeView(baseView);
	}

	

	public void removeView(View baseView) {
		if (baseView != null) {
			appStack.remove(baseView);
			baseView = null;
		}
	}

	

	public void removeAllView() {
		for (View baseView : appStack) {
			removeView(baseView);
		}
	}

	
	/**
	 * 结束当前堆栈中所有的View
	 */
	public void finishAllView() {
		appStack.clear();
	}

}
