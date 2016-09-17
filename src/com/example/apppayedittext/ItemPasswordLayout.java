package com.example.apppayedittext;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * ���������Ŀؼ�����
 * ����ֻ��һ��edittext��edittext������ֻ�ǻ�ȡ�û�������ַ�������λ����imageview������
 * ��û�������ò�ͬimageview�滻����ƺ�����
 * Created by Went_Gone on 2016/9/14.
 */
public class ItemPasswordLayout extends RelativeLayout{
 private EditText editText;
 private ImageView[] imageViews;//ʹ��һ������洢�����
 private StringBuffer stringBuffer = new StringBuffer();//�洢�����ַ�
 private int count = 6;
 private String strPassword;//�����ַ���
 
 public ItemPasswordLayout(Context context) {
  this(context,null);
 }
 
 public ItemPasswordLayout(Context context, AttributeSet attrs) {
  this(context, attrs,0);
 }
 
 public ItemPasswordLayout(Context context, AttributeSet attrs, int defStyleAttr) {
  super(context, attrs, defStyleAttr);
  imageViews = new ImageView[6];
  View view = View.inflate(context, R.layout.activity_main,this);
 
  editText = (EditText) findViewById(R.id.item_edittext);
  imageViews[0] = (ImageView) findViewById(R.id.item_password_iv1);
  imageViews[1] = (ImageView) findViewById(R.id.item_password_iv2);
  imageViews[2] = (ImageView) findViewById(R.id.item_password_iv3);
  imageViews[3] = (ImageView) findViewById(R.id.item_password_iv4);
  imageViews[4] = (ImageView) findViewById(R.id.item_password_iv5);
  imageViews[5] = (ImageView) findViewById(R.id.item_password_iv6);
 
  editText.setCursorVisible(false);//���������
  setListener();
 }
 
 private void setListener() {
  editText.addTextChangedListener(new TextWatcher() {
   @Override
   public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
 
   }
 
   @Override
   public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
 
   }
 
   @Override
   public void afterTextChanged(Editable editable) {
    //�ص� ����ַ���Ϊ""ʱ�Ž��в���
    if (!editable.toString().equals("")) {
     if (stringBuffer.length()>5){
      //�����볤�ȴ���5λʱedittext�ÿ�
      editText.setText("");
      return;
     }else {
      //��������ӵ�StringBuffer��
      stringBuffer.append(editable);
      editText.setText("");//��Ӻ�EditText�ÿ� ���û����������Ĵ��
      Log.e("TAG", "afterTextChanged: stringBuffer is "+stringBuffer);
      count = stringBuffer.length();//��¼stringbuffer�ĳ���
      strPassword = stringBuffer.toString();
      if (stringBuffer.length()==6){
       //���ֳ���λ6 ������������ļ���
       if (inputCompleteListener!=null){
        inputCompleteListener.inputComplete();
       }
      }
     }
 
     for (int i =0;i<stringBuffer.length();i++){
      imageViews[i].setImageResource(R.drawable.ic_launcher);
      imageViews[i].setBackgroundResource(R.drawable.no);
     }
    }
   }
  });
  editText.setOnKeyListener(new OnKeyListener() {
   @Override
   public boolean onKey(View v, int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_DEL
      && event.getAction() == KeyEvent.ACTION_DOWN) {
     Log.e("TAG", "afterTextChanged: stringBuffer is "+stringBuffer);
     if (onKeyDelete()) return true;
     return true;
    }
    return false;
   }
  });
 }
 
 public boolean onKeyDelete() {
  if (count==0){
   count = 6;
   return true;
  }
  if (stringBuffer.length()>0){
   //ɾ����Ӧλ�õ��ַ�
   stringBuffer.delete((count-1),count);
   count--;
   Log.e("TAG", "afterTextChanged: stringBuffer is "+stringBuffer);
   strPassword = stringBuffer.toString();
   imageViews[stringBuffer.length()].setImageResource(R.drawable.no);
 
  }
  return false;
 }
 
 @Override
 public boolean onKeyDown(int keyCode, KeyEvent event) {
  return super.onKeyDown(keyCode, event);
 }
 
 private InputCompleteListener inputCompleteListener;
 
 public void setInputCompleteListener(InputCompleteListener inputCompleteListener) {
  this.inputCompleteListener = inputCompleteListener;
 }
 
	public interface InputCompleteListener {
  void inputComplete();
 }
 
 public EditText getEditText() {
  return editText;
 }
 
 /**
  * ��ȡ����
  * @return
  */
 public String getStrPassword() {
  return strPassword;
 }
 
 public void setContent(String content){
  editText.setText(content);
 }
}
