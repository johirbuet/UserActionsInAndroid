package com.johir.useraction.useraction.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by mislam on 7/2/17.
 */

public class SimpleDialogFragment extends DialogFragment {
    private final String TAG = "AUC_SIMPLE";
    private SimpleDialogListener mHost;

    public interface SimpleDialogListener {
        public void onPositiveResult(android.support.v4.app.DialogFragment dlg);
        public void onNegativeResult(android.support.v4.app.DialogFragment dlg);
        public void onNeutralResult(android.support.v4.app.DialogFragment dlg);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Peas Preference");
        builder.setMessage("Do you like sugar snap peas?");
        builder.setPositiveButton("Sure!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG, "Positive button clicked");
                mHost.onPositiveResult(SimpleDialogFragment.this);
            }
        });
        builder.setNegativeButton("No way!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG, "Negative button clicked");
                mHost.onNegativeResult(SimpleDialogFragment.this);
            }
        });
        builder.setNeutralButton("Not Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG, "Neutral button clicked");
                mHost.onNeutralResult(SimpleDialogFragment.this);
            }
        });
        return builder.create();
    }

    @Override
    public void onCancel(DialogInterface dlg) {
        super.onCancel(dlg);
        Log.i(TAG, "Dialog cancelled");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mHost = (SimpleDialogListener)activity;
    }
}
