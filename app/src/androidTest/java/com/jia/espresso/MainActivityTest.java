package com.jia.espresso;

import android.support.test.espresso.Espresso;
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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;


/**
 * Description:
 * Created by jia on 2017/12/12.
 * 人之所以能，是相信能
 */

/**
 * 首先需要在测试用例类的类体前添加@RunWith的注解，并设置测试运行平台为AndroidJUnit4
 * 如果允许测试需要较大消耗，可以使用@LargeTest注解
 * 设置ActivityTestRule用来指明被测试的Activity，使用@Rule注解
 * 测试方法必须以 test 开头，并且使用@Test注解
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    private String[] names = {"", "a", "123123"};
    private String[] pwds = {"", "a", "123123"};

    /**
     * 这句话就定义了一个测试规则,可以看到构造方法的参数里指定了一个 MainActivity.class,
     * 具体的体现就是当你运行这段测试代码时,app将会直接打开 MainActivity界面然后进行你所定义的测试用例.
     * 所以当你想直接测试某个界面时,你可以把那个界面填到这个参数里,这样就直接打开你指定的界面进行测试了.
     */
    @Rule
    public ActivityTestRule mTestRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * 在执行test方法前执行，可用作初始化使用等
     */
    @Before
    public void init() {

        Log.e("TAG", "init: ");

    }

    /**
     * 定义一个测试用例,当你的测试类运行时,所执行的代码就是Test注解下的(Espresso还提供了其他的一些注解,
     * 比如:@After,@Before等,具体的用法可以去我上面写的android官网上查看),
     * 当然上面那段代码对应的就是sayHello测试方法,sayHello方法里所定义的就是要测试的内容
     */
    @Test
    public void testLogin() {

        // 不做任何输入，直接点击登录
        onView(allOf(withId(R.id.bt_login), isDisplayed())).perform(click());
        onView(allOf(withId(R.id.tv_login_result), isDisplayed())).check(matches(withText("用户名为空")));

        // 用户名是空，点击登录
        onView(allOf(withId(R.id.et_name), isDisplayed())).perform(replaceText(names[0]), closeSoftKeyboard());
        onView(allOf(withId(R.id.bt_login), isDisplayed())).perform(click());
        onView(allOf(withId(R.id.tv_login_result), isDisplayed())).check(matches(withText("用户名为空")));

        // 用户名格式错误，点击登录
        onView(allOf(withId(R.id.et_name), isDisplayed())).perform(replaceText(names[1]), closeSoftKeyboard());
        onView(allOf(withId(R.id.bt_login), isDisplayed())).perform(click());
        onView(allOf(withId(R.id.tv_login_result), isDisplayed())).check(matches(withText("用户名格式错误")));

        // 用户名和密码都正确，点击登录
        onView(allOf(withId(R.id.et_name), isDisplayed())).perform(replaceText(names[2]), closeSoftKeyboard());
        onView(allOf(withId(R.id.et_pwd), isDisplayed())).perform(replaceText(pwds[2]), closeSoftKeyboard());
        onView(allOf(withId(R.id.bt_login), isDisplayed())).perform(click());
        onView(allOf(withId(R.id.tv_login_result), isDisplayed())).check(matches(withText("登录成功")));
    }

    /**
     * 1、使用onView方法找到view：其中参数可以是withId（通过资源id查找），withText（通过显示内容查找）
     *                        有多个约束条件时，可以使用allOf  如allOf(withText("Hello") ,withId(R.id.hello))
     *
     *    注意：a、无论是通过withId()找控件还是通过withText()找控件
     *             或者其他方式比如withClassName(),withResourceName(),withTagKey()等方法,
     *             都要一定保证你所找的控件在当前页面确实存在且可见
     *          b、如果要测试AdapterView ,比如 ListView 或GridView等,使用上面的onView()方法是无效的,
     *             因为AdapterView的布局item是动态呈现的,没法直接指定,
     *             所以当要测试AdapterView时,请把onView()方法换成onData() 方法,
     *             与onView()方法返回ViewInteraction类似,onData()方法返回DataInteraction,二者用法基本都是一样的.
     */

    /**
     * 2、对View的操作：perform()方法  方式是onView(...).perform();
     *      其中参数：click()               点击view
     *               clearText()            清除文本内容
     *               swipeLeft()            从右往左滑
     *               swipeRight()           从左往右滑
     *               swipeDown()            从上往下滑
     *               swipeUp()              从下往上滑
     *               closeSoftKeyboard()    关闭软键盘
     *               pressBack()            按下物理返回键
     *               doubleClick()          双击
     *               longClick()            长按
     *               scrollTo()             移动
     *               replaceText()          替换文本
     *               openLinkWithText()     打开指定超链
     *
     *      也可以执行多个操作在一个perform中如：perform(click(),clearText())
     *
     *
     *      所有的操作都有一个前提 ———— 就是你要执行的view必须在当前界面上显示出来（有且可见）
     */

    /**
     * 3、使用check()方法来检查View是否符合我们的期望： onView(...).check()
     *       检查view中是否含有文本“hello”              check(matches(withText("hello")))
     */

    /**
     * 4、异步：有时操作View后，需要执行一个耗时的操作，通常采用 异步回调 来显示结果，
     *          也就是说验证结果不能同步进行，而是需要异步回调通知 再执行
     *          Espresso提供了原生的异步测试支持，通过实现IdlingResource接口，
     *          复写getName()、isIdleNow()、registerIdleTranstionCallback()方法。
     *
     *          需要注册和解注册：Espresso.registerIdlingResources(idlingResource);
     *
     *          当方法执行完成，调用ResourceCallback.onTransitionToIdle();则会进行回调通知测试线程继续执行验证代码。
     */
}
