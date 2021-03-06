/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.settings.core;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;

public class TouchOverlayManager {

    private final Context mContext;
    private final IBinder mToken = new Binder();

    public TouchOverlayManager(Context context) {
        mContext = context;
    }

    public void setOverlayAllowed(boolean allowed) {
        final AppOpsManager aom = mContext.getSystemService(AppOpsManager.class);
        if (aom != null) {
            aom.setUserRestriction(AppOpsManager.OP_SYSTEM_ALERT_WINDOW, !allowed, mToken);
            aom.setUserRestriction(AppOpsManager.OP_TOAST_WINDOW, !allowed, mToken);
        }
    }
}
