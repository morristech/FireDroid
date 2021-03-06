package blog.ugurcan.firedroid;

import android.app.Activity;
import android.content.Context;

import java.lang.ref.WeakReference;

import blog.ugurcan.firedroid.auth.FireAuth;
import blog.ugurcan.firedroid.auth.IFireAuth;
import blog.ugurcan.firedroid.auth._IFireAuth;
import blog.ugurcan.firedroid.db.FireDb;
import blog.ugurcan.firedroid.db.IFireDb;
import blog.ugurcan.firedroid.db._IFireDb;

/**
 * Created by ugurcan on 28.12.2017.
 */
public class FireDroid {

    private static WeakReference<Context> mAppContext;
    private static WeakReference<Activity> mCurrentActivity;

    private static _IFireAuth mAuth;
    private static _IFireDb mDb;

    /*
     * AUTH
     */
    public static IFireAuth auth() {
        return mAuth;
    }

    static _IFireAuth _auth() {
        return mAuth;
    }

    public static void setAuth(FireAuth auth) {
        mAuth = auth;
    }

    /*
     * DB
     */
    public static IFireDb db() {
        return mDb;
    }

    static _IFireDb _db() {
        return mDb;
    }

    public static void setDb(FireDb db) {
        mDb = db;
    }

    /*
     * INIT
     */
    public static void init(Context appContext) {
        mAppContext = new WeakReference<>(appContext);
    }

    public static FireAuth.Initializer authInitializer() {
        return new FireAuth.Initializer();
    }

    public static FireDb.Initializer dbInitializer() {
        return new FireDb.Initializer();
    }

    public static Context appContext() {
        return mAppContext.get();
    }

    public static Activity currentActivity() {
        return mCurrentActivity.get();
    }

    static void setCurrentActivity(Activity activity) {
        nullifyCurrentActivity();
        mCurrentActivity = new WeakReference<>(activity);
    }

    private static void nullifyCurrentActivity() {
        if (mCurrentActivity != null) {
            mCurrentActivity.clear();
            mCurrentActivity = null;
        }
    }

}
