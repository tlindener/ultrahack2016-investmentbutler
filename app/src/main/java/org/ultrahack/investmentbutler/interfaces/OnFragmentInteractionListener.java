package org.ultrahack.investmentbutler.interfaces;

import android.net.Uri;

/**
 * Created by tobias on 25.11.2016.
 */

public interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);

    void invokeBtnInvest(String fragmentName,String riskLevel);

    void invokeBtnNext(String ibm);
}
