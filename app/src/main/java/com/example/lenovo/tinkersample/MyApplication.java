package com.example.lenovo.tinkersample;

import android.app.Application;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

@DefaultLifeCycle(
        application = "com.example.lenovo.thinkersample.MyApplication",             //application name to generate
        flags = ShareConstants.TINKER_ENABLE_ALL)                                //tinkerFlags above
public class MyApplication extends TinkerApplication {
    protected MyApplication(int tinkerFlags, String delegateClassName, String loaderClassName, boolean tinkerLoadVerifyFlag) {
        super(tinkerFlags, delegateClassName, loaderClassName, tinkerLoadVerifyFlag);
    }
    /* you also can initialize this way
    protected MyApplication() {
        super(
                //tinkerFlags, which types is supported
                //dex only, library only, all support
                ShareConstants.TINKER_ENABLE_ALL,
                // This is passed as a string so the shell application does not
                // have a binary dependency on your ApplicationLifeCycle class.
                "com.example.lenovo.thinkersample.MyApplication");
    }*/
}
