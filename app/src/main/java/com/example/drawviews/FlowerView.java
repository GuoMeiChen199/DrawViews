package com.example.drawviews;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 甘之如饴 on 2019/2/20.
 */

/*
public class FlowerView extends ViewGroup {
    public FlowerView(Context context) {
        super(context, null);
    }

    public FlowerView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public FlowerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    //储存每一行的高度
    List<Integer> mListHigh = new ArrayList<>();
    //储存每一行的view
    List<List<View>> mListViews = new ArrayList<>();
    //测量

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取父view的宽高以及模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heighMode = MeasureSpec.getMode(heightMeasureSpec);
        int heighSize = MeasureSpec.getSize(heightMeasureSpec);

        //记录当前自定义view的宽高
        int measureWidth = 0;
        int measureHeight = 0;

        //判断模式
        //如果是精确模式


        if (widthMode ==MeasureSpec.EXACTLY && heighMode == MeasureSpec.EXACTLY){
            measureWidth = widthSize;
            measureHeight = heighSize;
        }

        //记录子view的宽高
        int childWidth = 0;
        int childHeight = 0;

        //记录每一行宽和 行高
        int lineWidth = 0;
        int lineHeight = 0;

        //
        int iCount = getChildCount();

        //存储一行view的集合
        List<View> itemList = new ArrayList<>();

        for (int i = 0; i < iCount; i++) {
            //获取每一个子view
            View childView = getChildAt(i);
            //测量每一个子view
            measureChild(childView,widthMeasureSpec,heightMeasureSpec);
            MarginLayoutParams layoutParams = (MarginLayoutParams) childView.getLayoutParams();
            //子view的宽高
            childWidth = childView.getWidth()+layoutParams.leftMargin+layoutParams.rightMargin;
            childHeight = childView.getHeight()+layoutParams.topMargin+layoutParams.bottomMargin;
            //换行
            if (lineWidth+childWidth>widthSize){
                //记录上一行的信息
                //最大行宽就是父view的宽
                measureWidth = Math.max(measureWidth,lineWidth);
                //父view的高就是行数叠加
                measureHeight += lineHeight;

                //储存行高
                mListHigh.add(lineHeight);
                mListViews.add(itemList);
                //
                lineHeight = childHeight;
                lineWidth = childWidth;
                //
                itemList = new ArrayList<>();
                itemList.add(childView);
            }else {
                //宽度叠加
                lineWidth+=childWidth;
                //取当前view的高度和行高 取最大
                lineHeight = Math.max(lineHeight,childHeight);
                itemList.add(childView);
            }
        }
        //设置view的宽高
        setMeasuredDimension(measureWidth,measureHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left,top,right,bottom;
        int cutLeft = 0;
        int cutTop = 0;
        for (int i = 0; i < mListViews.size(); i++) {
            List<View> views = mListViews.get(i);
            for (int j = 0; j < views.size(); j++) {
                View childView = views.get(j);
                MarginLayoutParams layoutParams = (MarginLayoutParams) childView.getLayoutParams();
                left = cutLeft + layoutParams.leftMargin;
                right = left + childView.getMeasuredWidth();
                top = cutTop + layoutParams.topMargin;
                bottom = top + childView.getMeasuredHeight();
                childView.layout(left,top,right,bottom);
                cutLeft+=childView.getMeasuredWidth()+layoutParams.leftMargin+layoutParams.rightMargin;
            }
            cutLeft = 0;
            cutTop+=mListHigh.get(i);
        }
        mListHigh.clear();
        mListViews.clear();
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return super.generateLayoutParams(attrs);
    }
}
*/
public class FlowerView extends ViewGroup{
    public FlowerView(Context context) {
        this(context,null);
    }

    public FlowerView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FlowerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //存储每一个的高度
    List<Integer>listHeight=new ArrayList<>();
    //存储每一行view
    List<List<View>>allList=new ArrayList<>();
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取父View的宽高以及模式
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);

        int heightMode= MeasureSpec.getMode(heightMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        //记录当前自定义View的宽高
        int measureWidth=0;
        int measureHeight=0;
        //match_parent 具体值
        if(widthMode==MeasureSpec.EXACTLY &&heightMode==MeasureSpec.EXACTLY){
            measureWidth=widthSize;
            measureHeight=heightSize;
        }
        //记录子View的宽高
        int childWidth=0;
        int childHeight=0;

        //记录每一行宽和行高
        int lineWidth=0;
        int lineHeight=0;


        //wrap_content
        int iCount=getChildCount();
        //存储一行view的集合
        List<View>itemList=new ArrayList<>();
        for (int i = 0; i < iCount; i++) {
            View childView=getChildAt(i);
            //测量每一个子View
            measureChild(childView,widthMeasureSpec,heightMeasureSpec);
            MarginLayoutParams layoutParams= (MarginLayoutParams) childView.getLayoutParams();
            childWidth=childView.getMeasuredWidth()+layoutParams.leftMargin+layoutParams.rightMargin;
            childHeight=childView.getMeasuredHeight()+layoutParams.topMargin+layoutParams.bottomMargin;
            //换行
            if(lineWidth+childWidth>widthSize){
                //记录上一行的信息
                measureWidth=Math.max(measureWidth,lineWidth);
                measureHeight+=lineHeight;
                //将行高存储
                listHeight.add(lineHeight);
                allList.add(itemList);

                lineHeight=childHeight;
                lineWidth=childWidth;

                itemList=new ArrayList<>();
                itemList.add(childView);

            }else{
                //宽度叠加
                lineWidth+=childWidth;
                //取当前View的高度和行高  取最大
                lineHeight=Math.max(lineHeight,childHeight);
                itemList.add(childView);
            }


        }

        //设置View的宽和高
        setMeasuredDimension(measureWidth,measureHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left,top,right,bottom;
        int cutleft=0;
        int cutTop=0;
        for (int i = 0; i < allList.size(); i++) {
            List<View>views=allList.get(i);
            for (int j = 0; j <views.size() ; j++) {
                View childView=views.get(j);
                MarginLayoutParams layoutParams= (MarginLayoutParams) childView.getLayoutParams();
                left=cutleft+layoutParams.leftMargin;
                right=left+childView.getMeasuredWidth();
                top=cutTop+layoutParams.topMargin;
                bottom=top+childView.getMeasuredHeight();
                childView.layout(left,top,right,bottom);
                cutleft+=childView.getMeasuredWidth()+layoutParams.leftMargin+layoutParams.rightMargin;
            }
            cutleft=0;
            cutTop+=listHeight.get(i);
        }
        listHeight.clear();
        allList.clear();
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }
}