/*
 * Copyright 2014 wada811
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package at.wada811.android.dialogfragments.sample.alertdialogfragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import at.wada811.android.dialogfragments.interfaces.DialogFragmentCallback;
import at.wada811.android.dialogfragments.interfaces.DialogFragmentCallbackProvider;
import at.wada811.android.dialogfragments.interfaces.DialogFragmentInterface;
import at.wada811.android.dialogfragments.interfaces.SimpleDialogFragmentCallback;
import at.wada811.android.dialogfragments.sample.Const;
import at.wada811.android.dialogfragments.sample.R;

public class AlertDialogFragmentExamplesActivity extends ActionBarActivity
    implements DialogFragmentCallbackProvider{

    final AlertDialogFragmentExamplesActivity self = this;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        boolean isInActivity = getIntent().getBooleanExtra(Const.KEY_IS_IN_ACTIVITY, true);
        getSupportActionBar().setTitle(isInActivity ? R.string.title_activity_alert_dialog_fragment_examples_in_activity : R.string.title_activity_alert_dialog_fragment_examples_in_fragment);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(
                android.R.id.content, AlertDialogFragmentExamplesFragment.newInstance(isInActivity)
            ).commit();
        }
    }

    @Override
    public DialogFragmentCallback getDialogFragmentCallback(){
        return new SimpleDialogFragmentCallback(){
            @Override
            public void onShow(DialogFragmentInterface dialog){
                String text = "onShow";
                Log.v(dialog.getTag(), text);
                Toast.makeText(self, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(DialogFragmentInterface dialog){
                String text = "onCancel";
                Log.v(dialog.getTag(), text);
                Toast.makeText(self, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDismiss(DialogFragmentInterface dialog){
                String text = "onDismiss";
                Log.v(dialog.getTag(), text);
                Toast.makeText(self, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickPositive(DialogFragmentInterface dialog){
                String text = "onClickPositive";
                Log.v(dialog.getTag(), text);
                Toast.makeText(self, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickNeutral(DialogFragmentInterface dialog){
                String text = "onClickNeutral";
                Log.v(dialog.getTag(), text);
                Toast.makeText(self, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickNegative(DialogFragmentInterface dialog){
                String text = "onClickNegative";
                Log.v(dialog.getTag(), text);
                Toast.makeText(self, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onKey(DialogFragmentInterface dialog, int keyCode, KeyEvent event){
                String text = "onKey[keyCode: " + keyCode + ", KeyEvent: " + event + "]";
                Log.v(dialog.getTag(), text);
                Toast.makeText(self, text, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onItemClick(DialogFragmentInterface dialog, int position){
                Bundle extra = dialog.getExtra();
                String[] items = extra.getStringArray("items");
                String text = "onItemClick[position: " + position + ", item: " + items[position] + "]";
                Log.v(dialog.getTag(), text);
                Toast.makeText(self, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public ListAdapter getAdapter(DialogFragmentInterface dialog){
                String[] items = new String[]{
                    AlertDialog.class.getSimpleName(),
                    CharacterPickerDialog.class.getSimpleName(),
                    ProgressDialog.class.getSimpleName(),
                    DatePickerDialog.class.getSimpleName(),
                    TimePickerDialog.class.getSimpleName(),
                };
                Bundle extra = new Bundle();
                extra.putStringArray("items", items);
                dialog.setExtra(extra);
                return new ArrayAdapter<String>(self, android.R.layout.simple_list_item_1, items);
            }

            @Override
            public void onSingleChoiceClick(DialogFragmentInterface dialog, int position){
                Bundle extra = dialog.getExtra();
                String[] items = extra.getStringArray("items");
                String text = "onSingleChoiceClick[position: " + position + ", item: " + items[position] + "]";
                Log.v(dialog.getTag(), text);
                Toast.makeText(self, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMultiChoiceClick(DialogFragmentInterface dialog, int position, boolean isChecked){
                Bundle extra = dialog.getExtra();
                String[] items = extra.getStringArray("items");
                String text = "onMultiChoiceClick[position: " + position + ", item: " + items[position] + ", isChecked: " + isChecked + "]";
                Log.v(dialog.getTag(), text);
                Toast.makeText(self, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public View getCustomTitle(DialogFragmentInterface dialog){
                TextView titleView = new TextView(self);
                titleView.setText(dialog.getTag());
                titleView.setPadding(0, 24, 0, 24);
                titleView.setGravity(Gravity.CENTER);
                titleView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
                return titleView;
            }

            @Override
            public View getView(DialogFragmentInterface dialog){
                ImageView imageView = new ImageView(self);
                imageView.setImageResource(R.drawable.ic_launcher);
                imageView.setPadding(0, 24, 0, 24);
                return imageView;
            }
        };
    }
}
