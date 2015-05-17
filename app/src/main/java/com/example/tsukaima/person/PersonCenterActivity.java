package com.example.tsukaima.person;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.joanzapata.android.iconify.IconDrawable;
import com.joanzapata.android.iconify.Iconify;


public class PersonCenterActivity extends ActionBarActivity implements ScrollViewListener {

    //private Userprofile userprofile = null;

    /**
     * 前台所有的控件
     */
//    private TextView phoneNumberTextView = null; //电话
//    private TextView phoneNumberEditTextView = null; //编辑电话
//    private TextView emailTextView = null; //邮件
//    private TextView emailEditTextView = null; //编辑邮件
//    private TextView educationTextView = null; //教育背景
//    private TextView newEducationTextView = null;
//    private TextView workTextView = null;
//    private TextView newWorkTextView = null;
//    private TextView awardTextView = null;
//    private TextView newAwardTextView = null;
//    private TextView skillTextView = null;
//    private TextView newSkillText = null;
    private LinearLayout informationLinearLayout = null;
    private LinearLayout phoneLinearLayout = null;
    private LinearLayout emailLinearLayout = null;
    private LinearLayout educationLinearLayout = null;
    private LinearLayout workLinearLayout = null;
    private LinearLayout awardLinearLayout = null;
    private LinearLayout skillLinearLayout = null;

    private Toolbar toolbar = null;
    private ObservableScrollView scrollView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_center);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        scrollView = (ObservableScrollView) findViewById(R.id.scrollView);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        // Navigation Icon 要設定在 setSupoortActionBar 才有作用
        // 否則會出現 back button
        toolbar.setNavigationIcon(new IconDrawable(this, Iconify.IconValue.fa_navicon)
                .colorRes(R.color.white).actionBarSize());

        scrollView.setScrollViewListener(this);
        this.initView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_person_center, menu);
        menu.findItem(R.id.action_edit).setIcon(
                new IconDrawable(this, Iconify.IconValue.fa_pencil).colorRes(R.color.white)
                        .actionBarSize());
        menu.findItem(R.id.action_share).setIcon(
                new IconDrawable(this, Iconify.IconValue.fa_share).colorRes(R.color.white)
                        .actionBarSize());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        this.informationLinearLayout = (LinearLayout) findViewById(R.id.detailed_information);
        this.setPhone();
        this.setEmail();
        this.setEducation();
        this.setWork();
    }

    /**
     * 设置电话模块
     */
    private void setPhone() {
        this.phoneLinearLayout = getPersonProfileItem("{fa-phone}", "点击编辑");
        LinearLayout phoneContent = (LinearLayout) this.phoneLinearLayout.findViewById(R.id.content);

        //新建TextView存放电话文本
        TextView phoneTextView = new TextView(this);
        phoneTextView.setLayoutParams(new TextSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        phoneTextView.setText("(650-555-1234)");
        phoneTextView.setTextColor(Color.parseColor("#ff433f44"));
        phoneTextView.setTextSize(18);

        phoneContent.addView(phoneTextView);
        this.informationLinearLayout.addView(this.phoneLinearLayout);
    }

    /**
     * 设置邮件模块
     */
    private void setEmail() {
        this.emailLinearLayout = getPersonProfileItem("{fa-envelope-o}", "点击编辑");
        LinearLayout emailContent = (LinearLayout) this.emailLinearLayout.findViewById(R.id.content);

        //新建TextView存放邮件地址
        TextView emailTextView = new TextView(this);
        emailTextView.setLayoutParams(new TextSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        emailTextView.setText("qcystudio@qq.com");
        emailTextView.setTextColor(Color.parseColor("#ff433f44"));
        emailTextView.setTextSize(18);

        emailContent.addView(emailTextView);
        this.informationLinearLayout.addView(this.emailLinearLayout);
    }

    /**
     * 设置教育背景模块
     */
    private void setEducation() {
        LayoutInflater inflater = LayoutInflater.from(this);
        this.educationLinearLayout = getPersonProfileItem("{fa-mortar-board}", "新增教育经历");
        LinearLayout educationList = (LinearLayout) this.educationLinearLayout.findViewById(R.id.content);


        View educationItem = inflater.inflate(R.layout.edu_list_item, null);
        TextView schoolTextView = (TextView) educationItem.findViewById(R.id.school);
        TextView degreeMajorTextView = (TextView) educationItem.findViewById(R.id.degree_major);
        TextView timeTextView = (TextView) educationItem.findViewById(R.id.time);

        schoolTextView.setText("北京邮电大学");
        degreeMajorTextView.setText("本科-软件工程");
        timeTextView.setText("2002.7-2006.8");

        educationItem.setPadding(0, 0, 0, 20);

        educationList.addView(educationItem);

        educationItem = inflater.inflate(R.layout.edu_list_item, null);
        schoolTextView = (TextView) educationItem.findViewById(R.id.school);
        degreeMajorTextView = (TextView) educationItem.findViewById(R.id.degree_major);
        timeTextView = (TextView) educationItem.findViewById(R.id.time);

        schoolTextView.setText("北京航空航天大学");
        degreeMajorTextView.setText("本科-软件工程");
        timeTextView.setText("2002.7-2006.8");

        educationList.addView(educationItem);

        this.informationLinearLayout.addView(this.educationLinearLayout);
    }

    /**
     * 设置工作经历
     */
    private void setWork() {
        LayoutInflater inflater = LayoutInflater.from(this);
        this.workLinearLayout = getPersonProfileItem("{fa-suitcase}", "新增项目和实习经历");
        LinearLayout workList = (LinearLayout) this.workLinearLayout.findViewById(R.id.content);

        View workItem = inflater.inflate(R.layout.work_list_item, null);
        TextView positionTextView = (TextView) workItem.findViewById(R.id.position);
        TextView timeTextView = (TextView) workItem.findViewById(R.id.time);
        TextView companyTextView = (TextView) workItem.findViewById(R.id.company);

        positionTextView.setText("经理");
        timeTextView.setText("2002.7-2006.8");
        companyTextView.setText("北京职圈科技有限公司");

        workItem.setPadding(0, 0, 0, 20);

        workList.addView(workItem);

        this.informationLinearLayout.addView(this.workLinearLayout);
    }

    /**
     * 获得一个新的个人资料模块
     *
     * @param icon 模块图标
     * @param edit 模块编辑按钮内容
     * @return
     */
    private LinearLayout getPersonProfileItem(String icon, String edit) {
        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.person_profile_item, null);

        TextView iconTextView = (TextView) linearLayout.findViewById(R.id.icon);
        TextView editTextView = (TextView) linearLayout.findViewById(R.id.edit);

        iconTextView.setText(icon);
        editTextView.setText(edit);

        return linearLayout;
    }

    @Override
    public void onScrollChanged(ObservableScrollView sV, int x, int y, int oldx, int oldy) {
        if (sV == scrollView) {

            if (y == 0) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
            } else {
                toolbar.setBackgroundColor(getResources().getColor(R.color.green));
            }
        }
    }
}
