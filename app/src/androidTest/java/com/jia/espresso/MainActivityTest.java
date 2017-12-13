package com.jia.espresso;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Description:
 * Created by jia on 2017/12/12.
 * 人之所以能，是相信能
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    /**
     * 这句话就定义了一个测试规则,可以看到构造方法的参数里指定了一个 MainActivity.class,
     * 具体的体现就是当你运行这段测试代码时,app将会直接打开 MainActivity界面然后进行你所定义的测试用例.
     * 所以当你想直接测试某个界面时,你可以把那个界面填到这个参数里,这样就直接打开你指定的界面进行测试了.
     */
    @Rule
    public ActivityTestRule mTestRule=new ActivityTestRule<>(MainActivity.class);

    /**
     * 在执行test方法前执行，可用作初始化使用等
     */
    @Before
    public void init(){

        Log.e("TAG", "init: " );

    }

    /**
     * 定义一个测试用例,当你的测试类运行时,所执行的代码就是Test注解下的(Espresso还提供了其他的一些注解,
     * 比如:@After,@Before等,具体的用法可以去我上面写的android官网上查看),
     * 当然上面那段代码对应的就是sayHello测试方法,sayHello方法里所定义的就是要测试的内容
     */
    @Test
    public void testLogin(){

        onView(withId(R.id.et_name)).check(matches(withText("请输入用户名")));

    }
}
