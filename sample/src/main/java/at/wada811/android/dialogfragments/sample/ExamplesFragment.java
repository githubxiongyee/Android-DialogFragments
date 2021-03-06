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

package at.wada811.android.dialogfragments.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import at.wada811.android.dialogfragments.sample.alertdialogfragment.AlertDialogFragmentExamplesActivity;
import at.wada811.android.dialogfragments.sample.datepickerdialogfragment.DatePickerDialogFragmentExamplesActivity;
import at.wada811.android.dialogfragments.sample.dialogfragmentcallbackprovider.DialogFragmentCallbackProviderActivity;
import at.wada811.android.dialogfragments.sample.numberpickerdialogfragment.NumberPickerDialogFragmentExamplesActivity;
import at.wada811.android.dialogfragments.sample.progressdialogfragment.ProgressDialogFragmentExamplesActivity;
import at.wada811.android.dialogfragments.sample.stringpickerdialogfragment.StringPickerDialogFragmentExamplesActivity;
import at.wada811.android.dialogfragments.sample.timepickerdialogfragment.TimePickerDialogFragmentExamplesActivity;

public class ExamplesFragment extends ListFragment{

    private ArrayList<Examples> items;

    public static ExamplesFragment newInstance(){
        ExamplesFragment fragment = new ExamplesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        initExamples();
        setListAdapter(
            new ArrayAdapter<Examples>(
                getActivity(), android.R.layout.simple_list_item_1, items
            )
        );
    }

    private void initExamples(){
        items = new ArrayList<Examples>();
        {
            items.add(
                new Examples(
                    getString(R.string.title_activity_dialog_fragment_callback_provider),
                    new Intent(getActivity(), DialogFragmentCallbackProviderActivity.class)
                )
            );
        }
        {
            Intent intent = new Intent(
                getActivity(), AlertDialogFragmentExamplesActivity.class
            );
            intent.putExtra(Const.KEY_IS_IN_ACTIVITY, true);
            items.add(
                new Examples(
                    getString(R.string.title_activity_alert_dialog_fragment_examples_in_activity),
                    intent
                )
            );
        }
        {
            Intent intent = new Intent(
                getActivity(), AlertDialogFragmentExamplesActivity.class
            );
            intent.putExtra(Const.KEY_IS_IN_ACTIVITY, false);
            items.add(
                new Examples(
                    getString(R.string.title_activity_alert_dialog_fragment_examples_in_fragment),
                    intent
                )
            );
        }
        {
            items.add(
                new Examples(
                    getString(R.string.title_activity_progress_dialog_fragment_examples),
                    new Intent(
                        getActivity(), ProgressDialogFragmentExamplesActivity.class
                    )
                )
            );
        }
        {
            Intent intent = new Intent(
                getActivity(), DatePickerDialogFragmentExamplesActivity.class
            );
            intent.putExtra(Const.KEY_IS_IN_ACTIVITY, true);
            items.add(
                new Examples(
                    getString(R.string.title_activity_date_picker_dialog_fragment_examples_in_activity),
                    intent
                )
            );
        }
        {
            Intent intent = new Intent(
                getActivity(), DatePickerDialogFragmentExamplesActivity.class
            );
            intent.putExtra(Const.KEY_IS_IN_ACTIVITY, false);
            items.add(
                new Examples(
                    getString(R.string.title_activity_date_picker_dialog_fragment_examples_in_fragment),
                    intent
                )
            );
        }
        {
            Intent intent = new Intent(
                getActivity(), TimePickerDialogFragmentExamplesActivity.class
            );
            intent.putExtra(Const.KEY_IS_IN_ACTIVITY, true);
            items.add(
                new Examples(
                    getString(R.string.title_activity_time_picker_dialog_fragment_examples_in_activity),
                    intent
                )
            );
        }
        {
            Intent intent = new Intent(
                getActivity(), TimePickerDialogFragmentExamplesActivity.class
            );
            intent.putExtra(Const.KEY_IS_IN_ACTIVITY, false);
            items.add(
                new Examples(
                    getString(R.string.title_activity_time_picker_dialog_fragment_examples_in_fragment),
                    intent
                )
            );
        }
        {
            Intent intent = new Intent(
                getActivity(), NumberPickerDialogFragmentExamplesActivity.class
            );
            intent.putExtra(Const.KEY_IS_IN_ACTIVITY, true);
            items.add(
                new Examples(
                    getString(R.string.title_activity_number_picker_dialog_fragment_examples_in_activity),
                    intent
                )
            );
        }
        {
            Intent intent = new Intent(
                getActivity(), NumberPickerDialogFragmentExamplesActivity.class
            );
            intent.putExtra(Const.KEY_IS_IN_ACTIVITY, false);
            items.add(
                new Examples(
                    getString(R.string.title_activity_number_picker_dialog_fragment_examples_in_fragment),
                    intent
                )
            );
        }
        {
            Intent intent = new Intent(
                getActivity(), StringPickerDialogFragmentExamplesActivity.class
            );
            intent.putExtra(Const.KEY_IS_IN_ACTIVITY, true);
            items.add(
                new Examples(
                    getString(R.string.title_activity_string_picker_dialog_fragment_examples_in_activity),
                    intent
                )
            );
        }
        {
            Intent intent = new Intent(
                getActivity(), StringPickerDialogFragmentExamplesActivity.class
            );
            intent.putExtra(Const.KEY_IS_IN_ACTIVITY, false);
            items.add(
                new Examples(
                    getString(R.string.title_activity_string_picker_dialog_fragment_examples_in_fragment),
                    intent
                )
            );
        }
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Examples item = items.get(position);
        startActivity(item.intent);
    }

}
