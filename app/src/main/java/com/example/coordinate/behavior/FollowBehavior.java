package com.example.coordinate.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.coordinate.util.Logger;

/**
 * CoordinateLayout的behavior
 */
public class FollowBehavior extends CoordinatorLayout.Behavior<TextView> {

    private static final String TAG = FollowBehavior.class.getSimpleName();

    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 判断child的布局是否依赖dependency:
     * 这个方法在对界面进行布局时至少会调用一次，用来确定本次交互行为中的 Dependent View，在上面的代码中，
     * 当 Dependency 是Button 类的实例时返回 true，就可以让系统知道布局文件中的
     * Button 就是本次交互行为中的 Dependent View。
     *
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull TextView child, @NonNull View dependency) {
        Logger.d(TAG, "layoutDependsOn");
        return dependency instanceof Button;
    }

    /**
     * 当 Dependent View 发生变化时，这个方法会被调用，参数中的child相当于本次交互行为中的观察者，
     * 观察者可以在这个方法中对被观察者的变化做出响应，从而完成一次交互行为。
     *
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull TextView child, @NonNull View dependency) {
        Logger.d(TAG, "onDependentViewChanged");
        child.setX(dependency.getX() + 100);
        child.setY(dependency.getY() + 200);
        return true;
    }
}
